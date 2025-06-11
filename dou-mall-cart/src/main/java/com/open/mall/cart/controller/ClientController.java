package com.open.mall.cart.controller;

import com.open.mall.cart.domain.vo.CartListVo;
import com.open.mall.cart.service.ClientService;
import com.open.mall.common.base.domain.vo.BaseResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CartController
 *
 * @author zhoug
 * @date 2025/6/11 18:37
 */


@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @GetMapping("/get/all")
    public BaseResult<List<CartListVo>> getAll(Long userId){
        return BaseResult.success(clientService.getAll(userId));
    }
}
