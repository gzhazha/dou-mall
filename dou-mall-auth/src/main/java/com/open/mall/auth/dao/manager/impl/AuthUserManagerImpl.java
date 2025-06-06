package com.open.mall.auth.dao.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.open.mall.auth.dao.manager.AuthUserManager;
import com.open.mall.auth.dao.mapper.AuthUserMapper;
import com.open.mall.auth.dao.mapper.CredentialsPasswordMapper;
import com.open.mall.auth.domain.po.AuthUser;
import com.open.mall.auth.domain.po.CredentialsPassword;
import com.open.mall.common.base.utils.WebUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * AuthUserManager
 *
 * @author zhoug
 * @date 2025/5/6 16:01
 */
@RequiredArgsConstructor
@Component
public class AuthUserManagerImpl implements AuthUserManager {
    private final AuthUserMapper authUserMapper;
    private final CredentialsPasswordMapper credentialsPasswordMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthUser getOrCreateAuthUser(Long userId) {
        if (userId == null) {
            return null;
        }
        LambdaQueryWrapper<AuthUser> queryWrapper =
                Wrappers.<AuthUser>lambdaQuery().eq(AuthUser::getUserId, userId);
        AuthUser authUser = authUserMapper.selectOne(queryWrapper);
        if (authUser == null) {
            authUser = new AuthUser();
            authUser.setUserId(userId);
           if ( authUserMapper.insert(authUser)>0){
               return authUser;
           }
        }
        return null;
    }

    /**
     * 登录记录
     * @param userId userId
     * @param isSuccessful 是否登录成功
     */
    public void loginRecord(Long userId, boolean isSuccessful) {
        if (userId == null) {
            return;
        }
        AuthUser authUser = authUserMapper.selectById(userId);
        if (authUser == null) {
            return;
        }
        LocalDateTime lastLoginAt = LocalDateTime.now();
        if (isSuccessful) {
            AuthUser user = new AuthUser();
            user.setUserId(userId);
            user.setLastLoginAt(lastLoginAt);
            user.setLastLoginIp(WebUtil.getIpAddress());
            authUserMapper.updateById(user);
        }else {
            authUserMapper.addOneFailure(userId);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(Long userId, String password) {
        AuthUser authUser = new AuthUser();
        authUser.setUserId(userId);
        authUserMapper.insert(authUser);

        CredentialsPassword credentialsPassword = new CredentialsPassword();
        credentialsPassword.setUserId(userId);
        credentialsPassword.setPasswordHash(passwordEncoder.encode(password));
        credentialsPasswordMapper.insert(credentialsPassword);
    }
}
