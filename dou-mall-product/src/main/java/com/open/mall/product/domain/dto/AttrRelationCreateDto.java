package com.open.mall.product.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "属性关系创建参数")
public class AttrRelationCreateDto {

    @Schema(description = "SPU ID")
    private Long spuId;

    @Schema(description = "属性键ID")
    private Long attrKeyId;

    @Schema(description = "属性值ID")
    private Long attrValueId;
}