package com.dou.mall.api.user.api;

import com.dou.mall.api.user.model.vo.UserInfoVo;
import com.dou.mall.common.base.vo.ResponseEntity;
import com.dou.mall.common.feign.config.FeignInnerConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * UserFeignClient
 *
 * @author zhoug
 * @date 2025/2/20 18:01
 */

@FeignClient(name = "dou-mall-user", path = FeignInnerConfig.FEIGN_PATH_PREFIX + "/user")
public interface UserFeignClient {

    @GetMapping("/info/{userId}")
    ResponseEntity<UserInfoVo> getUserInfoVoByUserId(@PathVariable("userId") Long userId);
}
