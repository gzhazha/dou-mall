package com.dou.mall.common.base.exception;

import com.dou.mall.common.base.enums.BaseCode;
import lombok.Getter;

/**
 * DouMallException
 *
 * @author zhoug
 * @date 2025/2/17 14:45
 */


@Getter
public class DouMallException extends RuntimeException {

    private BaseCode baseCode;
    private Integer code;
    private String msg;

    public DouMallException(BaseCode baseCode) {
        super(baseCode.getMsg());
        this.baseCode = baseCode;
        this.code = baseCode.getCode();
        this.msg = baseCode.getMsg();
    }

    public DouMallException(BaseCode baseCode,String msg) {
        super(msg);
        this.baseCode = baseCode;
        this.code = baseCode.getCode();
        this.msg = msg;
    }

    public DouMallException(String message, Throwable cause) {
        super(message, cause);
    }

}
