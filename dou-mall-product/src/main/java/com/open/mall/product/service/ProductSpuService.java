package com.open.mall.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.product.domain.dto.SpuCreateDto;
import com.open.mall.product.domain.dto.SpuPageDto;
import com.open.mall.product.domain.dto.SpuUpdateDto;
import com.open.mall.product.domain.vo.SpuDetailVo;

import java.util.List;

/**
 * @author guang
 * @description 针对表【product_spu】的数据库操作Service
 * @createDate 2025-05-30 15:23:58
 */
public interface ProductSpuService {
    /**
     * 创建商品SPU
     * @param spu 商品SPU信息
     * @return 创建成功返回true，否则返回false
     */
    boolean createSpu(SpuCreateDto spu);

    /**
     * 更新商品SPU
     * @param spu 商品SPU信息
     * @return 更新成功返回true，否则返回false
     */
    boolean updateSpu(SpuUpdateDto spu);

    /**
     * 删除商品SPU
     * @param id 商品SPU ID
     * @return 删除成功返回true，否则返回false
     */
    boolean deleteSpu(Long id);

    /**
     * 获取商品SPU详情
     * @param id 商品SPU ID
     * @return 商品SPU信息
     */
    SpuDetailVo getSpuById(Long id);

    /**
     * 分页查询商品SPU列表
     * @param spuPageDto 分页查询参数
     * @return 商品SPU列表
     */
    Page<SpuDetailVo> listSpusByPage(SpuPageDto spuPageDto);

    /**
     * 获取指定分类下的商品SPU列表
     * @param categoryId 分类ID
     * @return 商品SPU列表
     */
    List<SpuDetailVo> listSpusByCategoryId(Long categoryId);

    /**
     * 获取指定品牌下的商品SPU列表
     * @param brandId 品牌ID
     * @return 商品SPU列表
     */
    List<SpuDetailVo> listSpusByBrandId(Long brandId);

    /**
     * 更新商品SPU状态
     * @param id 商品SPU ID
     * @param status 商品状态
     * @return 更新成功返回true，否则返回false
     */
    boolean updateSpuStatus(Long id, Integer status);
}
