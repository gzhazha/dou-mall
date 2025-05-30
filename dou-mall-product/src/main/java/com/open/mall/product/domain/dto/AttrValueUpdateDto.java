package com.open.mall.product.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "属性值更新参数")
public class AttrValueUpdateDto {

    @Schema(description = "属性值ID")
    private Long id;

    @Schema(description = "属性键ID")
    private Long attrKeyId;

    @Schema(description = "属性值")
    private String value;
}