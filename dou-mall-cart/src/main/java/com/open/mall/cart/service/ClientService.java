package com.open.mall.cart.service;


import com.open.mall.cart.domain.vo.CartListVo;

import java.util.List;

/**
* @author guang
* @description 针对表【cart_item(购物车项表)】的数据库操作Service
* @createDate 2025-06-11 18:36:50
*/
public interface ClientService {

    List<CartListVo> getAll(Long userId);
}
