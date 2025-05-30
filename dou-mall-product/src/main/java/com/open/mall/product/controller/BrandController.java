package com.open.mall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.product.domain.dto.BrandCreateDto;
import com.open.mall.product.domain.dto.BrandPageDto;
import com.open.mall.product.domain.dto.BrandUpdateDto;
import com.open.mall.product.domain.vo.BrandDetailVo;
import com.open.mall.product.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "品牌管理接口")
@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @Operation(summary = "创建品牌")
    @PostMapping
    public BaseResult<Boolean> createBrand(@RequestBody BrandCreateDto brand) {
        return BaseResult.success(brandService.createBrand(brand));
    }

    @Operation(summary = "更新品牌")
    @PutMapping
    public BaseResult<Boolean> updateBrand(@RequestBody BrandUpdateDto brand) {
        return BaseResult.success(brandService.updateBrand(brand));
    }

    @Operation(summary = "删除品牌")
    @DeleteMapping("/{id}")
    public BaseResult<Boolean> deleteBrand(@PathVariable Long id) {
        return BaseResult.success(brandService.deleteBrand(id));
    }

    @Operation(summary = "获取品牌详情")
    @GetMapping("/{id}")
    public BaseResult<BrandDetailVo> getBrandById(@PathVariable Long id) {
        return BaseResult.success(brandService.getBrandById(id));
    }

    @Operation(summary = "分页查询品牌列表")
    @GetMapping("/page")
    public BaseResult<IPage<BrandDetailVo>> listBrandsByPage(BrandPageDto brandPageDto) {
        return BaseResult.success(brandService.listBrandsByPage(brandPageDto));
    }

    @Operation(summary = "获取所有品牌")
    @GetMapping("/all")
    public BaseResult<List<BrandDetailVo>> listAllBrands() {
        return BaseResult.success(brandService.listAllBrands());
    }
}