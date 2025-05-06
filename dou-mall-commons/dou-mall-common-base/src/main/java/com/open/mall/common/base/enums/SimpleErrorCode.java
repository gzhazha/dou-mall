package com.open.mall.common.base.enums;


/**
 * SimpleErrorCode
 *
 * @author zhoug
 * @date 2025/5/6 18:20
 */
public record SimpleErrorCode(Integer code, String msg) implements ErrorCode {
    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
