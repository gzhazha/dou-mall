package com.open.mall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.open.mall.product.domain.dto.AttrRelationCreateDto;
import com.open.mall.product.domain.dto.AttrRelationPageDto;
import com.open.mall.product.domain.dto.AttrRelationUpdateDto;
import com.open.mall.product.domain.vo.AttrRelationDetailVo;

import java.util.List;

/**
 * @author guang
 * @description 针对表【product_attr_relation】的数据库操作Service
 * @createDate 2025-05-30 15:23:58
 */
public interface ProductAttrRelationService {
    /**
     * 创建属性关系
     * @param attrRelation 属性关系信息
     * @return 创建成功返回true，否则返回false
     */
    boolean createAttrRelation(AttrRelationCreateDto attrRelation);

    /**
     * 更新属性关系
     * @param attrRelation 属性关系信息
     * @return 更新成功返回true，否则返回false
     */
    boolean updateAttrRelation(AttrRelationUpdateDto attrRelation);

    /**
     * 删除属性关系
     * @param id 属性关系ID
     * @return 删除成功返回true，否则返回false
     */
    boolean deleteAttrRelation(Long id);

    /**
     * 获取属性关系详情
     * @param id 属性关系ID
     * @return 属性关系信息
     */
    AttrRelationDetailVo getAttrRelationById(Long id);

    /**
     * 分页查询属性关系列表
     * @param pageDto 分页查询参数
     * @return 属性关系列表
     */
    IPage<AttrRelationDetailVo> listAttrRelationsByPage(AttrRelationPageDto pageDto);

    /**
     * 根据SPU ID查询属性关系列表
     * @param spuId SPU ID
     * @return 属性关系列表
     */
    List<AttrRelationDetailVo> listAttrRelationsBySpuId(Long spuId);
}
