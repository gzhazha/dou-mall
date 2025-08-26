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
 * 用户认证表
 * @TableName user_auth
 */
@TableName(value ="user_auth")
@Data
public class UserAuth implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "auth_id", type = IdType.AUTO)
    private Long authId;

    /**
     * 用户ID（关联用户库）
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 认证类型: password/sms/email/oauth
     */
    @TableField(value = "auth_type")
    private String authType;

    /**
     * 账号标识: 手机号/邮箱/第三方ID
     */
    @TableField(value = "identifier")
    private String identifier;

    /**
     * 密码哈希/三方token
     */
    @TableField(value = "credential")
    private String credential;

    /**
     * 密码盐值
     */
    @TableField(value = "salt")
    private String salt;

    /**
     * 状态: 1=启用,0=禁用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at")
    private LocalDateTime updatedAt;
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}