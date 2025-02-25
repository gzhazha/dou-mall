package com.dou.mall.common.database.dto;

import lombok.Data;

/**
 * PageDto
 *
 * @author zhoug
 * @date 2025/2/17 15:29
 */

@Data
public class PageDto {

    /**
     * 页号
     */
    private Integer pageNum;
    /**
     * 分页大小
     */
    private Integer pageSize;

}
