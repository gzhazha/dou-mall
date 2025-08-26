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
 * @TableName refresh_token
 */
@TableName(value ="refresh_token")
@Data
public class RefreshToken implements Serializable {
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
     * 授权类型{@link com.open.mall.common.base.enums.auth.AuthTypeEnum}
     */
    @TableField(value = "auth_type")
    private String authType;
    /**
     * 授权码
     */
    @TableField(value = "auth_code")
    private String authCode;

    /**
     * 刷新Token
     */
    @TableField(value = "refresh_token")
    private String refreshToken;

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