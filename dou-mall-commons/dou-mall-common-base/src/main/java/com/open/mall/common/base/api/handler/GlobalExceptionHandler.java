package com.open.mall.common.base.api.handler;

import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.common.base.enums.ResultCode;
import com.open.mall.common.base.exception.MallBaseException;
import com.open.mall.common.base.utils.ResultCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler
 *
 * @author zhoug
 * @date 2025/4/17 10:05
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({BindException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResult<Void> bindExceptionHandler(BindException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        return bindExceptionHandler(bindingResult);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResult<Void> bindExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        return bindExceptionHandler(bindingResult);
    }

    public BaseResult<Void> bindExceptionHandler(BindingResult bindingResult) {
        BaseResult<Void> res = BaseResult.failure(bindingResult);
        return res;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResult<Void> exceptionHandler(Exception ex) {
        log.error("", ex);
        if (StringUtils.containsIgnoreCase(ExceptionUtils.getRootCauseMessage(ex), "Broken pipe")) {
            return null;
        }
        ResultCode error = ResultCodeUtil.handle(ex);
        return BaseResult.failure(error);
    }

    @ExceptionHandler(MallBaseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResult<Void> exceptionHandler(MallBaseException ex) {
        log.error("", ex);
        ResultCode error = ex.getResultCode();
        return BaseResult.failure(error);
    }
}
