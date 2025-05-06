package com.open.mall.auth.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 存储认证系统中的用户状态
 * @TableName auth_user
 */
@TableName(value ="auth_user")
@Data
public class AuthUser implements Serializable {
    /**
     * 用户唯一ID (UUID格式), 概念上关联用户服务中的用户
     */
    @TableId(value = "user_id")
    private Long userId;

    /**
     * 最近一次成功登录时间 (任意方式)
     */
    @TableField(value = "last_login_at")
    private Date lastLoginAt;

    /**
     * 最近一次成功登录IP地址
     */
    @TableField(value = "last_login_ip")
    private String lastLoginIp;

    /**
     * 全局连续登录失败次数
     */
    @TableField(value = "failed_attempts")
    private Integer failedAttempts;

    /**
     * 全局账户锁定截止时间
     */
    @TableField(value = "lockout_until")
    private Date lockoutUntil;

    /**
     * 记录在本服务创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;

    /**
     * 记录最后更新时间
     */
    @TableField(value = "updated_at")
    private Date updatedAt;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}