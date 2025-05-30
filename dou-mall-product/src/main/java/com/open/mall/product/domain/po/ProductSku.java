package com.open.mall.product.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName product_sku
 */
@TableName(value ="product_sku")
@Data
public class ProductSku implements Serializable {
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
     * SPU ID
     */
    @TableField(value = "spu_id")
    private Long spuId;

    /**
     * SKU 编码
     */
    @TableField(value = "sku_code")
    private String skuCode;

    /**
     * 销售价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 成本价
     */
    @TableField(value = "cost_price")
    private BigDecimal costPrice;

    /**
     * 库存数量
     */
    @TableField(value = "stock")
    private Integer stock;

    /**
     * 销量
     */
    @TableField(value = "sale")
    private Integer sale;

    /**
     * 规格属性（JSON 格式）
     */
    @TableField(value = "specs_json")
    private String specsJson;

    /**
     * SKU 主图
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 状态：1-正常 0-禁用
     */
    @TableField(value = "status")
    private Integer status;

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