package com.open.mall.product.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "属性键创建参数")
public class AttrKeyCreateDto {

    @Schema(description = "租户ID")
    private Long tenantId;

    @Schema(description = "属性名称")
    private String name;

    @Schema(description = "属性类型：1-销售属性，2-参数属性")
    private Integer type;

    @Schema(description = "分类ID")
    private Long categoryId;
}