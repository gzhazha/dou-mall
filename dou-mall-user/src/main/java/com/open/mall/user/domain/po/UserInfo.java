package com.open.mall.user.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 存储核心用户身份信息
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
public class UserInfo implements Serializable {
    /**
     * 全局唯一用户ID (UUID格式), 由本服务生成
     */
    @TableId(value = "user_id",type = IdType.AUTO)
    private Long userId;

    /**
     * 可选的唯一用户名, 可用于登录或显示
     */
    @TableField(value = "username")
    private String username;

    /**
     * 唯一电子邮箱地址, 可用于登录、通知、密码重置等
     */
    @TableField(value = "email")
    private String email;

    /**
     * 唯一手机号码, 可用于登录、通知、密码重置等
     */
    @TableField(value = "phone_number")
    private String phoneNumber;

    /**
     * 邮箱是否已验证 (0=否, 1=是)
     */
    @TableField(value = "email_verified")
    private Integer emailVerified;

    /**
     * 手机号是否已验证 (0=否, 1=是)
     */
    @TableField(value = "phone_verified")
    private Integer phoneVerified;

    /**
     * 用户对外显示的昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 用户头像图片的URL链接
     */
    @TableField(value = "avatar_url")
    private String avatarUrl;

    /**
     * 用户账户状态 (例如:0=初始化/刚注册，只能获取临时token 1=正常/活跃, 2=待验证, 3=已禁用/暂停, 4=已注销/软删除)
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 用户注册时的IP地址 (可选)
     */
    @TableField(value = "registration_ip")
    private String registrationIp;

    /**
     * 记录创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;

    /**
     * 记录最后更新时间
     */
    @TableField(value = "updated_at")
    private Date updatedAt;

    /**
     * 软删除标记的时间戳 (NULL表示未删除)
     */
    @TableField(value = "deleted_at")
    private Date deletedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}