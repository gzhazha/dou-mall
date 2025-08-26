package com.open.mall.api.auth.feign;

import com.open.mall.api.auth.domain.bo.UserInfoInTokenBo;
import com.open.mall.common.base.doman.vo.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * AuthFeign
 *
 * @author zhoug
 * @date 2025/8/22 18:27
 */

@FeignClient(name = "auth", contextId = "tokenInfoFeign")
public interface TokenInfoFeign {

    BaseResult<UserInfoInTokenBo> checkToken(@RequestParam("accessToken") String accessToken);

}
