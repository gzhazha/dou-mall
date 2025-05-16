package com.open.mall.auth.dao.manager;


/**
 * CredentialsPasswordManager
 *
 * @author zhoug
 * @date 2025/5/6 17:16
 */


public interface CredentialsPasswordManager {

    String getPasswordHashByUserId(Long userId);
}
