package com.open.mall.auth.service;

import com.open.mall.auth.AuthApplication;
import com.open.mall.auth.domain.po.UserAuth;

import java.time.LocalDateTime;

import com.open.mall.auth.mapper.UserAuthMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = AuthApplication.class)
class UserAuthServiceTest {

    @Autowired
    UserAuthMapper userAuthMapper;

    @Test
    void insertUserAuth() {
        UserAuth entity = new UserAuth();
        entity.setAuthId(null);
        entity.setUserId(1L);
        entity.setAuthType("sms");
        entity.setIdentifier("111222");
        entity.setCredential("111222");
        entity.setSalt("1");
        entity.setStatus(0);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        userAuthMapper.insert(entity);
    }

}