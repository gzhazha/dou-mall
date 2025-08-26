package com.open.mall.common.base.doman.vo;

import com.open.mall.common.base.enums.ResultCode;
import com.open.mall.common.base.enums.CommonCodeEnum;
import lombok.Getter;

/**
 * BaseResult
 *
 * @author zhoug
 * @date 2025/8/22 18:48
 */


@Getter
public class BaseResult<T> {
    private Integer code;
    private String msg;
    private T data;

    private BaseResult(int code, String msg, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    private BaseResult(ResultCode resultCode, T data) {
        this.msg = resultCode.getMsg();
        this.code = resultCode.getCode();
        this.data = data;
    }

    private BaseResult(ResultCode resultCode) {
        this.msg = resultCode.getMsg();
        this.code = resultCode.getCode();
    }

    public static <T> BaseResult<T> success() {
        return new BaseResult<>(CommonCodeEnum.SUCCESS);
    }

    public static <T> BaseResult<T> failed() {
        return new BaseResult<>(CommonCodeEnum.FAILED);
    }

    public static <T> BaseResult<T> failed(String msg) {
        return new BaseResult<>(CommonCodeEnum.FAILED.getCode(), msg, null);
    }

    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<>(CommonCodeEnum.SUCCESS, data);
    }

    public boolean isSuccess(){
        return CommonCodeEnum.SUCCESS.getCode().equals(this.code);
    }
}
