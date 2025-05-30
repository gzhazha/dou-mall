package com.open.mall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.product.domain.dto.BrandCreateDto;
import com.open.mall.product.domain.dto.BrandPageDto;
import com.open.mall.product.domain.dto.BrandUpdateDto;
import com.open.mall.product.domain.po.Brand;
import com.open.mall.product.domain.vo.BrandDetailVo;

import java.util.List;

/**
* @author guang
* @description 针对表【brand】的数据库操作Service
* @createDate 2025-05-30 15:23:58
*/
public interface BrandService {
    /**
     * 创建品牌
     * @param brand 品牌信息
     * @return 创建成功返回true，否则返回false
     */
    boolean createBrand(BrandCreateDto brand);

    /**
     * 更新品牌
     * @param brand 品牌信息
     * @return 更新成功返回true，否则返回false
     */
    boolean updateBrand(BrandUpdateDto brand);

    /**
     * 删除品牌
     * @param id 品牌ID
     * @return 删除成功返回true，否则返回false
     */
    boolean deleteBrand(Long id);

    /**
     * 获取品牌详情
     * @param id 品牌ID
     * @return 品牌信息
     */
    BrandDetailVo getBrandById(Long id);

    /**
     * 分页查询品牌列表
     * @param brandPageDto 分页查询参数
     * @return 品牌列表
     */
    IPage<BrandDetailVo> listBrandsByPage(BrandPageDto brandPageDto);

    /**
     * 获取所有品牌
     * @return 品牌列表
     */
    List<BrandDetailVo> listAllBrands();
}
