package com.open.mall.user.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户账户信息（等级、积分、余额）
 * @TableName user_account
 */
@TableName(value ="user_account")
@Data
public class UserAccount implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "user_id")
    private Long userId;

    /**
     * 会员等级
     */
    @TableField(value = "level")
    private Integer level;

    /**
     * 积分
     */
    @TableField(value = "points")
    private Integer points;

    /**
     * 虚拟钱包余额
     */
    @TableField(value = "balance")
    private BigDecimal balance;

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