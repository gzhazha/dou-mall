package com.open.mall.cart.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * CartListVo
 *
 * @author zhoug
 * @date 2025/6/11 18:44
 */
@Schema(description ="CartListVo")
@Data
public class CartListVo {


    /**
     * 主键 ID
     */
    @Schema(description =  "id")
    private Long id;

    /**
     * 用户 ID
     */
    @Schema(description = "user_id")
    private Long userId;

    /**
     * 商品 SPU ID
     */
    @Schema(description = "product_id")
    private Long productId;

    /**
     * 商品 SKU ID
     */
    @Schema(description = "sku_id")
    private Long skuId;

    /**
     * 商品数量
     */
    @Schema(description = "quantity")
    private Integer quantity;

    /**
     * 是否选中
     */
    @Schema(description = "selected")
    private Integer selected;

    /**
     * 加入时的价格快照
     */
    @Schema(description = "price_snapshot")
    private BigDecimal priceSnapshot;

    /**
     * SKU 名称快照（如颜色+尺码）
     */
    @Schema(description = "sku_name")
    private String skuName;

    /**
     * 商品图片快照
     */
    @Schema(description = "product_image")
    private String productImage;
}
