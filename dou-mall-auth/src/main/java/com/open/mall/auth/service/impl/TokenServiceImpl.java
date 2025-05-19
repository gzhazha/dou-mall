package com.open.mall.auth.service.impl;

import com.open.mall.api.auth.domain.bo.UserInfoInTokenBo;
import com.open.mall.api.auth.domain.dto.CaptchaLoginDto;
import com.open.mall.api.auth.domain.dto.PasswordLoginDto;
import com.open.mall.api.auth.enums.CaptchaChannel;
import com.open.mall.api.auth.domain.vo.TokenInfoVo;
import com.open.mall.api.user.domain.bo.UserInfoBo;
import com.open.mall.api.user.enums.UserStatus;
import com.open.mall.api.user.feign.UserFeignClient;
import com.open.mall.auth.dao.manager.AuthUserManager;
import com.open.mall.auth.dao.manager.CredentialsPasswordManager;
import com.open.mall.auth.enums.LoginType;
import com.open.mall.auth.service.TokenService;
import com.open.mall.auth.utils.CaptchaUtil;
import com.open.mall.auth.utils.TokenUtil;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.common.base.enums.AuthError;
import com.open.mall.common.base.enums.SystemError;
import com.open.mall.common.base.exception.MallBaseException;
import com.open.mall.common.base.utils.MallAssert;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * TokenServiceImpl
 *
 * @author zhoug
 * @date 2025/4/28 15:35
 */


@Slf4j
@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final UserFeignClient userFeignClient;
    private final AuthUserManager authUserManager;
    private final CredentialsPasswordManager credentialsPasswordManager;
    private final PasswordEncoder passwordEncoder;


    @Override
    public TokenInfoVo buildTokenInfo(CaptchaLoginDto captchaLoginDto) {
        CaptchaUtil.validateCaptcha(captchaLoginDto.getIdentifier(), captchaLoginDto.getCaptcha());
        CaptchaChannel channel = captchaLoginDto.getChannel();
        LoginType loginType;
        if (CaptchaChannel.EMAIL.equals(channel)) {
            loginType = LoginType.EMAIL;
        } else if (CaptchaChannel.MOBILE.equals(channel)) {
            loginType = LoginType.MOBILE;
        } else {
            throw new MallBaseException(SystemError.ILLEGAL_PARAM, "不存在的验证码登录渠道");
        }
        UserInfoBo userInfoBo = getUserInfoBo(loginType, captchaLoginDto.getIdentifier());
        return buildTokenInfoVo(userInfoBo);
    }

    @Override
    public TokenInfoVo buildTokenInfo(PasswordLoginDto passwordLoginDto) {
        UserInfoBo userInfoBo = getUserInfoBo(LoginType.USERNAME, passwordLoginDto.getUsername());
        MallAssert.notNull(userInfoBo, "不存在用户，username:" + passwordLoginDto.getUsername());
        boolean checkedPassword = checkPassword(userInfoBo.getUserId(), passwordLoginDto.getPassword());
        MallAssert.isTrue(checkedPassword, "密码错误");
        return buildTokenInfoVo(userInfoBo);
    }

    private boolean checkPassword(Long userId, String password) {
        String passwordHash = credentialsPasswordManager.getPasswordHashByUserId(userId);
        if (StringUtils.isAnyBlank(password, passwordHash)) {
            return false;
        }
        return passwordEncoder.matches(password, passwordHash);
    }

    private TokenInfoVo buildTokenInfoVo(UserInfoBo userInfoBo) {
        MallAssert.notNull(userInfoBo, AuthError.NO_USER_INFORMATION);
        Integer status = userInfoBo.getStatus();
        UserStatus userStatus = UserStatus.fromStatus(status);
        Long userId = userInfoBo.getUserId();
        TokenInfoVo resultVo = null;
        Boolean isTemporary = null;
        if (UserStatus.INITIALIZED.equals(userStatus) || UserStatus.PENDING_VERIFICATION.equals(userStatus)) {
            isTemporary = true;
        } else if (UserStatus.ACTIVE.equals(userStatus)) {
            isTemporary = false;
        }
        if (isTemporary != null){
            resultVo = TokenUtil.generateToken(userId, false);
        }
        authUserManager.loginRecord(userId,Objects.nonNull(resultVo));
        return resultVo;
    }

    @Override
    public UserInfoInTokenBo checkToken(String token) {
        return TokenUtil.verifyAccessToken(token);
    }

    private UserInfoBo getUserInfoBo(LoginType loginType, String identifier) {
        BaseResult<UserInfoBo> boBaseResult = null;
        if (Objects.equals(LoginType.EMAIL, loginType)) {
            boBaseResult = userFeignClient.getUserInfoByEmail(identifier);
        } else if (Objects.equals(LoginType.MOBILE, loginType)) {
            boBaseResult = userFeignClient.getUserInfoByMobile(identifier);
        } else if (Objects.equals(LoginType.USERNAME, loginType)) {
            boBaseResult = userFeignClient.getUserInfoByUsername(identifier);
        } else {
            log.warn("不支持的登录类型，loginType:{},identifier:{}", loginType, identifier);
        }
        if (boBaseResult == null || !boBaseResult.getSuccess()) {
            return null;
        }
        UserInfoBo data = boBaseResult.getData();
        authUserManager.getOrCreateAuthUser(data.getUserId());
        return data;
    }
}
