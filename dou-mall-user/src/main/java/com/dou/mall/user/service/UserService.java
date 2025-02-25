package com.dou.mall.user.service;

import com.dou.mall.user.vo.UserInfoVo;

/**
 * UserService
 *
 * @author zhoug
 * @date 2025/2/19 10:01
 */

public interface UserService {
    /**
     * 获取用户信息
     * @param userId 用户ID
     * @return {@link UserInfoVo}
     */
    UserInfoVo findUserInfoByUserId(Long userId);
}
