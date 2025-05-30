package com.open.mall.auth.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 用户绑定的第三方社交账号信息
 * @TableName credentials_social
 */
@TableName(value ="credentials_social")
@Data
public class CredentialsSocial implements Serializable {
    /**
     * 绑定记录的唯一自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联的用户ID
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 第三方提供商标识 (如: google, github, wechat)
     */
    @TableField(value = "provider")
    private String provider;

    /**
     * 用户在第三方平台的唯一ID
     */
    @TableField(value = "provider_user_id")
    private String providerUserId;

    /**
     * 用户在第三方平台的用户名/昵称 (可选)
     */
    @TableField(value = "provider_username")
    private String providerUsername;

    /**
     * 第三方平台的访问令牌 (需加密存储)
     */
    @TableField(value = "access_token")
    private String accessToken;

    /**
     * 第三方平台的刷新令牌 (需加密存储)
     */
    @TableField(value = "refresh_token")
    private String refreshToken;

    /**
     * 第三方访问令牌过期时间
     */
    @TableField(value = "token_expires_at")
    private LocalDateTime tokenExpiresAt;

    /**
     * 用户授予的权限范围 (Scope)
     */
    @TableField(value = "scopes")
    private String scopes;

    /**
     * 绑定时间
     */
    @TableField(value = "linked_at")
    private LocalDateTime linkedAt;

    /**
     * 
     */
    @TableField(value = "updated_at")
    private LocalDateTime updatedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}