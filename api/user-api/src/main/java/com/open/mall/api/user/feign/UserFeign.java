package com.open.mall.api.user.feign;

import com.open.mall.api.user.domain.dto.UserRegisterDto;
import com.open.mall.api.user.domain.vo.UserInfoVo;
import com.open.mall.common.base.doman.vo.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * UserFeign
 *
 * @author zhoug
 * @date 2025/8/26 10:58
 */

@FeignClient(value = "user",contextId = "userFeign",path = "/user/info")
public interface UserFeign {
    @PostMapping("/register")
    BaseResult<UserInfoVo> register(@RequestBody UserRegisterDto userRegisterDto);
}
