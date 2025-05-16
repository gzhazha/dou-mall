package com.open.mall.auth.dao.manager.impl;

import com.open.mall.auth.dao.manager.CredentialsPasswordManager;
import com.open.mall.auth.dao.mapper.CredentialsPasswordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * CredentialsPasswordManager
 *
 * @author zhoug
 * @date 2025/5/6 17:16
 */


@RequiredArgsConstructor
@Component
public class CredentialsPasswordManagerImpl implements CredentialsPasswordManager {
    private final CredentialsPasswordMapper credentialsPasswordMapper;

    public String getPasswordHashByUserId(Long userId) {
        if (userId == null) {
            return null;
        }
        return credentialsPasswordMapper.getPasswordHashByUserId(userId);
    }
}
