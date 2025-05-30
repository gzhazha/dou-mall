package com.open.mall.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.mall.product.domain.dto.CategoryCreateDto;
import com.open.mall.product.domain.dto.CategoryPageDto;
import com.open.mall.product.domain.dto.CategoryUpdateDto;
import com.open.mall.product.domain.vo.CategoryDetailVo;

import java.util.List;

/**
 * @author guang
 * @description 针对表【product_category】的数据库操作Service
 * @createDate 2025-05-30 15:23:58
 */
public interface ProductCategoryService {
    /**
     * 创建商品分类
     * @param category 商品分类信息
     * @return 创建成功返回true，否则返回false
     */
    boolean createCategory(CategoryCreateDto category);

    /**
     * 更新商品分类
     * @param category 商品分类信息
     * @return 更新成功返回true，否则返回false
     */
    boolean updateCategory(CategoryUpdateDto category);

    /**
     * 删除商品分类
     * @param id 商品分类ID
     * @return 删除成功返回true，否则返回false
     */
    boolean deleteCategory(Long id);

    /**
     * 获取商品分类详情
     * @param id 商品分类ID
     * @return 商品分类信息
     */
    CategoryDetailVo getCategoryById(Long id);

    /**
     * 分页查询商品分类列表
     * @param categoryPageDto 分页查询参数
     * @return 商品分类列表
     */
    Page<CategoryDetailVo> listCategoriesByPage(CategoryPageDto categoryPageDto);

    /**
     * 获取指定父级分类下的商品分类列表
     * @param parentId 父级分类ID
     * @return 商品分类列表
     */
    List<CategoryDetailVo> listCategoriesByParentId(Long parentId);

    /**
     * 获取所有商品分类列表
     * @return 商品分类列表
     */
    List<CategoryDetailVo> listAllCategories();
}
