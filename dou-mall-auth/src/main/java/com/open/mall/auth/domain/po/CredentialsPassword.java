package com.open.mall.auth.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户密码及MFA凭证
 * @TableName credentials_password
 */
@TableName(value ="credentials_password")
@Data
public class CredentialsPassword implements Serializable {
    /**
     * 用户ID, 关联 auth_users.user_id
     */
    @TableId(value = "user_id",type = IdType.AUTO)
    private String userId;

    /**
     * 安全哈希处理后的密码 (使用 bcrypt, Argon2 等)
     */
    @TableField(value = "password_hash")
    private String passwordHash;

    /**
     * 密码最后更新时间
     */
    @TableField(value = "password_updated_at")
    private Date passwordUpdatedAt;

    /**
     * 记录最后更新时间
     */
    @TableField(value = "updated_at")
    private Date updatedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}