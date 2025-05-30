package com.open.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.product.converter.ProductBeanConverter;
import com.open.mall.product.dao.mapper.ProductSkuMapper;
import com.open.mall.product.domain.dto.SkuCreateDto;
import com.open.mall.product.domain.dto.SkuPageDto;
import com.open.mall.product.domain.dto.SkuUpdateDto;
import com.open.mall.product.domain.po.ProductSku;
import com.open.mall.product.domain.vo.SkuDetailVo;
import com.open.mall.product.service.ProductSkuService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSkuServiceImpl implements ProductSkuService {

    private final ProductSkuMapper productSkuMapper;
    private final ProductBeanConverter productBeanConverter;

    @Override
    public boolean createSku(SkuCreateDto skuCreateDto) {
        ProductSku sku = productBeanConverter.toProductSku(skuCreateDto);
        return productSkuMapper.insert(sku) > 0;
    }

    @Override
    public boolean updateSku(SkuUpdateDto skuUpdateDto) {
        ProductSku sku = productBeanConverter.toProductSku(skuUpdateDto);
        return productSkuMapper.updateById(sku) > 0;
    }

    @Override
    public boolean deleteSku(Long id) {
        if (id == null) {
            return false;
        }
        return productSkuMapper.deleteById(id) > 0;
    }

    @Override
    public SkuDetailVo getSkuById(Long id) {
        if (id == null) {
            return null;
        }
        ProductSku sku = productSkuMapper.selectById(id);
        return productBeanConverter.toSkuDetailVo(sku);
    }

    @Override
    public Page<SkuDetailVo> listSkusByPage(SkuPageDto skuPageDto) {
        Page<ProductSku> page = new Page<>(skuPageDto.getPageNum(), skuPageDto.getPageSize());

        LambdaQueryWrapper<ProductSku> queryWrapper = new LambdaQueryWrapper<>();
        // 设置查询条件
        if (skuPageDto.getSpuId() != null) {
            queryWrapper.eq(ProductSku::getSpuId, skuPageDto.getSpuId());
        }
        if (StringUtils.isNotBlank(skuPageDto.getSkuCode())) {
            queryWrapper.like(ProductSku::getSkuCode, skuPageDto.getSkuCode());
        }
        if (skuPageDto.getMinPrice() != null) {
            queryWrapper.ge(ProductSku::getPrice, skuPageDto.getMinPrice());
        }
        if (skuPageDto.getMaxPrice() != null) {
            queryWrapper.le(ProductSku::getPrice, skuPageDto.getMaxPrice());
        }
        if (skuPageDto.getStatus() != null) {
            queryWrapper.eq(ProductSku::getStatus, skuPageDto.getStatus());
        }

        Page<ProductSku> skuPage = productSkuMapper.selectPage(page, queryWrapper);
        Page<SkuDetailVo> resultPage = new Page<>(skuPage.getCurrent(), skuPage.getSize(), skuPage.getTotal());
        resultPage.setRecords(productBeanConverter.toSkuDetailVoList(skuPage.getRecords()));

        return resultPage;
    }

    @Override
    public List<SkuDetailVo> listSkusBySpuId(Long spuId) {
        if (spuId == null) {
            return null;
        }
        LambdaQueryWrapper<ProductSku> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductSku::getSpuId, spuId)
                .eq(ProductSku::getStatus, 1)  // 只查询上架的商品
                .orderByAsc(ProductSku::getPrice);

        List<ProductSku> skus = productSkuMapper.selectList(queryWrapper);
        return productBeanConverter.toSkuDetailVoList(skus);
    }

    @Override
    public boolean updateSkuStatus(Long id, Integer status) {
        if (id == null || status == null) {
            return false;
        }
        LambdaUpdateWrapper<ProductSku> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ProductSku::getId, id)
                .set(ProductSku::getStatus, status);

        return productSkuMapper.update(null, updateWrapper) > 0;
    }

    @Override
    public boolean updateSkuStock(Long id, Integer stock) {
        if (id == null || stock == null || stock < 0) {
            return false;
        }
        LambdaUpdateWrapper<ProductSku> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ProductSku::getId, id)
                .set(ProductSku::getStock, stock);

        return productSkuMapper.update(null, updateWrapper) > 0;
    }
}