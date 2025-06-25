package com.open.mall.cart.dao.manager;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.open.mall.cart.converter.CartBeanConverter;
import com.open.mall.cart.dao.mapper.CartItemMapper;
import com.open.mall.cart.dao.mapper.CartMapper;
import com.open.mall.cart.domain.bo.CartDetailsBo;
import com.open.mall.cart.domain.po.Cart;
import com.open.mall.cart.domain.po.CartItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * CartManager
 *
 * @author zhoug
 * @date 2025/6/24 15:20
 */


@RequiredArgsConstructor
@Component
@Slf4j
public class CartManager {
    private final CartMapper cartMapper;
    private final CartItemMapper cartItemMapper;
    private final CartBeanConverter cartBeanConverter;

    /**
     * 获取购物车详情
     *
     * @param userId 用户id
     * @return {@link CartDetailsBo}
     */
    public CartDetailsBo getCartDetailsBo(Long userId) {
        Cart cart = cartMapper.selectOne(Wrappers.<Cart>lambdaQuery().eq(Cart::getUserId, userId));
        if (cart == null) {
            return null;
        }
        List<CartItem> cartItems = cartItemMapper.selectList(Wrappers.<CartItem>lambdaQuery().eq(CartItem::getCartId, cart.getId()));
        return cartBeanConverter.toCartDetailsBo(cart, cartItems);
    }
}
