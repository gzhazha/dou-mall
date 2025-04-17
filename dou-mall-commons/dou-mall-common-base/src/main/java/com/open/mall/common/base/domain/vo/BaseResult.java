package com.open.mall.common.base.domain.vo;

import com.open.mall.common.base.enums.ErrorEnum;
import com.open.mall.common.base.enums.ResultCode;
import com.open.mall.common.base.enums.ResultEnum;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * BaseResult
 *
 * @author zhoug
 * @date 2025/4/16 17:22
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BaseResult<T> {
    /**
     * 响应码
     */
    private Integer code = ResultEnum.SUCCESS.getCode();

    /**
     * 说明
     */
    private String msg = ResultEnum.SUCCESS.getMsg();

    /**
     * 链路追踪
     */
    private String traceId;

    /**
     * 数据
     */
    private T data;

    public static <T> BaseResult<T> success(T result) {
        return new BaseResult<T>(ResultEnum.SUCCESS).setResult(result);
    }

    public static <T> BaseResult<T> failure() {
        return new BaseResult<T>(ResultEnum.FAIL).setNullResult();
    }

    public static <T> BaseResult<T> success() {
        return new BaseResult<T>(ResultEnum.SUCCESS).setNullResult();
    }

    public static <T> BaseResult<T> failure(BindingResult result) {
        return new BaseResult<T>(ResultEnum.FAIL).handleParamError(result);
    }

    public static <T> BaseResult<T> failure(ResultCode resultCode) {
        BaseResult<T> result = new BaseResult<>(resultCode);
        result.build();
        return result;
    }

    public static <T> BaseResult<T> of(ResultCode resultCode) {
        BaseResult<T> result = new BaseResult<>();
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
        result.build();
        return result;
    }

    public boolean getSuccess() {
        return ResultEnum.SUCCESS.getCode().equals(code);
    }


    public BaseResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }


    // --------属性方法私有化 begin--------
    private void setCode(int code) {
        this.code = code;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

    private void setData(T data) {
        this.data = data;
    }

    private void setTraceId(String traceId) {
        this.traceId = traceId;
    }
    // --------属性方法私有化 end--------

    private BaseResult<T> setResult(T result) {
        setData(result);
        build();
        return this;
    }

    private BaseResult<T> setNullResult() {
        build();
        return this;
    }

    private BaseResult<T> handleParamError(BindingResult result) {
        handleParam(result);
        build();
        return this;
    }

    private void build() {
        if (this.getCode() == ResultEnum.SUCCESS.getCode()) {
//            handleResult();
        }
//        setTraceId(TraceContext.getTraceId());
    }

    private void handleParam(BindingResult result) {
        if (result.hasErrors()) {
            ObjectError error = result.getAllErrors().get(0);
            String errorMsg = error.getDefaultMessage();
            if (StringUtils.isNotBlank(errorMsg) && errorMsg.toLowerCase().contains(Exception.class.getSimpleName().toLowerCase())) {
                errorMsg = ErrorEnum.ILLEGAL_PARAM.getMsg();
            }
            setMsg(errorMsg);
            setCode(ErrorEnum.ILLEGAL_PARAM.getCode());
        }
    }

//    private void handleResult() {
//        if (MessageContext.hasErrors()) {
//            // 错误取第一条
//            MessageContext.MessageInfo error = MessageContext.getErrors().get(0);
//            setCode(error.getCode());
//            setMsg(error.getMsg());
//            setSvrMsg(error.getSvrMsg());
//            return;
//        }
//        if (MessageContext.hasMessages()) {
//            // 信息取最后一条
//            MessageContext.MessageInfo message = MessageContext.getMessages().get(MessageContext.getMessages().size() - 1);
//            setMsg(message.getMsg());
//            setCode(message.getCode());
//            setSvrMsg(message.getSvrMsg());
//        }
//    }
}
