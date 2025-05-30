package com.open.mall.product.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Schema(description = "CategoryDetailVo")
@Data
public class CategoryDetailVo {

    /**
     * 主键
     */
    @Schema(description = "主键")
    private Long id;

    /**
     * 租户 ID
     */
    @Schema(description = "租户 ID")
    private Long tenantId;

    /**
     * 父分类 ID
     */
    @Schema(description = "父分类 ID")
    private Long parentId;

    /**
     * 分类名称
     */
    @Schema(description = "分类名称")
    private String name;

    /**
     * 分类级别：1-一级分类，2-二级分类，3-三级分类
     */
    @Schema(description = "分类级别：1-一级分类，2-二级分类，3-三级分类")
    private Integer level;

    /**
     * 排序值
     */
    @Schema(description = "排序值")
    private Integer sort;

    /**
     * 是否显示：0-不显示，1-显示
     */
    @Schema(description = "是否显示：0-不显示，1-显示")
    private Integer isVisible;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}