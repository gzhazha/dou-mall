package com.open.mall.auth.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鉴权日志表
 * @TableName auth_log
 */
@TableName(value ="auth_log")
@Data
public class AuthLog implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 认证方式
     */
    @TableField(value = "auth_type")
    private String authType;

    /**
     * IP 地址
     */
    @TableField(value = "ip_address")
    private String ipAddress;

    /**
     * 设备指纹
     */
    @TableField(value = "device_id")
    private String deviceId;

    /**
     * 0=失败 1=成功
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 失败原因/成功信息
     */
    @TableField(value = "message")
    private String message;

    /**
     * 
     */
    @TableField(value = "created_at")
    private Date createdAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}