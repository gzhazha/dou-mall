package com.open.mall.auth.remote;

import com.open.mall.api.auth.domain.bo.UserInfoInTokenBo;
import com.open.mall.api.auth.feign.TokenFeignClient;
import com.open.mall.auth.service.TokenService;
import com.open.mall.common.base.domain.vo.BaseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * TokenController
 *
 * @author zhoug
 * @date 2025/4/17 09:38
 */

@Tag(name = "token接口")
@RestController
@Validated
@RequiredArgsConstructor
public class TokenRemoteClient implements TokenFeignClient {

    private final TokenService tokenService;

    @Override
    @Operation(summary = "校验token接口", method = "GET")
    public BaseResult<UserInfoInTokenBo> checkToken(@Parameter(name = "token") String token) {
        return BaseResult.success(tokenService.checkToken(token));
    }

}
