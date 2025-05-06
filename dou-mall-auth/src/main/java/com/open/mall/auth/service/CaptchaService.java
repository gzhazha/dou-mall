package com.open.mall.auth.service;

import com.open.mall.auth.domain.dto.CheckCaptchaDto;
import com.open.mall.auth.domain.dto.SendCaptchaDto;
import com.open.mall.auth.domain.vo.CaptchaStatusVo;

/**
 * CaptchaService
 *
 * @author zhoug
 * @date 2025/4/17 22:15
 */

public interface CaptchaService {
    /**
     * 发送验证码
     *
     * @param sendCaptchaDto 发送验证码请求参数
     */
    void sendCaptcha(SendCaptchaDto sendCaptchaDto);

    /**
     * 校验验证码
     *
     * @param checkCaptchaDto 校验验证码请求参数
     */
    void checkCaptcha(CheckCaptchaDto checkCaptchaDto);
    
    /**
     * 获取验证码状态
     *
     * @param identifier 标识符，通常是手机号
     * @return 验证码状态信息
     */
    CaptchaStatusVo getCaptchaStatus(String identifier);
}
