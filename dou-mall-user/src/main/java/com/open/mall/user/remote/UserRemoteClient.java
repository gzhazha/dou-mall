package com.open.mall.user.remote;

import com.open.mall.api.user.domain.bo.UserInfoBo;
import com.open.mall.api.user.feign.UserFeignClient;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.user.service.UserInfoService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserRemoteClient
 *
 * @author zhoug
 * @date 2025/4/30 14:04
 */
@Validated
@RestController
@RequiredArgsConstructor
public class UserRemoteClient implements UserFeignClient {

    private final UserInfoService userInfoService;

    public BaseResult<UserInfoBo> getUserInfoByMobile(@NotBlank @PathVariable("mobile") String mobile){
        return BaseResult.success(userInfoService.getUserInfoByMobile(mobile));
    }

    public BaseResult<UserInfoBo> getUserInfoByEmail(@NotBlank @PathVariable("email") String email){
        return BaseResult.success(userInfoService.getUserInfoByEmail(email));

    }
    public BaseResult<UserInfoBo> getUserInfoByUsername(@NotBlank @PathVariable("username") String username){
        return BaseResult.success(userInfoService.getUserInfoByUsername(username));

    }
}
