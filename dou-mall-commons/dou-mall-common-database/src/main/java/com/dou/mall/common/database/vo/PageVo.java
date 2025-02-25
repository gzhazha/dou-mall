package com.dou.mall.common.database.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * PageVo
 *
 * @author zhoug
 * @date 2025/2/17 15:32
 */

@Data
public class PageVo<T> {

    @Schema(description = "总页数")
    private Integer pages;

    @Schema(description = "总条目数")
    private Long total;

    @Schema(description = "结果集")
    private List<T> list;
}
