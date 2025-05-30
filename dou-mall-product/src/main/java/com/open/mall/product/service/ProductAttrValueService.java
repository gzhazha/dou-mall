package com.open.mall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.open.mall.product.domain.dto.AttrValueCreateDto;
import com.open.mall.product.domain.dto.AttrValuePageDto;
import com.open.mall.product.domain.dto.AttrValueUpdateDto;
import com.open.mall.product.domain.vo.AttrValueDetailVo;

import java.util.List;

/**
 * @author guang
 * @description 针对表【product_attr_value】的数据库操作Service
 * @createDate 2025-05-30 15:23:58
 */
public interface ProductAttrValueService {
    /**
     * 创建属性值
     * @param attrValue 属性值信息
     * @return 创建成功返回true，否则返回false
     */
    boolean createAttrValue(AttrValueCreateDto attrValue);

    /**
     * 更新属性值
     * @param attrValue 属性值信息
     * @return 更新成功返回true，否则返回false
     */
    boolean updateAttrValue(AttrValueUpdateDto attrValue);

    /**
     * 删除属性值
     * @param id 属性值ID
     * @return 删除成功返回true，否则返回false
     */
    boolean deleteAttrValue(Long id);

    /**
     * 获取属性值详情
     * @param id 属性值ID
     * @return 属性值信息
     */
    AttrValueDetailVo getAttrValueById(Long id);

    /**
     * 分页查询属性值列表
     * @param pageDto 分页查询参数
     * @return 属性值列表
     */
    IPage<AttrValueDetailVo> listAttrValuesByPage(AttrValuePageDto pageDto);

    /**
     * 根据属性键ID查询属性值列表
     * @param attrKeyId 属性键ID
     * @return 属性值列表
     */
    List<AttrValueDetailVo> listAttrValuesByKeyId(Long attrKeyId);
}
