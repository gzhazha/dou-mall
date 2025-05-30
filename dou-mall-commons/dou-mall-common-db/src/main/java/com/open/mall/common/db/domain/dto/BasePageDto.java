package com.open.mall.common.db.domain.dto;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * BasePageDto
 *
 * @author zhoug
 * @date 2025/5/30 15:37
 */

@Schema(description = "分页参数")
public class BasePageDto {
    @Schema(description = "页码")
    private Integer pageNum;
    @Schema(description = "页面大小")
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum != null ? pageNum : 1;
    }

    public Integer getPageSize() {
        return pageSize != null ? pageSize : 10;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void initDefaults() {
        if (pageNum == null) pageNum = 1;
        if (pageSize == null) pageSize = 10;
    }

    public <T> IPage<T> buildPage() {
        return new Page<>(getPageNum(), getPageSize());
    }

}
