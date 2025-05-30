package com.open.mall.product.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "属性值创建参数")
public class AttrValueCreateDto {

    @Schema(description = "属性键ID")
    private Long attrKeyId;

    @Schema(description = "属性值")
    private String value;
}