package com.open.mall.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.open.mall.api.user.domain.dto.UserRegisterDto;
import com.open.mall.api.user.domain.vo.UserInfoVo;
import com.open.mall.api.user.feign.UserFeign;
import com.open.mall.auth.domain.dto.LoginDto;
import com.open.mall.auth.domain.po.AuthToken;
import com.open.mall.auth.domain.po.RefreshToken;
import com.open.mall.auth.domain.po.UserAuth;
import com.open.mall.auth.domain.vo.TokenInfoVo;
import com.open.mall.auth.manager.TokenManager;
import com.open.mall.auth.mapper.UserAuthMapper;
import com.open.mall.auth.service.LoginService;
import com.open.mall.common.base.doman.vo.BaseResult;
import com.open.mall.common.base.enums.CommonCodeEnum;
import com.open.mall.common.base.enums.StatusEnum;
import com.open.mall.common.base.enums.auth.AuthTypeEnum;
import com.open.mall.common.base.utils.DouAssertion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;


/**
 * LoginServiceImpl
 *
 * @author zhoug
 * @date 2025/8/26 10:05
 */

@RequiredArgsConstructor
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    private final UserAuthMapper userAuthMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenManager tokenManager;
    private final UserFeign userFeign;

    @Override
    public TokenInfoVo login(LoginDto loginDto) {
        AuthTypeEnum authType = AuthTypeEnum.getByType(loginDto.getAuthType());
        DouAssertion.notNull(authType, CommonCodeEnum.BAD_REQUEST.format("登陆类型错误"));
        LambdaQueryWrapper<UserAuth> wrapper = Wrappers.<UserAuth>lambdaQuery()
                .eq(UserAuth::getAuthType, authType.getType())
                .eq(UserAuth::getIdentifier, loginDto.getIdentifier());
        UserAuth userAuth = userAuthMapper.selectOne(wrapper);
        if (userAuth == null) {
            DouAssertion.isTrue(AuthTypeEnum.isDirectly(authType), CommonCodeEnum.ACCESS_DENIED.format("用户未注册"));
            UserRegisterDto userRegisterDto = new UserRegisterDto();
            userRegisterDto.setAuthType(loginDto.getAuthType());
            userRegisterDto.setIdentifier(loginDto.getIdentifier());
            BaseResult<UserInfoVo> register = userFeign.register(userRegisterDto);
            Long userId = Optional.ofNullable(register)
                    .filter(BaseResult::isSuccess)
                    .map(BaseResult::getData)
                    .map(UserInfoVo::getUserId)
                    .orElse(null);
            DouAssertion.notNull(userId,CommonCodeEnum.INTERNAL_SERVER_ERROR.format("注册失败"));
            UserAuth save = new UserAuth();
            save.setIdentifier(loginDto.getIdentifier());
            save.setAuthType(loginDto.getAuthType());
            save.setUserId(userId);
            save.setCredential(passwordEncoder.encode(loginDto.getCredential()));
            save.setStatus(StatusEnum.VALID.getStatus());
            userAuthMapper.insert(save);
            wrapper = Wrappers.<UserAuth>lambdaQuery()
                    .eq(UserAuth::getAuthType, authType.getType())
                    .eq(UserAuth::getUserId, userId)
                    .eq(UserAuth::getIdentifier, loginDto.getIdentifier());
            userAuth = userAuthMapper.selectOne(wrapper);
        }
        DouAssertion.notNull(userAuth,CommonCodeEnum.ACCESS_DENIED.format("用户未注册"));
        DouAssertion.isTrue(StatusEnum.isValid(userAuth.getStatus()),CommonCodeEnum.ACCOUNT_DISABLED);
        boolean matches = passwordEncoder.matches(userAuth.getCredential(), loginDto.getCredential());
        DouAssertion.isTrue(matches, CommonCodeEnum.ACCESS_DENIED.format("密码错误"));
        String authCode = String.format("%s/%s", loginDto.getIdentifier(), loginDto.getCredential());
        return buildTokenInfoVo(userAuth.getUserId(),authCode,authType);
    }

    private TokenInfoVo buildTokenInfoVo(Long userId,String authCode,AuthTypeEnum authType) {
        DouAssertion.notNull(userId,CommonCodeEnum.TOKEN_EXPIRED);
        RefreshToken refreshToken = tokenManager.createRefreshToken(userId, authCode, authType);
        AuthToken authToken = tokenManager.createAuthToken(refreshToken.getRefreshToken());
        TokenInfoVo tokenInfoVo = new TokenInfoVo();
        tokenInfoVo.setAccessToken(authToken.getAccessToken());
        tokenInfoVo.setRefreshToken(refreshToken.getRefreshToken());
        tokenInfoVo.setTokenType(authType.getType());
        tokenInfoVo.setUserId(refreshToken.getUserId());
        tokenInfoVo.setExpiresIn(getExpiresIn(authToken.getExpiredAt()));
        tokenInfoVo.setRefreshExpiresIn(getExpiresIn(refreshToken.getExpiredAt()));

        return tokenInfoVo;
    }

    /**
     * LocalDateTime转换成时间戳
     *
     * @param dateTime {@link LocalDateTime}
     * @return dateTime为空时使用当前时间
     */
    private long getExpiresIn(LocalDateTime dateTime) {
        if (dateTime == null) {
            dateTime = LocalDateTime.now();
        }
        return dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }
}
