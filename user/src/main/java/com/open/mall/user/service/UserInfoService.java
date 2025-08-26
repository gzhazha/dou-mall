package com.open.mall.user.service;


import com.open.mall.api.user.domain.dto.UserRegisterDto;
import com.open.mall.api.user.domain.vo.UserInfoVo;

/**
 * UserInfoService
 *
 * @author zhoug
 * @date 2025/8/25 10:04
 */

public interface UserInfoService {
    /**
     * 用户注册
     * @param userRegisterDto {@link UserRegisterDto}
     * @return {@link UserInfoVo} 用户信息
     */
    UserInfoVo register(UserRegisterDto userRegisterDto);
}
