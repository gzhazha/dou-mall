package com.open.mall.product.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "属性关系更新参数")
public class AttrRelationUpdateDto {

    @Schema(description = "属性关系ID")
    private Long id;

    @Schema(description = "SPU ID")
    private Long spuId;

    @Schema(description = "属性键ID")
    private Long attrKeyId;

    @Schema(description = "属性值ID")
    private Long attrValueId;
}