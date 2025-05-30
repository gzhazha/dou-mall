package com.open.mall.product.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "SkuDetailVo")
@Data
public class SkuDetailVo {

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
     * SPU ID
     */
    @Schema(description = "SPU ID")
    private Long spuId;

    /**
     * SPU名称
     */
    @Schema(description = "SPU名称")
    private String spuName;

    /**
     * SKU 编码
     */
    @Schema(description = "SKU 编码")
    private String skuCode;

    /**
     * 销售价格
     */
    @Schema(description = "销售价格")
    private BigDecimal price;

    /**
     * 成本价格
     */
    @Schema(description = "成本价格")
    private BigDecimal costPrice;

    /**
     * 库存数量
     */
    @Schema(description = "库存数量")
    private Integer stock;

    /**
     * 销量
     */
    @Schema(description = "销量")
    private Integer sale;

    /**
     * 规格属性JSON
     */
    @Schema(description = "规格属性JSON")
    private String specsJson;

    /**
     * 商品图片
     */
    @Schema(description = "商品图片")
    private String imageUrl;

    /**
     * 商品状态：1-正常，2-禁用
     */
    @Schema(description = "商品状态：1-正常，2-禁用")
    private Integer status;

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