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
public enum ErrorEnum implements ResultCode{
    UNKNOWN_ERROR(10000,"未知错误"),
    SYSTEM_ERROR(10001,"系统错误"),
    ILLEGAL_REQUEST(10002,"非法请求"),
    ILLEGAL_PARAM(10040,"参数错误"),
    ;

    private final Integer code;
    private final String msg;
}
