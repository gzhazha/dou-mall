package com.dou.mall.common.base.web.api;

import com.dou.mall.common.base.enums.BaseErrorCode;
import com.dou.mall.common.base.vo.ResponseEntity;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BasicErrorApi
 *
 * @author xuyaguang
 */
@Slf4j
@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class BasicErrorApi extends AbstractErrorController {

    public BasicErrorApi(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping
    public ResponseEntity<Object> error(HttpServletRequest request) {
        HttpStatus httpStatus = getStatus(request);
        BaseErrorCode error = null;
        if (httpStatus.is4xxClientError()) {
            error = BaseErrorCode.ILLEGAL_REQUEST;
            // 403
            if (HttpStatus.FORBIDDEN == httpStatus) {
                error = BaseErrorCode.FORBIDDEN;
            }
            // 404
            else if (HttpStatus.NOT_FOUND == httpStatus) {
                error = BaseErrorCode.RESOURCE_NOT_EXISTS;
            }
        }
        // 500
        if (httpStatus.is5xxServerError()) {
            error = BaseErrorCode.SYSTEM_ERROR;
        }
        if (error == null) {
            error = BaseErrorCode.UNKNOWN_ERROR;
        }
        return ResponseEntity.fail(error);
    }
}
