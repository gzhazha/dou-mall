package com.open.mall.product.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "CategoryCreateDto")
@Data
public class CategoryCreateDto {
    /**
     * 租户 ID
     */
    @Schema(description = "租户 ID")
    private Long tenantId;

    /**
     * 父分类 ID
     */
    @Schema(description = "父分类 ID")
    private Long parentId;

    /**
     * 分类名称
     */
    @Schema(description = "分类名称")
    private String name;

    /**
     * 分类级别：1-一级分类，2-二级分类，3-三级分类
     */
    @Schema(description = "分类级别：1-一级分类，2-二级分类，3-三级分类")
    private Integer level;

    /**
     * 排序值
     */
    @Schema(description = "排序值")
    private Integer sort;

    /**
     * 是否显示：0-不显示，1-显示
     */
    @Schema(description = "是否显示：0-不显示，1-显示")
    private Integer isVisible;
}