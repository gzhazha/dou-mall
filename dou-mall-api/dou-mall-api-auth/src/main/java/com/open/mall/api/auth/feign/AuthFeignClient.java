package com.open.mall.api.auth.feign;

import com.open.mall.api.auth.dto.LoginDto;
import com.open.mall.api.auth.vo.TokenInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.open.mall.common.base.domain.vo.BaseResult;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * AuthFeignClient
 *
 * @author zhoug
 * @date 2025/4/16 17:13
 */
@FeignClient(contextId = "authFeignClient",value = "")
public interface AuthFeignClient {

    @PostMapping("/token/login")
    BaseResult<TokenInfo> getOrCreateToken(@RequestBody LoginDto loginDto);

    @GetMapping("/token/check")
    BaseResult<TokenInfo> checkToken(String token);

}
