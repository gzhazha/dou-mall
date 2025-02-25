package com.dou.mall.common.base.vo;

import com.dou.mall.common.base.enums.BaseCode;
import com.dou.mall.common.base.enums.BaseErrorCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * BaseVo
 *
 * @author zhoug
 * @date 2025/2/17 14:40
 */
@Data
public class ResponseEntity<T> implements Serializable {
    @Schema(description = "状态码")
    private Integer code;
    @Schema(description = "消息")
    private String msg;
    @Schema(description = "数据")
    private T data;
    @Schema(description = "链路追踪id")
    private String traceId;

    public ResponseEntity() {
    }

    public static <T> ResponseEntity<T> fail() {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(BaseErrorCode.FAILED.getCode());
        responseEntity.setMsg(BaseErrorCode.FAILED.getMsg());
        return responseEntity;
    }

    public static <T> ResponseEntity<T> fail(BaseCode baseCode, T data) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(baseCode.getCode());
        responseEntity.setMsg(baseCode.getMsg());
        responseEntity.setData(data);
        return responseEntity;
    }
    public static <T> ResponseEntity<T> fail(Integer code, String msg) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(code);
        responseEntity.setMsg(msg);
        return responseEntity;
    }

    public static <T> ResponseEntity<T> success() {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(BaseErrorCode.SUCCESSFUL.getCode());
        responseEntity.setMsg(BaseErrorCode.SUCCESSFUL.getMsg());
        return responseEntity;
    }

    public static <T> ResponseEntity<T> success(T data) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(BaseErrorCode.SUCCESSFUL.getCode());
        responseEntity.setMsg(BaseErrorCode.SUCCESSFUL.getMsg());
        responseEntity.setData(data);
        return responseEntity;
    }

    public static <T> ResponseEntity<T> fail(BaseErrorCode baseErrorCode) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(baseErrorCode.getCode());
        responseEntity.setMsg(baseErrorCode.getMsg());
        return responseEntity;
    }

}
