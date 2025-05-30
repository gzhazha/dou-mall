package com.open.mall.product.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * BrandDetailVo
 *
 * @author zhoug
 * @date 2025/5/30 16:12
 */


@Data
@Schema(description = "BrandDetailVo")
public class BrandDetailVo {

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
     * 品牌名称
     */
    @Schema(description = "品牌名称")
    private String name;

    /**
     * Logo 地址
     */
    @Schema(description = "Logo 地址")
    private String logoUrl;

    /**
     * 品牌描述
     */
    @Schema(description = "品牌描述")
    private String description;

    /**
     * 排序值
     */
    @Schema(description = "排序值")
    private Integer sort;

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
