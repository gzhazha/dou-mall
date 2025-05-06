package com.open.mall.common.base.enums;

/**
 * ResultCode
 *
 * @author zhoug
 * @date 2025/4/17 09:51
 */

public interface ErrorCode {
    /**
     * 获取返回码
     * @return 错误码
     */
    Integer getCode();

    /**
     * 获取响应信息
     * @return 错误信息
     */
    String getMsg();

    default ErrorCode format(Object... args) {
        String msg = String.format(this.getMsg(), args);
        Integer code = this.getCode();
        return new SimpleErrorCode(code,msg);
    }

    // 获取错误类型
    default ErrorType getErrorType() {
        int code = getCode();
        if (code >= 10000 && code < 20000) {
            return ErrorType.SYSTEM;
        } else if (code >= 20000 && code < 30000) {
            return ErrorType.AUTH;
        } else if (code >= 30000 && code < 40000) {
            return ErrorType.USER;
        }
        return ErrorType.UNKNOWN;
    }

    enum ErrorType {
        SYSTEM,
        AUTH,
        USER,
        UNKNOWN,
        ;
    }

}
