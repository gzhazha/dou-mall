package com.open.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.product.converter.ProductBeanConverter;
import com.open.mall.product.dao.mapper.BrandMapper;
import com.open.mall.product.domain.dto.BrandCreateDto;
import com.open.mall.product.domain.dto.BrandPageDto;
import com.open.mall.product.domain.dto.BrandUpdateDto;
import com.open.mall.product.domain.po.Brand;
import com.open.mall.product.domain.vo.BrandDetailVo;
import com.open.mall.product.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandMapper brandMapper;
    private final ProductBeanConverter productBeanConverter;

    @Override
    public boolean createBrand(BrandCreateDto brandCreateDto) {
        Brand brand = productBeanConverter.toBrand(brandCreateDto);
        return brandMapper.insert(brand) > 0;
    }

    @Override
    public boolean updateBrand(BrandUpdateDto brandUpdateDto) {
        Brand brand = productBeanConverter.toBrand(brandUpdateDto);
        return brandMapper.updateById(brand) > 0;
    }

    @Override
    public boolean deleteBrand(Long id) {
        if (id == null) {
            return false;
        }
        return brandMapper.deleteById(id) > 0;
    }

    @Override
    public BrandDetailVo getBrandById(Long id) {
        if (id == null) {
            return null;
        }
        Brand brand = brandMapper.selectById(id);
        return productBeanConverter.toBrandDetailVo(brand);
    }

    @Override
    public IPage<BrandDetailVo> listBrandsByPage(BrandPageDto brandPageDto) {
        String name = brandPageDto.getName();
        LambdaQueryWrapper<Brand> wrapper = Wrappers.<Brand>lambdaQuery()
                .like(StringUtils.isNotBlank(name), Brand::getName, name)
                .orderByAsc(Brand::getSort);

        IPage<Brand> page = brandPageDto.buildPage();
        brandMapper.selectPage(page, wrapper);
        List<Brand> records = page.getRecords();
        List<BrandDetailVo> voList = productBeanConverter.toBrandDetailVoList(records);
        IPage<BrandDetailVo> result = new Page<>(page.getCurrent(), page.getSize(), page.getTotal());
        result.setRecords(voList);
        return result;
    }

    @Override
    public List<BrandDetailVo> listAllBrands() {
        LambdaQueryWrapper<Brand> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(Brand::getSort);
        return productBeanConverter.toBrandDetailVoList(brandMapper.selectList(wrapper));
    }
}