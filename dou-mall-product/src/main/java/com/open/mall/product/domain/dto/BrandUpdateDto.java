package com.open.mall.product.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * BrandCreateDto
 *
 * @author zhoug
 * @date 2025/5/30 16:04
 */

@EqualsAndHashCode(callSuper = true)
@Schema(description =  "BrandUpdateDto")
@Data
public class BrandUpdateDto extends BrandCreateDto {

    /**
     * 主键
     */
    @Schema(description =  "主键")
    private Long id;

}
