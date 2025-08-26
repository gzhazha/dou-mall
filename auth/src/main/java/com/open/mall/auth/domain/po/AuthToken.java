package com.open.mall.auth.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户登录Token表
 * @TableName auth_token
 */
@TableName(value ="auth_token")
@Data
public class AuthToken implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "token_id", type = IdType.AUTO)
    private Long tokenId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 刷新Token
     */
    @TableField(value = "refresh_token")
    private String refreshToken;

    /**
     * 认证Token
     */
    @TableField(value = "access_token")
    private String accessToken;

    /**
     * 设备指纹
     */
    @TableField(value = "device_id")
    private String deviceId;

    /**
     * 登录IP
     */
    @TableField(value = "ip_address")
    private String ipAddress;

    /**
     * 过期时间
     */
    @TableField(value = "expired_at")
    private LocalDateTime expiredAt;

    /**
     * 
     */
    @TableField(value = "created_at")
    private LocalDateTime createdAt;

    /**
     * 
     */
    @TableField(value = "updated_at")
    private LocalDateTime updatedAt;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}