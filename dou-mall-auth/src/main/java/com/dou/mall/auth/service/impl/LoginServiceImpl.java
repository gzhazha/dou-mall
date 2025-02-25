package com.dou.mall.auth.service.impl;

import com.dou.mall.api.auth.bo.AuthUserInfoBo;
import com.dou.mall.api.auth.vo.TokenInfoVo;
import com.dou.mall.api.user.api.UserFeignClient;
import com.dou.mall.api.user.model.vo.UserInfoVo;
import com.dou.mall.auth.enums.AuthErrorEnum;
import com.dou.mall.auth.model.dto.LoginDto;
import com.dou.mall.auth.service.LoginService;
import com.dou.mall.auth.model.vo.LoginInfoVo;
import com.dou.mall.auth.strategy.login.LoginStrategy;
import com.dou.mall.common.base.exception.DouMallException;
import com.dou.mall.common.base.vo.ResponseEntity;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * LoginServiceImpl
 *
 * @author zhoug
 * @date 2025/2/19 19:04
 */

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private List<LoginStrategy> loginStrategies;
    @Resource
    private UserFeignClient userFeignClient;


    @Override
    public LoginInfoVo login(LoginDto loginDto) {
        TokenInfoVo tokenInfoVo = loginStrategies
                .stream()
                .filter(s -> s.support(loginDto.getLoginType()))
                .findAny()
                .orElseThrow(() -> new DouMallException(AuthErrorEnum.INVALID_LOGIN_TYPE))
                .createAndStoreToken(loginDto);
        UserInfoVo userInfoVo = Optional.ofNullable(userFeignClient.getUserInfoVoByUserId(tokenInfoVo.getUserId()))
                .map(ResponseEntity::getData)
                .orElseThrow(() -> new DouMallException(AuthErrorEnum.INVALID_USER));
        LoginInfoVo loginInfoVo = new LoginInfoVo();
        AuthUserInfoBo authUserInfoBo = new AuthUserInfoBo();
        BeanUtils.copyProperties(userInfoVo, authUserInfoBo);
        loginInfoVo.setTokenInfoVo(tokenInfoVo);
        loginInfoVo.setAuthUserInfoBo(authUserInfoBo);
        return loginInfoVo;
    }
}
