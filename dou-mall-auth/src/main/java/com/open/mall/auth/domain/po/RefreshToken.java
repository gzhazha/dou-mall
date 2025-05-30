package com.open.mall.auth.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 存储用户的刷新令牌
 * @TableName refresh_token
 */
@TableName(value ="refresh_token")
@Data
public class RefreshToken implements Serializable {
    /**
     * Refresh Token 的哈希值 (用于查找, 必须哈希存储)
     */
    @TableId(value = "token_hash")
    private String tokenHash;

    /**
     * 关联的用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 颁发令牌时的IP地址
     */
    @TableField(value = "ip_address")
    private String ipAddress;

    /**
     * 颁发时间
     */
    @TableField(value = "issued_at")
    private LocalDateTime issuedAt;

    /**
     * 令牌过期时间
     */
    @TableField(value = "expires_at")
    private LocalDateTime expiresAt;

    /**
     * 是否已被吊销 (0=否, 1=是)
     */
    @TableField(value = "revoked")
    private Integer revoked;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}