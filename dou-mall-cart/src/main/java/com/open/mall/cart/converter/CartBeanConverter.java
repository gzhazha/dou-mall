package com.open.mall.cart.converter;

import com.open.mall.cart.domain.bo.CartDetailsBo;
import com.open.mall.cart.domain.po.Cart;
import com.open.mall.cart.domain.po.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * CartBeanConverter
 *
 * @author zhoug
 * @date 2025/6/24 15:44
 */


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartBeanConverter {

    @Mappings({
            @Mapping(source = "cart.id",target = "cartId"),
            @Mapping(source = "cartItems",target = "itemList"),
    })
    CartDetailsBo toCartDetailsBo(Cart cart, List<CartItem> cartItems);
}
