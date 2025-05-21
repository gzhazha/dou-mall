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
public enum UserError implements ErrorCode {

    REGISTER_ERROR(30001, "注册失败"),
    REGISTER_ERROR1(30001, "注册失败,%s"),
    ;


    private final Integer code;
    private final String msg;
}
