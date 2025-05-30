package com.open.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.product.converter.ProductBeanConverter;
import com.open.mall.product.dao.mapper.ProductSpuMapper;
import com.open.mall.product.domain.dto.SpuCreateDto;
import com.open.mall.product.domain.dto.SpuPageDto;
import com.open.mall.product.domain.dto.SpuUpdateDto;
import com.open.mall.product.domain.po.ProductSpu;
import com.open.mall.product.domain.vo.SpuDetailVo;
import com.open.mall.product.service.ProductSpuService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSpuServiceImpl implements ProductSpuService {

    private final ProductSpuMapper productSpuMapper;
    private final ProductBeanConverter productBeanConverter;

    @Override
    public boolean createSpu(SpuCreateDto spuCreateDto) {
        ProductSpu spu = productBeanConverter.toProductSpu(spuCreateDto);
        return productSpuMapper.insert(spu) > 0;
    }

    @Override
    public boolean updateSpu(SpuUpdateDto spuUpdateDto) {
        ProductSpu spu = productBeanConverter.toProductSpu(spuUpdateDto);
        return productSpuMapper.updateById(spu) > 0;
    }

    @Override
    public boolean deleteSpu(Long id) {
        if (id == null) {
            return false;
        }
        return productSpuMapper.deleteById(id) > 0;
    }

    @Override
    public SpuDetailVo getSpuById(Long id) {
        if (id == null) {
            return null;
        }
        ProductSpu spu = productSpuMapper.selectById(id);
        return productBeanConverter.toSpuDetailVo(spu);
    }

    @Override
    public Page<SpuDetailVo> listSpusByPage(SpuPageDto spuPageDto) {
        Page<ProductSpu> page = new Page<>(spuPageDto.getPageNum(), spuPageDto.getPageSize());

        LambdaQueryWrapper<ProductSpu> queryWrapper = new LambdaQueryWrapper<>();
        // 设置查询条件
        if (StringUtils.isNotBlank(spuPageDto.getName())) {
            queryWrapper.like(ProductSpu::getName, spuPageDto.getName());
        }
        if (spuPageDto.getCategoryId() != null) {
            queryWrapper.eq(ProductSpu::getCategoryId, spuPageDto.getCategoryId());
        }
        if (spuPageDto.getBrandId() != null) {
            queryWrapper.eq(ProductSpu::getBrandId, spuPageDto.getBrandId());
        }
        if (spuPageDto.getStatus() != null) {
            queryWrapper.eq(ProductSpu::getStatus, spuPageDto.getStatus());
        }
        if (spuPageDto.getSaleMode() != null) {
            queryWrapper.eq(ProductSpu::getSaleMode, spuPageDto.getSaleMode());
        }

        Page<ProductSpu> spuPage = productSpuMapper.selectPage(page, queryWrapper);
        Page<SpuDetailVo> resultPage = new Page<>(spuPage.getCurrent(), spuPage.getSize(), spuPage.getTotal());
        resultPage.setRecords(productBeanConverter.toSpuDetailVoList(spuPage.getRecords()));

        return resultPage;
    }

    @Override
    public List<SpuDetailVo> listSpusByCategoryId(Long categoryId) {
        if (categoryId == null) {
            return null;
        }
        LambdaQueryWrapper<ProductSpu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductSpu::getCategoryId, categoryId)
                .eq(ProductSpu::getStatus, 1)  // 只查询上架的商品
                .orderByDesc(ProductSpu::getUpdateTime);

        List<ProductSpu> spus = productSpuMapper.selectList(queryWrapper);
        return productBeanConverter.toSpuDetailVoList(spus);
    }

    @Override
    public List<SpuDetailVo> listSpusByBrandId(Long brandId) {
        LambdaQueryWrapper<ProductSpu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductSpu::getBrandId, brandId)
                .eq(ProductSpu::getStatus, 1)  // 只查询上架的商品
                .orderByDesc(ProductSpu::getUpdateTime);

        List<ProductSpu> spus = productSpuMapper.selectList(queryWrapper);
        return productBeanConverter.toSpuDetailVoList(spus);
    }

    @Override
    public boolean updateSpuStatus(Long id, Integer status) {
        if (id == null || status == null) {
            return false;
        }
        LambdaUpdateWrapper<ProductSpu> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ProductSpu::getId, id)
                .set(ProductSpu::getStatus, status);

        return productSpuMapper.update(null, updateWrapper) > 0;
    }
}