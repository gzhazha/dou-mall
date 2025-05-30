package com.open.mall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.product.domain.dto.AttrValueCreateDto;
import com.open.mall.product.domain.dto.AttrValuePageDto;
import com.open.mall.product.domain.dto.AttrValueUpdateDto;
import com.open.mall.product.domain.vo.AttrValueDetailVo;
import com.open.mall.product.service.ProductAttrValueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "商品属性值管理接口")
@RestController
@RequestMapping("/attr/value")
@RequiredArgsConstructor
public class ProductAttrValueController {

    private final ProductAttrValueService productAttrValueService;

    @Operation(summary = "创建属性值")
    @PostMapping
    public BaseResult<Boolean> createAttrValue(@RequestBody AttrValueCreateDto attrValue) {
        return BaseResult.success(productAttrValueService.createAttrValue(attrValue));
    }

    @Operation(summary = "更新属性值")
    @PutMapping
    public BaseResult<Boolean> updateAttrValue(@RequestBody AttrValueUpdateDto attrValue) {
        return BaseResult.success(productAttrValueService.updateAttrValue(attrValue));
    }

    @Operation(summary = "删除属性值")
    @DeleteMapping("/{id}")
    public BaseResult<Boolean> deleteAttrValue(@PathVariable Long id) {
        return BaseResult.success(productAttrValueService.deleteAttrValue(id));
    }

    @Operation(summary = "获取属性值详情")
    @GetMapping("/{id}")
    public BaseResult<AttrValueDetailVo> getAttrValueById(@PathVariable Long id) {
        return BaseResult.success(productAttrValueService.getAttrValueById(id));
    }

    @Operation(summary = "分页查询属性值列表")
    @GetMapping("/page")
    public BaseResult<IPage<AttrValueDetailVo>> listAttrValuesByPage(AttrValuePageDto pageDto) {
        return BaseResult.success(productAttrValueService.listAttrValuesByPage(pageDto));
    }

    @Operation(summary = "根据属性键ID查询属性值列表")
    @GetMapping("/key/{attrKeyId}")
    public BaseResult<List<AttrValueDetailVo>> listAttrValuesByKeyId(@PathVariable Long attrKeyId) {
        return BaseResult.success(productAttrValueService.listAttrValuesByKeyId(attrKeyId));
    }
}