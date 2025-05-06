package com.open.mall.common.base.exception;

import com.open.mall.common.base.enums.ErrorCode;
import lombok.Getter;

/**
 * MallBaseException
 *
 * @author zhoug
 * @date 2025/4/17 09:54
 */

@Getter
public class MallBaseException extends RuntimeException {
    private ErrorCode resultCode;
    private String msg;

    public MallBaseException(ErrorCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
        this.msg = resultCode.getMsg();
    }

    public MallBaseException(ErrorCode resultCode, Throwable cause) {
        super(resultCode.getMsg(), cause);
        this.resultCode = resultCode;
        this.msg = resultCode.getMsg();
    }

    public MallBaseException(ErrorCode resultCode, String msg) {
        super(msg);
        this.resultCode = resultCode;
        this.msg = msg;
    }

    public MallBaseException(ErrorCode resultCode, String msg, Throwable cause) {
        super(msg, cause);
        this.resultCode = resultCode;
        this.msg = msg;
    }

    public MallBaseException() {
        super();
    }
}
