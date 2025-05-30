package com.open.mall.product.domain.dto;

import com.open.mall.common.db.domain.dto.BasePageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Schema(description = "SpuPageDto")
@Data
public class SpuPageDto extends BasePageDto {

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