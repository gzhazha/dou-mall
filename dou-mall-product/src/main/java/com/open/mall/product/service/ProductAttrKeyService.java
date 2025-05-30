package com.open.mall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.open.mall.product.domain.dto.AttrKeyCreateDto;
import com.open.mall.product.domain.dto.AttrKeyPageDto;
import com.open.mall.product.domain.dto.AttrKeyUpdateDto;
import com.open.mall.product.domain.vo.AttrKeyDetailVo;

import java.util.List;

/**
 * @author guang
 * @description 针对表【product_attr_key】的数据库操作Service
 * @createDate 2025-05-30 15:23:58
 */
public interface ProductAttrKeyService {
    /**
     * 创建属性键
     * @param attrKey 属性键信息
     * @return 创建成功返回true，否则返回false
     */
    boolean createAttrKey(AttrKeyCreateDto attrKey);

    /**
     * 更新属性键
     * @param attrKey 属性键信息
     * @return 更新成功返回true，否则返回false
     */
    boolean updateAttrKey(AttrKeyUpdateDto attrKey);

    /**
     * 删除属性键
     * @param id 属性键ID
     * @return 删除成功返回true，否则返回false
     */
    boolean deleteAttrKey(Long id);

    /**
     * 获取属性键详情
     * @param id 属性键ID
     * @return 属性键信息
     */
    AttrKeyDetailVo getAttrKeyById(Long id);

    /**
     * 分页查询属性键列表
     * @param pageDto 分页查询参数
     * @return 属性键列表
     */
    IPage<AttrKeyDetailVo> listAttrKeysByPage(AttrKeyPageDto pageDto);

    /**
     * 根据分类ID查询属性键列表
     * @param categoryId 分类ID
     * @return 属性键列表
     */
    List<AttrKeyDetailVo> listAttrKeysByCategoryId(Long categoryId);
}
