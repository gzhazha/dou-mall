package com.open.mall.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.product.domain.dto.SkuCreateDto;
import com.open.mall.product.domain.dto.SkuPageDto;
import com.open.mall.product.domain.dto.SkuUpdateDto;
import com.open.mall.product.domain.vo.SkuDetailVo;

import java.util.List;

/**
 * @author guang
 * @description 针对表【product_sku】的数据库操作Service
 * @createDate 2025-05-30 15:23:58
 */
public interface ProductSkuService {
    /**
     * 创建商品SKU
     * @param sku 商品SKU信息
     * @return 创建成功返回true，否则返回false
     */
    boolean createSku(SkuCreateDto sku);

    /**
     * 更新商品SKU
     * @param sku 商品SKU信息
     * @return 更新成功返回true，否则返回false
     */
    boolean updateSku(SkuUpdateDto sku);

    /**
     * 删除商品SKU
     * @param id 商品SKU ID
     * @return 删除成功返回true，否则返回false
     */
    boolean deleteSku(Long id);

    /**
     * 获取商品SKU详情
     * @param id 商品SKU ID
     * @return 商品SKU信息
     */
    SkuDetailVo getSkuById(Long id);

    /**
     * 分页查询商品SKU列表
     * @param skuPageDto 分页查询参数
     * @return 商品SKU列表
     */
    Page<SkuDetailVo> listSkusByPage(SkuPageDto skuPageDto);

    /**
     * 获取指定SPU下的商品SKU列表
     * @param spuId SPU ID
     * @return 商品SKU列表
     */
    List<SkuDetailVo> listSkusBySpuId(Long spuId);

    /**
     * 更新商品SKU状态
     * @param id 商品SKU ID
     * @param status 商品状态
     * @return 更新成功返回true，否则返回false
     */
    boolean updateSkuStatus(Long id, Integer status);

    /**
     * 更新商品SKU库存
     * @param id 商品SKU ID
     * @param stock 库存数量
     * @return 更新成功返回true，否则返回false
     */
    boolean updateSkuStock(Long id, Integer stock);
}
