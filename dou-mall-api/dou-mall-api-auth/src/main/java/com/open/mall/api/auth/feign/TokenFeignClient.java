package com.open.mall.api.auth.feign;

import com.open.mall.api.auth.domain.bo.UserInfoInTokenBo;
import com.open.mall.api.auth.domain.dto.CaptchaLoginDto;
import com.open.mall.api.auth.domain.vo.TokenInfoVo;
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
@FeignClient(name = "dou-mall-auth", contextId = "tokenFeignClient")
public interface TokenFeignClient {

    @PostMapping("/auth/token/login/captcha")
    BaseResult<TokenInfoVo> getOrCreateToken(@RequestBody CaptchaLoginDto captchaLoginDto);

    @GetMapping("/auth/token/check")
    BaseResult<UserInfoInTokenBo> checkToken(String token);

}
