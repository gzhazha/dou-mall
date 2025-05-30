package com.open.mall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.product.domain.dto.AttrKeyCreateDto;
import com.open.mall.product.domain.dto.AttrKeyPageDto;
import com.open.mall.product.domain.dto.AttrKeyUpdateDto;
import com.open.mall.product.domain.vo.AttrKeyDetailVo;
import com.open.mall.product.service.ProductAttrKeyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "商品属性键管理接口")
@RestController
@RequestMapping("/attr/key")
@RequiredArgsConstructor
public class ProductAttrKeyController {

    private final ProductAttrKeyService productAttrKeyService;

    @Operation(summary = "创建属性键")
    @PostMapping
    public BaseResult<Boolean> createAttrKey(@RequestBody AttrKeyCreateDto attrKey) {
        return BaseResult.success(productAttrKeyService.createAttrKey(attrKey));
    }

    @Operation(summary = "更新属性键")
    @PutMapping
    public BaseResult<Boolean> updateAttrKey(@RequestBody AttrKeyUpdateDto attrKey) {
        return BaseResult.success(productAttrKeyService.updateAttrKey(attrKey));
    }

    @Operation(summary = "删除属性键")
    @DeleteMapping("/{id}")
    public BaseResult<Boolean> deleteAttrKey(@PathVariable Long id) {
        return BaseResult.success(productAttrKeyService.deleteAttrKey(id));
    }

    @Operation(summary = "获取属性键详情")
    @GetMapping("/{id}")
    public BaseResult<AttrKeyDetailVo> getAttrKeyById(@PathVariable Long id) {
        return BaseResult.success(productAttrKeyService.getAttrKeyById(id));
    }

    @Operation(summary = "分页查询属性键列表")
    @GetMapping("/page")
    public BaseResult<IPage<AttrKeyDetailVo>> listAttrKeysByPage(AttrKeyPageDto pageDto) {
        return BaseResult.success(productAttrKeyService.listAttrKeysByPage(pageDto));
    }

    @Operation(summary = "根据分类ID查询属性键列表")
    @GetMapping("/category/{categoryId}")
    public BaseResult<List<AttrKeyDetailVo>> listAttrKeysByCategoryId(@PathVariable Long categoryId) {
        return BaseResult.success(productAttrKeyService.listAttrKeysByCategoryId(categoryId));
    }
}