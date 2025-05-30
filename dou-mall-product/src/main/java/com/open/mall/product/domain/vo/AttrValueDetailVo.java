package com.open.mall.product.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "属性值详情")
public class AttrValueDetailVo {

    @Schema(description = "属性值ID")
    private Long id;

    @Schema(description = "属性键ID")
    private Long attrKeyId;

    @Schema(description = "属性值")
    private String value;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}