package com.open.mall.api.user.feign;

import com.open.mall.api.user.domain.bo.UserInfoBo;
import com.open.mall.common.base.domain.vo.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * AuthFeignClient
 *
 * @author zhoug
 * @date 2025/4/16 17:13
 */
@FeignClient(name = "dou-mall-user", contextId = "userInfoFeignClient")
public interface UserInfoFeignClient {

    @GetMapping("/user/info/mobile/{mobile}")
    BaseResult<UserInfoBo> getUserInfoByMobile(@PathVariable("mobile") String mobile);

    @GetMapping("/user/info/email/{email}")
    BaseResult<UserInfoBo> getUserInfoByEmail(@PathVariable("email") String email);

    @GetMapping("/user/info/username/{username}")
    BaseResult<UserInfoBo> getUserInfoByUsername(@PathVariable("username") String username);

}
