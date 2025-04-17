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
public enum ResultEnum implements ResultCode{
    SUCCESS(1,"success"),
    FAIL(0,"fail"),
    ;

    private final Integer code;
    private final String msg;
}
