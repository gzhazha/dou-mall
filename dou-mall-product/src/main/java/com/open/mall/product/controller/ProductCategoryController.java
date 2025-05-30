package com.open.mall.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.product.domain.dto.CategoryCreateDto;
import com.open.mall.product.domain.dto.CategoryPageDto;
import com.open.mall.product.domain.dto.CategoryUpdateDto;
import com.open.mall.product.domain.vo.CategoryDetailVo;
import com.open.mall.product.service.ProductCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "商品分类管理接口")
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @Operation(summary = "创建商品分类")
    @PostMapping
    public BaseResult<Boolean> createCategory(@RequestBody CategoryCreateDto category) {
        return BaseResult.success(productCategoryService.createCategory(category));
    }

    @Operation(summary = "更新商品分类")
    @PutMapping
    public BaseResult<Boolean> updateCategory(@RequestBody CategoryUpdateDto category) {
        return BaseResult.success(productCategoryService.updateCategory(category));
    }

    @Operation(summary = "删除商品分类")
    @DeleteMapping("/{id}")
    public BaseResult<Boolean> deleteCategory(@PathVariable Long id) {
        return BaseResult.success(productCategoryService.deleteCategory(id));
    }

    @Operation(summary = "获取商品分类详情")
    @GetMapping("/{id}")
    public BaseResult<CategoryDetailVo> getCategoryById(@PathVariable Long id) {
        return BaseResult.success(productCategoryService.getCategoryById(id));
    }

    @Operation(summary = "分页查询商品分类列表")
    @GetMapping("/page")
    public BaseResult<Page<CategoryDetailVo>> listCategoriesByPage(CategoryPageDto categoryPageDto) {
        return BaseResult.success(productCategoryService.listCategoriesByPage(categoryPageDto));
    }

    @Operation(summary = "获取所有商品分类")
    @GetMapping("/all")
    public BaseResult<List<CategoryDetailVo>> listAllCategories() {
        return BaseResult.success(productCategoryService.listAllCategories());
    }

    @Operation(summary = "获取指定父级分类下的子分类列表")
    @GetMapping("/parent/{parentId}")
    public BaseResult<List<CategoryDetailVo>> listCategoriesByParentId(@PathVariable Long parentId) {
        return BaseResult.success(productCategoryService.listCategoriesByParentId(parentId));
    }
}