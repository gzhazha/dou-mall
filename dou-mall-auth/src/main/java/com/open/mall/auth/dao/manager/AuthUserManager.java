package com.open.mall.auth.dao.manager;


import com.open.mall.auth.domain.po.AuthUser;


/**
 * AuthUserManager
 *
 * @author zhoug
 * @date 2025/5/6 16:01
 */
public interface AuthUserManager {

    AuthUser getOrCreateAuthUser(Long userId);

    /**
     * 登录记录
     *
     * @param userId       userId
     * @param isSuccessful 是否登录成功
     */
    void loginRecord(Long userId, boolean isSuccessful);
}
