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
 * @TableName product_spu
 */
@TableName(value ="product_spu")
@Data
public class ProductSpu implements Serializable {
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
     * 商品名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 分类 ID
     */
    @TableField(value = "category_id")
    private Long categoryId;

    /**
     * 品牌 ID
     */
    @TableField(value = "brand_id")
    private Long brandId;

    /**
     * 商品描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 状态：1-上架 0-下架 2-审核中
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 销售模式：1-普通 2-预售 3-虚拟
     */
    @TableField(value = "sale_mode")
    private Integer saleMode;

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