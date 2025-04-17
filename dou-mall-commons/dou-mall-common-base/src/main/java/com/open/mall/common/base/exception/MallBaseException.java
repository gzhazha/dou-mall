package com.open.mall.common.base.exception;

import com.open.mall.common.base.enums.ResultCode;
import lombok.Getter;

/**
 * MallBaseException
 *
 * @author zhoug
 * @date 2025/4/17 09:54
 */

@Getter
public class MallBaseException extends Exception {
    private ResultCode resultCode;
    private String msg;

    public MallBaseException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
        this.msg = resultCode.getMsg();
    }

    public MallBaseException(ResultCode resultCode, Throwable cause) {
        super(resultCode.getMsg(), cause);
        this.resultCode = resultCode;
        this.msg = resultCode.getMsg();
    }

    public MallBaseException(ResultCode resultCode, String msg) {
        super(msg);
        this.resultCode = resultCode;
        this.msg = msg;
    }

    public MallBaseException(ResultCode resultCode, String msg, Throwable cause) {
        super(msg, cause);
        this.resultCode = resultCode;
        this.msg = msg;
    }

    public MallBaseException() {
        super();
    }
}
