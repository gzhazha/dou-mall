package com.open.mall.cart.service.impl;

import com.open.mall.cart.domain.vo.CartListVo;
import com.open.mall.cart.mapper.CartItemMapper;
import com.open.mall.cart.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private final CartItemMapper cartItemMapper;
    @Override
    public List<CartListVo> getAll(Long userId) {
        return cartItemMapper.selectList(null);
    }
}
