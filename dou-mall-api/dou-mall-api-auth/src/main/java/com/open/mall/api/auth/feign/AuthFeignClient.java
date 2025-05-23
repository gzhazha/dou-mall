package com.open.mall.api.auth.feign;

import com.open.mall.api.auth.domain.bo.AuthRegisterBo;
import com.open.mall.api.auth.domain.bo.UserInfoInTokenBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.open.mall.common.base.domain.vo.BaseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * AuthFeignClient
 *
 * @author zhoug
 * @date 2025/4/16 17:13
 */
@FeignClient(name = "dou-mall-auth", contextId = "authFeignClient",path = "auth")
public interface AuthFeignClient {

    @GetMapping("/token/check")
    BaseResult<UserInfoInTokenBo> checkToken(@RequestParam String token);

    @PostMapping("/register")
    BaseResult<Void> register(@RequestBody AuthRegisterBo authRegisterBo);
}
