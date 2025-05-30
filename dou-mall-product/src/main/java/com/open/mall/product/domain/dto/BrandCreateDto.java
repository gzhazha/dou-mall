package com.open.mall.product.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * BrandCreateDto
 *
 * @author zhoug
 * @date 2025/5/30 16:04
 */

@Schema(description = "BrandCreateDto")
@Data
public class BrandCreateDto {
    /**
     * 租户 ID
     */
    @Schema(description = "租户 ID")
    private Long tenantId;

    /**
     * 品牌名称
     */
    @Schema(description = "品牌名称")
    private String name;

    /**
     * Logo 地址
     */
    @Schema(description = "Logo 地址")
    private String logoUrl;

    /**
     * 品牌描述
     */
    @Schema(description = "品牌描述")
    private String description;


    /**
     * 排序值
     */
    @Schema(description = "排序值")
    private Integer sort;

}
