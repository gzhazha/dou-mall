package com.open.mall.product.domain.dto;

import com.open.mall.common.db.domain.dto.BasePageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Schema(description = "SkuPageDto")
@Data
public class SkuPageDto extends BasePageDto {

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
     * 最小销售价格
     */
    @Schema(description = "最小销售价格")
    private BigDecimal minPrice;

    /**
     * 最大销售价格
     */
    @Schema(description = "最大销售价格")
    private BigDecimal maxPrice;

    /**
     * 商品状态：1-正常，2-禁用
     */
    @Schema(description = "商品状态：1-正常，2-禁用")
    private Integer status;
}