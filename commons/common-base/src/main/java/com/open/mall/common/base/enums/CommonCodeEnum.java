package com.open.mall.common.base.enums;

import com.open.mall.common.base.constants.CommonConst;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * CommonCodeEnum 通用响应码枚举
 * 定义与业务无关的通用状态码和错误信息
 *
 * @author zhoug
 * @date 2025/8/22 18:50
 */

@AllArgsConstructor
@Getter
public enum CommonCodeEnum implements ResultCode {

    // 成功状态
    SUCCESS(200, "操作成功"),
    
    // 客户端错误 4xx
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未授权访问"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    METHOD_NOT_ALLOWED(405, "请求方法不允许"),
    REQUEST_TIMEOUT(408, "请求超时"),
    CONFLICT(409, "资源冲突"),
    PAYLOAD_TOO_LARGE(413, "请求体过大"),
    TOO_MANY_REQUESTS(429, "请求过于频繁"),
    
    // 服务端错误 5xx
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    NOT_IMPLEMENTED(501, "功能未实现"),
    BAD_GATEWAY(502, "网关错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    GATEWAY_TIMEOUT(504, "网关超时"),
    
    // 通用业务错误 1xxx
    PARAM_ERROR(1001, "参数校验失败"),
    PARAM_MISSING(1002, "缺少必要参数"),
    PARAM_TYPE_ERROR(1003, "参数类型错误"),
    PARAM_FORMAT_ERROR(1004, "参数格式错误"),
    PARAM_OUT_OF_RANGE(1005, "参数超出范围"),
    
    // 数据相关错误 2xxx
    DATA_NOT_FOUND(2001, "数据不存在"),
    DATA_ALREADY_EXISTS(2002, "数据已存在"),
    DATA_INTEGRITY_VIOLATION(2003, "数据完整性约束违反"),
    DATA_ACCESS_ERROR(2004, "数据访问异常"),
    DATA_CONVERSION_ERROR(2005, "数据转换异常"),
    
    // 权限相关错误 3xxx
    ACCESS_DENIED(3001, "访问被拒绝"),
    TOKEN_INVALID(3002, "令牌无效"),
    TOKEN_EXPIRED(3003, "令牌已过期"),
    PERMISSION_DENIED(3004, "权限不足"),
    ACCOUNT_LOCKED(3005, "账户已锁定"),
    ACCOUNT_DISABLED(3006, "账户已禁用"),

    // 系统相关错误 4xxx
    SYSTEM_BUSY(4001, "系统繁忙，请稍后重试"),
    SYSTEM_MAINTENANCE(4002, "系统维护中"),
    SYSTEM_TIMEOUT(4003, "系统超时"),
    SYSTEM_OVERLOAD(4004, "系统过载"),
    
    // 网络相关错误 5xxx
    NETWORK_ERROR(5001, "网络异常"),
    CONNECTION_TIMEOUT(5002, "连接超时"),
    READ_TIMEOUT(5003, "读取超时"),
    REMOTE_SERVICE_ERROR(5004, "远程服务异常"),
    
    // 文件相关错误 6xxx
    FILE_NOT_FOUND(6001, "文件不存在"),
    FILE_UPLOAD_FAILED(6002, "文件上传失败"),
    FILE_DOWNLOAD_FAILED(6003, "文件下载失败"),
    FILE_TYPE_NOT_SUPPORTED(6004, "文件类型不支持"),
    FILE_SIZE_EXCEEDED(6005, "文件大小超出限制"),
    
    // 缓存相关错误 7xxx
    CACHE_ERROR(7001, "缓存异常"),
    CACHE_KEY_NOT_FOUND(7002, "缓存键不存在"),
    CACHE_EXPIRED(7003, "缓存已过期"),
    
    // 消息队列相关错误 8xxx
    MQ_SEND_FAILED(8001, "消息发送失败"),
    MQ_CONSUME_FAILED(8002, "消息消费失败"),
    MQ_CONNECTION_ERROR(8003, "消息队列连接异常"),
    
    // 配置相关错误 9xxx
    CONFIG_ERROR(9001, "配置错误"),
    CONFIG_NOT_FOUND(9002, "配置不存在"),
    CONFIG_PARSE_ERROR(9003, "配置解析失败"),
    
    // 通用失败状态（保持向后兼容）
    FAILED(CommonConst.CUSTOM_ERROR_CODE, "操作失败"),
    
    // 自定义错误信息
    CUSTOM_ERROR(CommonConst.CUSTOM_ERROR_CODE, "自定义错误"),
    ;

    private final Integer code;
    private final String msg;

    public ResultCode format(String msg) {
        Integer fcode = this.getCode();
        String fmsg = this.getMsg();
        return new ResultCode() {
            @Override
            public Integer getCode() {
                return fcode;
            }

            @Override
            public String getMsg() {
                return msg == null || msg.isEmpty() ? fmsg : msg;
            }
        };
    }

}

