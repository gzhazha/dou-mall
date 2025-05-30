package com.open.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.product.converter.ProductBeanConverter;
import com.open.mall.product.dao.mapper.ProductAttrKeyMapper;
import com.open.mall.product.domain.dto.AttrKeyCreateDto;
import com.open.mall.product.domain.dto.AttrKeyPageDto;
import com.open.mall.product.domain.dto.AttrKeyUpdateDto;
import com.open.mall.product.domain.po.ProductAttrKey;
import com.open.mall.product.domain.vo.AttrKeyDetailVo;
import com.open.mall.product.service.ProductAttrKeyService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductAttrKeyServiceImpl implements ProductAttrKeyService {

    private final ProductAttrKeyMapper productAttrKeyMapper;
    private final ProductBeanConverter productBeanConverter;

    @Override
    public boolean createAttrKey(AttrKeyCreateDto attrKeyCreateDto) {
        ProductAttrKey attrKey = productBeanConverter.toProductAttrKey(attrKeyCreateDto);
        return productAttrKeyMapper.insert(attrKey) > 0;
    }

    @Override
    public boolean updateAttrKey(AttrKeyUpdateDto attrKeyUpdateDto) {
        ProductAttrKey attrKey = productBeanConverter.toProductAttrKey(attrKeyUpdateDto);
        return productAttrKeyMapper.updateById(attrKey) > 0;
    }

    @Override
    public boolean deleteAttrKey(Long id) {
        if (id == null) {
            return false;
        }
        return productAttrKeyMapper.deleteById(id) > 0;
    }

    @Override
    public AttrKeyDetailVo getAttrKeyById(Long id) {
        if (id == null) {
            return null;
        }
        ProductAttrKey attrKey = productAttrKeyMapper.selectById(id);
        return productBeanConverter.toAttrKeyDetailVo(attrKey);
    }

    @Override
    public IPage<AttrKeyDetailVo> listAttrKeysByPage(AttrKeyPageDto pageDto) {
        Page<ProductAttrKey> page = new Page<>(pageDto.getPageNum(), pageDto.getPageSize());

        LambdaQueryWrapper<ProductAttrKey> queryWrapper = new LambdaQueryWrapper<>();
        // 设置查询条件
        if (pageDto.getCategoryId() != null) {
            queryWrapper.eq(ProductAttrKey::getCategoryId, pageDto.getCategoryId());
        }
        if (StringUtils.isNotBlank(pageDto.getName())) {
            queryWrapper.like(ProductAttrKey::getName, pageDto.getName());
        }
        if (pageDto.getType() != null) {
            queryWrapper.eq(ProductAttrKey::getType, pageDto.getType());
        }

        Page<ProductAttrKey> attrKeyPage = productAttrKeyMapper.selectPage(page, queryWrapper);
        IPage<AttrKeyDetailVo> resultPage = new Page<>(attrKeyPage.getCurrent(), attrKeyPage.getSize(), attrKeyPage.getTotal());
        resultPage.setRecords(productBeanConverter.toAttrKeyDetailVoList(attrKeyPage.getRecords()));

        return resultPage;
    }

    @Override
    public List<AttrKeyDetailVo> listAttrKeysByCategoryId(Long categoryId) {
        if (categoryId == null) {
            return null;
        }
        LambdaQueryWrapper<ProductAttrKey> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductAttrKey::getCategoryId, categoryId);

        List<ProductAttrKey> attrKeys = productAttrKeyMapper.selectList(queryWrapper);
        return productBeanConverter.toAttrKeyDetailVoList(attrKeys);
    }
}