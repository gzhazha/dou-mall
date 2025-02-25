package com.dou.mall.common.base.web.handler;

import com.dou.mall.common.base.enums.BaseCode;
import com.dou.mall.common.base.enums.BaseErrorCode;
import com.dou.mall.common.base.exception.DouMallException;
import com.dou.mall.common.base.utils.ApiLogUtil;
import com.dou.mall.common.base.vo.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * ExceptionHandler
 *
 * @author zhoug
 * @date 2025/2/17 16:24
 */
@Slf4j
@RestController
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class, HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<String>> methodArgumentNotValidExceptionHandler(Exception e) {
        List<FieldError> fieldErrors = null;
        if (e instanceof MethodArgumentNotValidException) {
            fieldErrors = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();
        } else if (e instanceof BindException) {
            fieldErrors = ((BindException) e).getBindingResult().getFieldErrors();
        }
        if (fieldErrors == null) {
            return ResponseEntity.fail(BaseErrorCode.ILLEGAL_PARAM);
        }

        List<String> defaultMessages = new ArrayList<>(fieldErrors.size());
        for (FieldError fieldError : fieldErrors) {
            defaultMessages.add(fieldError.getField() + ":" + fieldError.getDefaultMessage());
        }
        ResponseEntity<List<String>> fail = ResponseEntity.fail(BaseErrorCode.ILLEGAL_PARAM, defaultMessages);
        ApiLogUtil.logResponse(fail);
        return fail;
    }

    @ExceptionHandler(DouMallException.class)
    public <T> ResponseEntity<T> douMallException(DouMallException e) {
        log.error("", e);
        BaseCode baseCode = e.getBaseCode();
        int code = BaseErrorCode.FAILED.getCode();
        String message = e.getMessage();
        if (baseCode != null) {
            code = baseCode.getCode();
            message = baseCode.getMsg();
        }
        ResponseEntity<T> fail = ResponseEntity.fail(code, message);
        ApiLogUtil.logResponse(fail);
        return fail;
    }

    @ExceptionHandler(Exception.class)
    public <T> ResponseEntity<T> exceptionHandler(Exception e) {
        log.error("",e);
        ResponseEntity<T> fail = ResponseEntity.fail(BaseErrorCode.FAILED);
        ApiLogUtil.logResponse(fail);
        return fail;
    }
}
