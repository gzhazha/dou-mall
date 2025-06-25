package com.open.mall.cart.service.impl;

import com.open.mall.cart.dao.manager.CartManager;
import com.open.mall.cart.domain.bo.CartDetailsBo;
import com.open.mall.cart.domain.vo.CartDetailsVo;
import com.open.mall.cart.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * ClientServiceImpl
 *
 * @author zhoug
 * @date 2025/6/11 19:04
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final CartManager cartManager;

    @Override
    public CartDetailsVo details(Long userId) {
        CartDetailsBo cartDetailsBo = cartManager.getCartDetailsBo(userId);
        if (cartDetailsBo == null) {
            return null;
        }

        return null;
    }
}
