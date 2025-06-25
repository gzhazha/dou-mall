package com.open.mall.cart.controller;

import com.open.mall.cart.domain.vo.CartDetailsVo;
import com.open.mall.cart.service.ClientService;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.common.security.AuthUserContext;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    @GetMapping("/details")
    public BaseResult<CartDetailsVo> details(){
        return BaseResult.success(clientService.details(AuthUserContext.getUserId()));
    }
}
