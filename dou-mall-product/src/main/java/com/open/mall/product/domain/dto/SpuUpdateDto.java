package com.open.mall.product.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "SpuUpdateDto")
@Data
public class SpuUpdateDto {
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
     * 商品名称
     */
    @Schema(description = "商品名称")
    private String name;

    /**
     * 分类 ID
     */
    @Schema(description = "分类 ID")
    private Long categoryId;

    /**
     * 品牌 ID
     */
    @Schema(description = "品牌 ID")
    private Long brandId;

    /**
     * 商品描述
     */
    @Schema(description = "商品描述")
    private String description;

    /**
     * 商品状态：1-上架，2-下架，3-删除
     */
    @Schema(description = "商品状态：1-上架，2-下架，3-删除")
    private Integer status;

    /**
     * 销售模式：1-现货，2-预售，3-定制
     */
    @Schema(description = "销售模式：1-现货，2-预售，3-定制")
    private Integer saleMode;
}