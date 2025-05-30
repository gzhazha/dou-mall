package com.open.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.product.converter.ProductBeanConverter;
import com.open.mall.product.dao.mapper.ProductAttrValueMapper;
import com.open.mall.product.domain.dto.AttrValueCreateDto;
import com.open.mall.product.domain.dto.AttrValuePageDto;
import com.open.mall.product.domain.dto.AttrValueUpdateDto;
import com.open.mall.product.domain.po.ProductAttrValue;
import com.open.mall.product.domain.vo.AttrValueDetailVo;
import com.open.mall.product.service.ProductAttrValueService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductAttrValueServiceImpl implements ProductAttrValueService {

    private final ProductAttrValueMapper productAttrValueMapper;
    private final ProductBeanConverter productBeanConverter;

    @Override
    public boolean createAttrValue(AttrValueCreateDto attrValueCreateDto) {
        ProductAttrValue attrValue = productBeanConverter.toProductAttrValue(attrValueCreateDto);
        return productAttrValueMapper.insert(attrValue) > 0;
    }

    @Override
    public boolean updateAttrValue(AttrValueUpdateDto attrValueUpdateDto) {
        ProductAttrValue attrValue = productBeanConverter.toProductAttrValue(attrValueUpdateDto);
        return productAttrValueMapper.updateById(attrValue) > 0;
    }

    @Override
    public boolean deleteAttrValue(Long id) {
        if (id == null) {
            return false;
        }
        return productAttrValueMapper.deleteById(id) > 0;
    }

    @Override
    public AttrValueDetailVo getAttrValueById(Long id) {
        if (id == null) {
            return null;
        }
        ProductAttrValue attrValue = productAttrValueMapper.selectById(id);
        return productBeanConverter.toAttrValueDetailVo(attrValue);
    }

    @Override
    public IPage<AttrValueDetailVo> listAttrValuesByPage(AttrValuePageDto pageDto) {
        Page<ProductAttrValue> page = new Page<>(pageDto.getPageNum(), pageDto.getPageSize());

        LambdaQueryWrapper<ProductAttrValue> queryWrapper = new LambdaQueryWrapper<>();
        // 设置查询条件
        if (pageDto.getAttrKeyId() != null) {
            queryWrapper.eq(ProductAttrValue::getAttrKeyId, pageDto.getAttrKeyId());
        }
        if (StringUtils.isNotBlank(pageDto.getValue())) {
            queryWrapper.like(ProductAttrValue::getValue, pageDto.getValue());
        }

        Page<ProductAttrValue> attrValuePage = productAttrValueMapper.selectPage(page, queryWrapper);
        IPage<AttrValueDetailVo> resultPage = new Page<>(attrValuePage.getCurrent(), attrValuePage.getSize(), attrValuePage.getTotal());
        resultPage.setRecords(productBeanConverter.toAttrValueDetailVoList(attrValuePage.getRecords()));

        return resultPage;
    }

    @Override
    public List<AttrValueDetailVo> listAttrValuesByKeyId(Long attrKeyId) {
        if (attrKeyId == null) {
            return null;
        }
        LambdaQueryWrapper<ProductAttrValue> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductAttrValue::getAttrKeyId, attrKeyId);

        List<ProductAttrValue> attrValues = productAttrValueMapper.selectList(queryWrapper);
        return productBeanConverter.toAttrValueDetailVoList(attrValues);
    }
}