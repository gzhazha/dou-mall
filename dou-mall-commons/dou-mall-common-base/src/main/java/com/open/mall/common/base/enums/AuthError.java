package com.open.mall.common.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AuthError
 *
 * @author zhoug
 * @date 2025/4/28 15:55
 */
@Getter
@AllArgsConstructor
public enum AuthError implements ErrorCode {
    //-------验证码
    UNSUPPORTED_ACCOUNT_TYPES(20001,"不支持的账户类型"),
    VERIFICATION_CODE_HAS_EXPIRED(20002,"验证码已失效"),
    VERIFICATION_CODE_MISMATCH(20003,"验证码不匹配"),
    VERIFICATION_CODE_SEND_TOO_FREQUENTLY(20004,"验证码发送过于频繁，请稍后再试"),
    VERIFICATION_CODE_DAILY_LIMIT_EXCEEDED(20005,"验证码发送次数超过每日限制"),
    VERIFICATION_CODE_IP_LIMIT_EXCEEDED(20006,"验证码发送次数超过IP限制"),
    VERIFICATION_CODE_MAX_ATTEMPTS_EXCEEDED(20007,"验证码尝试次数过多，请重新获取验证码"),

    //-------登录
    NO_USER_INFORMATION(20010,"未获取到用户信息"),
    USER_IS_DISABLED(20011,"用户被禁用"),

    ACCESS_CODE_LOGIN_ERROR(-401, "授权码错误"),
    REFRESH_CODE_LOGIN_ERROR(-402, "刷新授权码错误"),

    ;


    private final Integer code;
    private final String msg;
}
