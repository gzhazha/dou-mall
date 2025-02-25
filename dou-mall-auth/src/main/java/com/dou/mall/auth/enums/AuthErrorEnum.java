package com.dou.mall.auth.enums;

import com.dou.mall.common.base.enums.BaseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AuthErrorEnum
 *
 * @author zhoug
 * @date 2025/2/20 17:37
 */
@AllArgsConstructor
@Getter
public enum AuthErrorEnum implements BaseCode {

    INVALID_LOGIN_TYPE(2001,"无效的登录类型"),
    INVALID_LOGIN_PARAM(2002,"无效的登录参数"),
    VERIFY_CODE_ERROR(2003,"验证码错误"),
    VERIFY_CODE_FAILURE(2003,"验证码失效"),
    INVALID_AUTH_USER(2003,"用户不存在，请先注册"),
    INVALID_USER(2003,"请完善用户信息"),
    ;

    private final int code;
    private final String msg;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
