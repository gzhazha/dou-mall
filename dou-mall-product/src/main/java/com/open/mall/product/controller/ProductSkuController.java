package com.open.mall.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.product.domain.dto.SkuCreateDto;
import com.open.mall.product.domain.dto.SkuPageDto;
import com.open.mall.product.domain.dto.SkuUpdateDto;
import com.open.mall.product.domain.vo.SkuDetailVo;
import com.open.mall.product.service.ProductSkuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "商品SKU管理接口")
@RestController
@RequestMapping("/sku")
@RequiredArgsConstructor
public class ProductSkuController {

    private final ProductSkuService productSkuService;

    @Operation(summary = "创建商品SKU")
    @PostMapping
    public BaseResult<Boolean> createSku(@RequestBody SkuCreateDto sku) {
        return BaseResult.success(productSkuService.createSku(sku));
    }

    @Operation(summary = "更新商品SKU")
    @PutMapping
    public BaseResult<Boolean> updateSku(@RequestBody SkuUpdateDto sku) {
        return BaseResult.success(productSkuService.updateSku(sku));
    }

    @Operation(summary = "删除商品SKU")
    @DeleteMapping("/{id}")
    public BaseResult<Boolean> deleteSku(@PathVariable Long id) {
        return BaseResult.success(productSkuService.deleteSku(id));
    }

    @Operation(summary = "获取商品SKU详情")
    @GetMapping("/{id}")
    public BaseResult<SkuDetailVo> getSkuById(@PathVariable Long id) {
        return BaseResult.success(productSkuService.getSkuById(id));
    }

    @Operation(summary = "分页查询商品SKU列表")
    @GetMapping("/page")
    public BaseResult<Page<SkuDetailVo>> listSkusByPage(SkuPageDto skuPageDto) {
        return BaseResult.success(productSkuService.listSkusByPage(skuPageDto));
    }

    @Operation(summary = "获取指定SPU下的商品SKU列表")
    @GetMapping("/spu/{spuId}")
    public BaseResult<List<SkuDetailVo>> listSkusBySpuId(@PathVariable Long spuId) {
        return BaseResult.success(productSkuService.listSkusBySpuId(spuId));
    }

    @Operation(summary = "更新商品SKU状态")
    @PutMapping("/{id}/status/{status}")
    public BaseResult<Boolean> updateSkuStatus(
            @PathVariable Long id,
            @PathVariable Integer status) {
        return BaseResult.success(productSkuService.updateSkuStatus(id, status));
    }

    @Operation(summary = "更新商品SKU库存")
    @PutMapping("/{id}/stock/{stock}")
    public BaseResult<Boolean> updateSkuStock(
            @PathVariable Long id,
            @PathVariable Integer stock) {
        return BaseResult.success(productSkuService.updateSkuStock(id, stock));
    }
}