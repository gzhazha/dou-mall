package com.open.mall.common.base.utils;

import com.open.mall.common.base.enums.SystemError;
import com.open.mall.common.base.enums.ErrorCode;
import lombok.experimental.UtilityClass;

/**
 * ResultCodeUtils
 *
 * @author zhoug
 * @date 2025/4/17 11:22
 */
@UtilityClass
public class ResultCodeUtil {
    public static ErrorCode handle(Throwable e) {
        ErrorCode error = SystemError.UNKNOWN_ERROR;
        String exceptionName = e.getClass().getName();
        if (exceptionName.contains(".sql.")) {
            error = SystemError.SYSTEM_ERROR;
        }
        if (exceptionName.contains(".http.") || exceptionName.contains(".web.")) {
            error = SystemError.ILLEGAL_REQUEST;
        }
        return error;
    }
}
