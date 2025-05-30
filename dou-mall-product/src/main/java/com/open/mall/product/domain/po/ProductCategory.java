package com.open.mall.product.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName product_category
 */
@TableName(value ="product_category")
@Data
public class ProductCategory implements Serializable {
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
     * 父分类 ID
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 分类名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 分类层级 1/2/3
     */
    @TableField(value = "level")
    private Integer level;

    /**
     * 排序值
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 是否显示
     */
    @TableField(value = "is_visible")
    private Integer isVisible;

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