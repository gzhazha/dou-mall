package com.open.mall.product.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Schema(description = "SpuDetailVo")
@Data
public class SpuDetailVo {

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
     * 商品名称
     */
    @Schema(description = "商品名称")
    private String name;

    /**
     * 分类 ID
     */
    @Schema(description = "分类 ID")
    private Long categoryId;

    /**
     * 分类名称
     */
    @Schema(description = "分类名称")
    private String categoryName;

    /**
     * 品牌 ID
     */
    @Schema(description = "品牌 ID")
    private Long brandId;

    /**
     * 品牌名称
     */
    @Schema(description = "品牌名称")
    private String brandName;

    /**
     * 商品描述
     */
    @Schema(description = "商品描述")
    private String description;

    /**
     * 商品状态：1-上架，2-下架，3-删除
     */
    @Schema(description = "商品状态：1-上架，2-下架，3-删除")
    private Integer status;

    /**
     * 销售模式：1-现货，2-预售，3-定制
     */
    @Schema(description = "销售模式：1-现货，2-预售，3-定制")
    private Integer saleMode;

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