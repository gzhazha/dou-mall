package com.open.mall.common.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ResultEnum
 *
 * @author zhoug
 * @date 2025/4/17 09:52
 */
@Getter
@AllArgsConstructor
public enum SystemError implements ErrorCode {
    UNKNOWN_ERROR(10000, "未知错误"),
    SYSTEM_ERROR(10001, "系统错误"),
    ILLEGAL_REQUEST(10002, "非法请求"),
    INTERFACE_NOT_EXISTS(10003, "接口不存在"),
    INTERFACE_NOT_EXISTS2(10003, "接口(%s)不存在"),
    ILLEGAL_PARAM(10040, "参数错误"),
    ILLEGAL_PARAM1(10040, "参数错误,%s"),
    SYSTEM_INTERNAL_ERROR(10050, "内部系统错误"),
    SYSTEM_INTERNAL_ERROR1(10050, "内部系统错误,%s"),
    HANDLE_FAILED(10050, "内部系统错误,%s"),
    ;

    private final Integer code;
    private final String msg;
}
