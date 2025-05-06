package com.open.mall.api.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * CaptchaType
 *
 * @author zhoug
 * @date 2025/4/21 15:40
 */

@AllArgsConstructor
@Getter
public enum CaptchaType {
    REGISTER("register"),
    LOGIN("您的登录验证码为：%s，请于3分钟内输入验证，请勿向他人泄露。工作人员不会以任何方式向您索要短信验证码，谨防欺诈短信。"),
    RESET_PASSWORD(""),
    ;
    private final String msg;
}
