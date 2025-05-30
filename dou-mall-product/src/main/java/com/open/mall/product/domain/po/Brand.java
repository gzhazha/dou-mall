package com.open.mall.product.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName brand
 */
@TableName(value ="brand")
@Data
public class Brand implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户 ID
     */
    @TableField(value = "tenant_id")
    private Long tenantId;

    /**
     * 品牌名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * Logo 地址
     */
    @TableField(value = "logo_url")
    private String logoUrl;

    /**
     * 品牌描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 排序值
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}