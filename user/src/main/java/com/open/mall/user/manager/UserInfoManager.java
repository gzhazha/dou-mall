package com.open.mall.user.manager;

import com.open.mall.user.domain.bo.UserInfoBo;
import com.open.mall.user.domain.bo.UserRegisterBo;

/**
 * UserInfoManager
 *
 * @author zhoug
 * @date 2025/8/25 10:17
 */

public interface UserInfoManager {

    /**
     * 注册用户
     * @param userRegisterBo {@link UserRegisterBo}
     * @return {@link UserInfoBo } 用户信息
     */
    UserInfoBo registerUser(UserRegisterBo userRegisterBo);
}
