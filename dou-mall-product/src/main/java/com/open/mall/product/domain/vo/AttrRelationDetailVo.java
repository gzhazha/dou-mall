package com.open.mall.product.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "属性关系详情")
public class AttrRelationDetailVo {

    @Schema(description = "属性关系ID")
    private Long id;

    @Schema(description = "SPU ID")
    private Long spuId;

    @Schema(description = "属性键ID")
    private Long attrKeyId;

    @Schema(description = "属性值ID")
    private Long attrValueId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "属性键名称")
    private String attrKeyName;

    @Schema(description = "属性值")
    private String attrValue;
}