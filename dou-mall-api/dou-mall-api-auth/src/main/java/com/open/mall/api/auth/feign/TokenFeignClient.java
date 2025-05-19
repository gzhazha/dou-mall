package com.open.mall.api.auth.feign;

import com.open.mall.api.auth.domain.bo.UserInfoInTokenBo;
import com.open.mall.common.feign.constants.FeignConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.open.mall.common.base.domain.vo.BaseResult;

/**
 * AuthFeignClient
 *
 * @author zhoug
 * @date 2025/4/16 17:13
 */
@FeignClient(name = "dou-mall-auth", contextId = "tokenFeignClient")
public interface TokenFeignClient {

    @GetMapping(FeignConstant.FEIGN_PATH + "/auth/token/check")
    BaseResult<UserInfoInTokenBo> checkToken(String token);

}
