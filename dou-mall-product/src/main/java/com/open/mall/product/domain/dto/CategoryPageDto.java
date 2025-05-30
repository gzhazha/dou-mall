package com.open.mall.product.domain.dto;

import com.open.mall.common.db.domain.dto.BasePageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Schema(description = "CategoryPageDto")
@Data
public class CategoryPageDto extends BasePageDto {

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
     * 是否显示：0-不显示，1-显示
     */
    @Schema(description = "是否显示：0-不显示，1-显示")
    private Integer isVisible;
}