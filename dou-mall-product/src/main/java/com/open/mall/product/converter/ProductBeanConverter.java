package com.open.mall.product.converter;

import com.open.mall.product.domain.dto.*;
import com.open.mall.product.domain.po.*;
import com.open.mall.product.domain.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * Converter
 *
 * @author zhoug
 * @date 2025/4/30 14:20
 */


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductBeanConverter {

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    Brand toBrand(BrandCreateDto brandCreateDto);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    Brand toBrand(BrandUpdateDto brandUpdateDto);

    BrandDetailVo toBrandDetailVo(Brand brand);

    List<BrandDetailVo> toBrandDetailVoList(List<Brand> records);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ProductCategory toProductCategory(CategoryCreateDto categoryCreateDto);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ProductCategory toProductCategory(CategoryUpdateDto categoryUpdateDto);

    CategoryDetailVo toCategoryDetailVo(ProductCategory productCategory);

    List<CategoryDetailVo> toCategoryDetailVoList(List<ProductCategory> records);



    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ProductSku toProductSku(SkuCreateDto skuCreateDto);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ProductSku toProductSku(SkuUpdateDto skuUpdateDto);

    @Mapping(target = "spuName", ignore = true)
    SkuDetailVo toSkuDetailVo(ProductSku productSku);

    List<SkuDetailVo> toSkuDetailVoList(List<ProductSku> records);



    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ProductSpu toProductSpu(SpuCreateDto spuCreateDto);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ProductSpu toProductSpu(SpuUpdateDto spuUpdateDto);

    @Mapping(target = "categoryName", ignore = true)
    @Mapping(target = "brandName", ignore = true)
    SpuDetailVo toSpuDetailVo(ProductSpu productSpu);

    List<SpuDetailVo> toSpuDetailVoList(List<ProductSpu> records);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ProductAttrKey toProductAttrKey(AttrKeyCreateDto attrKeyCreateDto);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ProductAttrKey toProductAttrKey(AttrKeyUpdateDto attrKeyUpdateDto);

    AttrKeyDetailVo toAttrKeyDetailVo(ProductAttrKey attrKey);

    List<AttrKeyDetailVo> toAttrKeyDetailVoList(List<ProductAttrKey> records);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ProductAttrValue toProductAttrValue(AttrValueCreateDto attrValueCreateDto);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ProductAttrValue toProductAttrValue(AttrValueUpdateDto attrValueUpdateDto);

    AttrValueDetailVo toAttrValueDetailVo(ProductAttrValue attrValue);

    List<AttrValueDetailVo> toAttrValueDetailVoList(List<ProductAttrValue> records);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ProductAttrRelation toProductAttrRelation(AttrRelationCreateDto attrRelationCreateDto);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ProductAttrRelation toProductAttrRelation(AttrRelationUpdateDto attrRelationUpdateDto);

    @Mapping(target = "attrValue", ignore = true)
    @Mapping(target = "attrKeyName", ignore = true)
    AttrRelationDetailVo toAttrRelationDetailVo(ProductAttrRelation attrRelation);

    List<AttrRelationDetailVo> toAttrRelationDetailVoList(List<ProductAttrRelation> records);
}
