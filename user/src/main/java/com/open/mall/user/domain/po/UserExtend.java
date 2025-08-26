package com.open.mall.user.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;

/**
 * 用户扩展信息表
 * @TableName user_extend
 */
@TableName(value ="user_extend")
@Data
public class UserExtend implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "user_id")
    private Long userId;

    /**
     * 真实姓名
     */
    @TableField(value = "real_name")
    private String realName;

    /**
     * 身份证号/证件号
     */
    @TableField(value = "id_number")
    private String idNumber;

    /**
     * 国家/地区
     */
    @TableField(value = "country")
    private String country;

    /**
     * 省份
     */
    @TableField(value = "province")
    private String province;

    /**
     * 城市
     */
    @TableField(value = "city")
    private String city;

    /**
     * 详细地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 额外扩展字段(JSON)
     */
    @TableField(value = "extra")
    private Map<String,Object> extra;

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