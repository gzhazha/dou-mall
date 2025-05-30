package com.open.mall.product.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "属性键详情")
public class AttrKeyDetailVo {

    @Schema(description = "属性键ID")
    private Long id;

    @Schema(description = "租户ID")
    private Long tenantId;

    @Schema(description = "属性名称")
    private String name;

    @Schema(description = "属性类型：1-销售属性，2-参数属性")
    private Integer type;

    @Schema(description = "分类ID")
    private Long categoryId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}