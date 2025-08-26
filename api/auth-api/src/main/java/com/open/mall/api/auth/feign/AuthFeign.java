package com.open.mall.api.auth.feign;

import com.open.mall.api.auth.domain.dto.AuthSaveDto;
import com.open.mall.common.base.doman.vo.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * AuthFeign
 *
 * @author zhoug
 * @date 2025/8/25 09:35
 */


@FeignClient(name = "auth" , contextId = "authFeign")
public interface AuthFeign {

    BaseResult<Integer> save(@RequestBody AuthSaveDto authSaveDto);
}
