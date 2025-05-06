package com.open.mall.auth.service;

import com.open.mall.api.auth.domain.bo.UserInfoInTokenBo;
import com.open.mall.api.auth.domain.dto.CaptchaLoginDto;
import com.open.mall.api.auth.domain.dto.PasswordLoginDto;
import com.open.mall.api.auth.domain.vo.TokenInfoVo;

/**
 * TokenService
 *
 * @author zhoug
 * @date 2025/4/28 15:32
 */

public interface TokenService {
    /**
     * 验证码获取token
     * @param captchaLoginDto 验证码登录参数
     * @return {@link TokenInfoVo}
     */
    TokenInfoVo buildTokenInfo(CaptchaLoginDto captchaLoginDto);

    /**
     * 获取token
     * @param passwordLoginDto 用户名密码登录参数
     * @return {@link TokenInfoVo}
     */
    TokenInfoVo buildTokenInfo(PasswordLoginDto passwordLoginDto);

    /**
     * 校验token
     * @param token
     * @return
     */
    UserInfoInTokenBo checkToken(String token);
}
