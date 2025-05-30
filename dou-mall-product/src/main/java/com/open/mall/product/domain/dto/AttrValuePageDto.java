package com.open.mall.product.domain.dto;

import com.open.mall.common.db.domain.dto.BasePageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "属性值分页查询参数")
public class AttrValuePageDto extends BasePageDto {

    @Schema(description = "属性键ID")
    private Long attrKeyId;

    @Schema(description = "属性值")
    private String value;
}