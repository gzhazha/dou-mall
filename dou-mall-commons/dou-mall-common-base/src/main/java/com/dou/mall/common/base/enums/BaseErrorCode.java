package com.dou.mall.common.base.enums;

/**
 * ResultStatus
 *
 * @author zhoug
 * @date 2025/2/17 14:49
 */

public enum BaseErrorCode implements BaseCode {
    SUCCESSFUL(1, "success"),
    FAILED(0, "fail"),
    UNKNOWN_ERROR(1001, "未知错误"),
    SYSTEM_ERROR(1001, "系统错误"),
    ILLEGAL_PARAM(1002, "参数错误"),
    ILLEGAL_REQUEST(1003,"非法请求"),
    FORBIDDEN(1003,"拒绝访问"),
    RESOURCE_NOT_EXISTS(1004,"资源不存在"),
    ;

    private final int code;
    private final String msg;

    BaseErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
