package com.open.mall.cart.dao.mapper;

import com.open.mall.cart.domain.po.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author guang
* @description 针对表【cart(购物车表)】的数据库操作Mapper
* @createDate 2025-06-24 15:19:54
* @Entity com.open.mall.cart.domain.po.Cart
*/
@Mapper
public interface CartMapper extends BaseMapper<Cart> {

}




