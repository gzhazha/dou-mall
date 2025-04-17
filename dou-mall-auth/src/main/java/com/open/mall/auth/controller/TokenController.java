package com.open.mall.auth.controller;

import com.open.mall.api.auth.dto.LoginDto;
import com.open.mall.api.auth.feign.AuthFeignClient;
import com.open.mall.api.auth.vo.TokenInfo;
import com.open.mall.common.base.domain.vo.BaseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TokenController
 *
 * @author zhoug
 * @date 2025/4/17 09:38
 */

@Tag(name = "token接口")
@RestController
@RequestMapping("/token")
public class TokenController implements AuthFeignClient {

    @Operation(summary = "获取token接口", method = "POST")
    @Override
    public BaseResult<TokenInfo> getOrCreateToken(LoginDto loginDto) {
        return null;
    }

    @Operation(summary = "校验token接口", method = "GET")
    @Override
    public BaseResult<TokenInfo> checkToken(@Parameter(name = "token") String token) {
        return null;
    }

}
