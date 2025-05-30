package com.open.mall.product.domain.dto;

import com.open.mall.common.db.domain.dto.BasePageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "属性键分页查询参数")
public class AttrKeyPageDto extends BasePageDto {

    @Schema(description = "属性名称")
    private String name;

    @Schema(description = "属性类型：1-销售属性，2-参数属性")
    private Integer type;

    @Schema(description = "分类ID")
    private Long categoryId;
}