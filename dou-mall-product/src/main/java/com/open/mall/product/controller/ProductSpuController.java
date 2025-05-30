package com.open.mall.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.product.domain.dto.SpuCreateDto;
import com.open.mall.product.domain.dto.SpuPageDto;
import com.open.mall.product.domain.dto.SpuUpdateDto;
import com.open.mall.product.domain.vo.SpuDetailVo;
import com.open.mall.product.service.ProductSpuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "商品SPU管理接口")
@RestController
@RequestMapping("/spu")
@RequiredArgsConstructor
public class ProductSpuController {

    private final ProductSpuService productSpuService;

    @Operation(summary = "创建商品SPU")
    @PostMapping
    public BaseResult<Boolean> createSpu(@RequestBody SpuCreateDto spu) {
        return BaseResult.success(productSpuService.createSpu(spu));
    }

    @Operation(summary = "更新商品SPU")
    @PutMapping
    public BaseResult<Boolean> updateSpu(@RequestBody SpuUpdateDto spu) {
        return BaseResult.success(productSpuService.updateSpu(spu));
    }

    @Operation(summary = "删除商品SPU")
    @DeleteMapping("/{id}")
    public BaseResult<Boolean> deleteSpu(@PathVariable Long id) {
        return BaseResult.success(productSpuService.deleteSpu(id));
    }

    @Operation(summary = "获取商品SPU详情")
    @GetMapping("/{id}")
    public BaseResult<SpuDetailVo> getSpuById(@PathVariable Long id) {
        return BaseResult.success(productSpuService.getSpuById(id));
    }

    @Operation(summary = "分页查询商品SPU列表")
    @GetMapping("/page")
    public BaseResult<Page<SpuDetailVo>> listSpusByPage(SpuPageDto spuPageDto) {
        return BaseResult.success(productSpuService.listSpusByPage(spuPageDto));
    }

    @Operation(summary = "获取指定分类下的商品SPU列表")
    @GetMapping("/category/{categoryId}")
    public BaseResult<List<SpuDetailVo>> listSpusByCategoryId(@PathVariable Long categoryId) {
        return BaseResult.success(productSpuService.listSpusByCategoryId(categoryId));
    }

    @Operation(summary = "获取指定品牌下的商品SPU列表")
    @GetMapping("/brand/{brandId}")
    public BaseResult<List<SpuDetailVo>> listSpusByBrandId(@PathVariable Long brandId) {
        return BaseResult.success(productSpuService.listSpusByBrandId(brandId));
    }

    @Operation(summary = "更新商品SPU状态")
    @PutMapping("/{id}/status/{status}")
    public BaseResult<Boolean> updateSpuStatus(
            @PathVariable Long id,
            @PathVariable Integer status) {
        return BaseResult.success(productSpuService.updateSpuStatus(id, status));
    }
}