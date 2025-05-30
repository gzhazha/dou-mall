package com.open.mall.product.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "SkuUpdateDto")
@Data
public class SkuUpdateDto {
    /**
     * 主键
     */
    @Schema(description = "主键")
    private Long id;

    /**
     * 租户 ID
     */
    @Schema(description = "租户 ID")
    private Long tenantId;

    /**
     * SPU ID
     */
    @Schema(description = "SPU ID")
    private Long spuId;

    /**
     * SKU 编码
     */
    @Schema(description = "SKU 编码")
    private String skuCode;

    /**
     * 销售价格
     */
    @Schema(description = "销售价格")
    private BigDecimal price;

    /**
     * 成本价格
     */
    @Schema(description = "成本价格")
    private BigDecimal costPrice;

    /**
     * 库存数量
     */
    @Schema(description = "库存数量")
    private Integer stock;

    /**
     * 销量
     */
    @Schema(description = "销量")
    private Integer sale;

    /**
     * 规格属性JSON
     */
    @Schema(description = "规格属性JSON")
    private String specsJson;

    /**
     * 商品图片
     */
    @Schema(description = "商品图片")
    private String imageUrl;

    /**
     * 商品状态：1-正常，2-禁用
     */
    @Schema(description = "商品状态：1-正常，2-禁用")
    private Integer status;
}