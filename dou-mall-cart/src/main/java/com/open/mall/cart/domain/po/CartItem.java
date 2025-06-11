package com.open.mall.cart.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 购物车项表
 * @TableName cart_item
 */
@TableName(value ="cart_item")
@Data
public class CartItem implements Serializable {
    /**
     * 主键 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户 ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 商品 SPU ID
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 商品 SKU ID
     */
    @TableField(value = "sku_id")
    private Long skuId;

    /**
     * 商品数量
     */
    @TableField(value = "quantity")
    private Integer quantity;

    /**
     * 是否选中
     */
    @TableField(value = "selected")
    private Integer selected;

    /**
     * 加入时的价格快照
     */
    @TableField(value = "price_snapshot")
    private BigDecimal priceSnapshot;

    /**
     * SKU 名称快照（如颜色+尺码）
     */
    @TableField(value = "sku_name")
    private String skuName;

    /**
     * 商品图片快照
     */
    @TableField(value = "product_image")
    private String productImage;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}