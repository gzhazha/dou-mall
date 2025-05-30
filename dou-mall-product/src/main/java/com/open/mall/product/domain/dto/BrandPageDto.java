package com.open.mall.product.domain.dto;

import com.open.mall.common.db.domain.dto.BasePageDto;
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
public class BrandPageDto extends BasePageDto {

    /**
     * 主键
     */
    @Schema(description =  "品牌名称")
    private String name;

}
