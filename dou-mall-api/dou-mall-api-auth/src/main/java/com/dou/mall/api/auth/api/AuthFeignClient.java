package com.dou.mall.api.auth.api;

import com.dou.mall.api.auth.api.fallback.AuthRemoteServiceFallbackFactory;
import com.dou.mall.api.auth.bo.AuthUserInfoBo;
import com.dou.mall.api.auth.vo.TokenInfoVo;
import com.dou.mall.common.base.vo.ResponseEntity;
import com.dou.mall.common.feign.config.FeignInnerConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * AuthFeign
 *
 * @author zhoug
 * @date 2025/2/17 22:09
 */

@FeignClient(name = "dou-mall-auth", path = FeignInnerConfig.FEIGN_PATH_PREFIX + "/auth", fallbackFactory = AuthRemoteServiceFallbackFactory.class)
public interface AuthFeignClient {
    /**
     * 创建或者构建tokenInfo
     *
     * @param authUserInfoBo {@link AuthUserInfoBo} 平台信息
     * @return {@link TokenInfoVo} token信息
     */
    @PostMapping("/token/create")
    ResponseEntity<TokenInfoVo> ctOrGetTokenInfoVo(@RequestBody AuthUserInfoBo authUserInfoBo);

    /**
     * 检查token
     *
     * @param authCode 授权码
     * @return {@link AuthUserInfoBo}用户平台信息
     */
    @GetMapping("/token/check")
    ResponseEntity<AuthUserInfoBo> checkToken(@RequestParam String authCode);
}
