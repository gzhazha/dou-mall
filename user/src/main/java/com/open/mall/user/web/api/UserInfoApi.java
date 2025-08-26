package com.open.mall.user.web.api;

import com.open.mall.api.user.domain.dto.UserRegisterDto;
import com.open.mall.api.user.domain.vo.UserInfoVo;
import com.open.mall.api.user.feign.UserFeign;
import com.open.mall.user.service.UserInfoService;
import com.open.mall.common.base.doman.vo.BaseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserInfoApi
 *
 * @author zhoug
 * @date 2025/8/25 10:01
 */

@RequiredArgsConstructor
@RestController
public class UserInfoApi implements UserFeign {

    private final UserInfoService userInfoService;

    public BaseResult<UserInfoVo> register(@RequestBody UserRegisterDto userRegisterDto){
        return BaseResult.success(userInfoService.register(userRegisterDto));
    }
}
