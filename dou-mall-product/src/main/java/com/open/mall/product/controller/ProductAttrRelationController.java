package com.open.mall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.product.domain.dto.AttrRelationCreateDto;
import com.open.mall.product.domain.dto.AttrRelationPageDto;
import com.open.mall.product.domain.dto.AttrRelationUpdateDto;
import com.open.mall.product.domain.vo.AttrRelationDetailVo;
import com.open.mall.product.service.ProductAttrRelationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "商品属性关系管理接口")
@RestController
@RequestMapping("/attr/relation")
@RequiredArgsConstructor
public class ProductAttrRelationController {

    private final ProductAttrRelationService productAttrRelationService;

    @Operation(summary = "创建属性关系")
    @PostMapping
    public BaseResult<Boolean> createAttrRelation(@RequestBody AttrRelationCreateDto attrRelation) {
        return BaseResult.success(productAttrRelationService.createAttrRelation(attrRelation));
    }

    @Operation(summary = "更新属性关系")
    @PutMapping
    public BaseResult<Boolean> updateAttrRelation(@RequestBody AttrRelationUpdateDto attrRelation) {
        return BaseResult.success(productAttrRelationService.updateAttrRelation(attrRelation));
    }

    @Operation(summary = "删除属性关系")
    @DeleteMapping("/{id}")
    public BaseResult<Boolean> deleteAttrRelation(@PathVariable Long id) {
        return BaseResult.success(productAttrRelationService.deleteAttrRelation(id));
    }

    @Operation(summary = "获取属性关系详情")
    @GetMapping("/{id}")
    public BaseResult<AttrRelationDetailVo> getAttrRelationById(@PathVariable Long id) {
        return BaseResult.success(productAttrRelationService.getAttrRelationById(id));
    }

    @Operation(summary = "分页查询属性关系列表")
    @GetMapping("/page")
    public BaseResult<IPage<AttrRelationDetailVo>> listAttrRelationsByPage(AttrRelationPageDto pageDto) {
        return BaseResult.success(productAttrRelationService.listAttrRelationsByPage(pageDto));
    }

    @Operation(summary = "根据SPU ID查询属性关系列表")
    @GetMapping("/spu/{spuId}")
    public BaseResult<List<AttrRelationDetailVo>> listAttrRelationsBySpuId(@PathVariable Long spuId) {
        return BaseResult.success(productAttrRelationService.listAttrRelationsBySpuId(spuId));
    }
}