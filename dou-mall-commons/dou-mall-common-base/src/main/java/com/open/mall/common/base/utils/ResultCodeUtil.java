package com.open.mall.common.base.utils;

import com.open.mall.common.base.enums.ErrorEnum;
import com.open.mall.common.base.enums.ResultCode;
import lombok.experimental.UtilityClass;

/**
 * ResultCodeUtils
 *
 * @author zhoug
 * @date 2025/4/17 11:22
 */
@UtilityClass
public class ResultCodeUtil {
    public static ResultCode handle(Throwable e) {
        ResultCode error = ErrorEnum.UNKNOWN_ERROR;
        String exceptionName = e.getClass().getName();
        if (exceptionName.contains(".sql.")) {
            error = ErrorEnum.SYSTEM_ERROR;
        }
        if (exceptionName.contains(".http.") || exceptionName.contains(".web.")) {
            error = ErrorEnum.ILLEGAL_REQUEST;
        }
        return error;
    }
}
