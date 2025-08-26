package com.open.mall.common.base.exception;

import com.open.mall.common.base.enums.ResultCode;
import lombok.Getter;

import java.io.Serial;

/**
 * DouException
 *
 * @author zhoug
 * @date 2025/8/25 15:05
 */

@Getter
public class DouException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Integer code;
    private final String msg;
    private ResultCode resultCode;

    public DouException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public DouException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public DouException(ResultCode resultCode, Throwable cause) {
        super(resultCode.getMsg(), cause);
        this.resultCode = resultCode;
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public DouException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }
}
