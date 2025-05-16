package com.open.mall.user.dao.manager;

import com.open.mall.user.domain.po.UserInfo;

/**
 * UserInfoManager
 *
 * @author zhoug
 * @date 2025/4/30 14:47
 */


public interface UserInfoManager {

    UserInfo createUserInfoByEmail(String email);

    UserInfo createUserInfoByPhone(String phone);

    UserInfo createUserInfoByUsername(String username);
}
