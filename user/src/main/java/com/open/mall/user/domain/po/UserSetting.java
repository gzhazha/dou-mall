package com.open.mall.user.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户偏好设置表
 * @TableName user_setting
 */
@TableName(value ="user_setting")
@Data
public class UserSetting implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "user_id")
    private Long userId;

    /**
     * 语言偏好
     */
    @TableField(value = "language")
    private String language;

    /**
     * 时区
     */
    @TableField(value = "timezone")
    private String timezone;

    /**
     * 是否开启邮件通知:1=是,0=否
     */
    @TableField(value = "notify_email")
    private Integer notifyEmail;

    /**
     * 是否开启短信通知:1=是,0=否
     */
    @TableField(value = "notify_sms")
    private Integer notifySms;

    /**
     * 是否开启推送通知:1=是,0=否
     */
    @TableField(value = "notify_push")
    private Integer notifyPush;

    /**
     * 主题: light/dark
     */
    @TableField(value = "theme")
    private String theme;

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