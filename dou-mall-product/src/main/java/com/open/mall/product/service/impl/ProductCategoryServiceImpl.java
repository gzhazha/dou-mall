package com.open.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.product.converter.ProductBeanConverter;
import com.open.mall.product.dao.mapper.ProductCategoryMapper;
import com.open.mall.product.domain.dto.CategoryCreateDto;
import com.open.mall.product.domain.dto.CategoryPageDto;
import com.open.mall.product.domain.dto.CategoryUpdateDto;
import com.open.mall.product.domain.po.ProductCategory;
import com.open.mall.product.domain.vo.CategoryDetailVo;
import com.open.mall.product.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryMapper productCategoryMapper;
    private final ProductBeanConverter productBeanConverter;

    @Override
    public boolean createCategory(CategoryCreateDto categoryCreateDto) {
        ProductCategory category = productBeanConverter.toProductCategory(categoryCreateDto);
        return productCategoryMapper.insert(category) > 0;
    }

    @Override
    public boolean updateCategory(CategoryUpdateDto categoryUpdateDto) {
        ProductCategory category = productBeanConverter.toProductCategory(categoryUpdateDto);
        return productCategoryMapper.updateById(category) > 0;
    }

    @Override
    public boolean deleteCategory(Long id) {
        if (id == null) {
            return false;
        }
        return productCategoryMapper.deleteById(id) > 0;
    }

    @Override
    public CategoryDetailVo getCategoryById(Long id) {
        if (id == null) {
            return null;
        }
        ProductCategory category = productCategoryMapper.selectById(id);
        return productBeanConverter.toCategoryDetailVo(category);
    }

    @Override
    public Page<CategoryDetailVo> listCategoriesByPage(CategoryPageDto categoryPageDto) {
        Page<ProductCategory> page = new Page<>(categoryPageDto.getPageNum(), categoryPageDto.getPageSize());

        LambdaQueryWrapper<ProductCategory> queryWrapper = new LambdaQueryWrapper<>();
        // 设置查询条件
        if (categoryPageDto.getParentId() != null) {
            queryWrapper.eq(ProductCategory::getParentId, categoryPageDto.getParentId());
        }
        if (StringUtils.isNotBlank(categoryPageDto.getName())) {
            queryWrapper.like(ProductCategory::getName, categoryPageDto.getName());
        }
        if (categoryPageDto.getLevel() != null) {
            queryWrapper.eq(ProductCategory::getLevel, categoryPageDto.getLevel());
        }
        if (categoryPageDto.getIsVisible() != null) {
            queryWrapper.eq(ProductCategory::getIsVisible, categoryPageDto.getIsVisible());
        }
        queryWrapper.orderByAsc(ProductCategory::getSort);

        Page<ProductCategory> categoryPage = productCategoryMapper.selectPage(page, queryWrapper);
        Page<CategoryDetailVo> resultPage = new Page<>(categoryPage.getCurrent(), categoryPage.getSize(), categoryPage.getTotal());
        resultPage.setRecords(productBeanConverter.toCategoryDetailVoList(categoryPage.getRecords()));

        return resultPage;
    }

    @Override
    public List<CategoryDetailVo> listCategoriesByParentId(Long parentId) {
        if (parentId == null) {
            return null;
        }
        LambdaQueryWrapper<ProductCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductCategory::getParentId, parentId)
                .eq(ProductCategory::getIsVisible, true)
                .orderByAsc(ProductCategory::getSort);

        List<ProductCategory> categories = productCategoryMapper.selectList(queryWrapper);
        return productBeanConverter.toCategoryDetailVoList(categories);
    }

    @Override
    public List<CategoryDetailVo> listAllCategories() {
        LambdaQueryWrapper<ProductCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductCategory::getIsVisible, true)
                .orderByAsc(ProductCategory::getSort);

        List<ProductCategory> categories = productCategoryMapper.selectList(queryWrapper);
        return productBeanConverter.toCategoryDetailVoList(categories);
    }
}