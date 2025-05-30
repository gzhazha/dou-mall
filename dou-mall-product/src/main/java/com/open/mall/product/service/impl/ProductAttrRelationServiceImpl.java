package com.open.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.product.converter.ProductBeanConverter;
import com.open.mall.product.dao.mapper.ProductAttrRelationMapper;
import com.open.mall.product.domain.dto.AttrRelationCreateDto;
import com.open.mall.product.domain.dto.AttrRelationPageDto;
import com.open.mall.product.domain.dto.AttrRelationUpdateDto;
import com.open.mall.product.domain.po.ProductAttrRelation;
import com.open.mall.product.domain.vo.AttrRelationDetailVo;
import com.open.mall.product.service.ProductAttrRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductAttrRelationServiceImpl implements ProductAttrRelationService {

    private final ProductAttrRelationMapper productAttrRelationMapper;
    private final ProductBeanConverter productBeanConverter;

    @Override
    public boolean createAttrRelation(AttrRelationCreateDto attrRelationCreateDto) {
        ProductAttrRelation attrRelation = productBeanConverter.toProductAttrRelation(attrRelationCreateDto);
        return productAttrRelationMapper.insert(attrRelation) > 0;
    }

    @Override
    public boolean updateAttrRelation(AttrRelationUpdateDto attrRelationUpdateDto) {
        ProductAttrRelation attrRelation = productBeanConverter.toProductAttrRelation(attrRelationUpdateDto);
        return productAttrRelationMapper.updateById(attrRelation) > 0;
    }

    @Override
    public boolean deleteAttrRelation(Long id) {
        if (id == null) {
            return false;
        }
        return productAttrRelationMapper.deleteById(id) > 0;
    }

    @Override
    public AttrRelationDetailVo getAttrRelationById(Long id) {
        if (id == null) {
            return null;
        }
        ProductAttrRelation attrRelation = productAttrRelationMapper.selectById(id);
        return productBeanConverter.toAttrRelationDetailVo(attrRelation);
    }

    @Override
    public IPage<AttrRelationDetailVo> listAttrRelationsByPage(AttrRelationPageDto pageDto) {
        Page<ProductAttrRelation> page = new Page<>(pageDto.getPageNum(), pageDto.getPageSize());

        LambdaQueryWrapper<ProductAttrRelation> queryWrapper = new LambdaQueryWrapper<>();
        // 设置查询条件
        if (pageDto.getSpuId() != null) {
            queryWrapper.eq(ProductAttrRelation::getSpuId, pageDto.getSpuId());
        }
        if (pageDto.getAttrKeyId() != null) {
            queryWrapper.eq(ProductAttrRelation::getAttrKeyId, pageDto.getAttrKeyId());
        }
        if (pageDto.getAttrValueId() != null) {
            queryWrapper.eq(ProductAttrRelation::getAttrValueId, pageDto.getAttrValueId());
        }

        Page<ProductAttrRelation> attrRelationPage = productAttrRelationMapper.selectPage(page, queryWrapper);
        IPage<AttrRelationDetailVo> resultPage = new Page<>(attrRelationPage.getCurrent(), attrRelationPage.getSize(), attrRelationPage.getTotal());
        resultPage.setRecords(productBeanConverter.toAttrRelationDetailVoList(attrRelationPage.getRecords()));

        return resultPage;
    }

    @Override
    public List<AttrRelationDetailVo> listAttrRelationsBySpuId(Long spuId) {
        if (spuId == null) {
            return null;
        }
        LambdaQueryWrapper<ProductAttrRelation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductAttrRelation::getSpuId, spuId);

        List<ProductAttrRelation> attrRelations = productAttrRelationMapper.selectList(queryWrapper);
        return productBeanConverter.toAttrRelationDetailVoList(attrRelations);
    }
}