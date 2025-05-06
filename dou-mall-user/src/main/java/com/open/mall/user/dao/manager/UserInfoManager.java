package com.open.mall.user.dao.manager;

import com.open.mall.user.dao.mapper.UserInfoMapper;
import com.open.mall.user.domain.po.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * UserInfoManager
 *
 * @author zhoug
 * @date 2025/4/30 14:47
 */


@Component
@RequiredArgsConstructor
@Slf4j
public class UserInfoManager {
    private final UserInfoMapper userInfoMapper;

    public UserInfo createUserInfoByEmail(String email) {
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(email);
        userInfoMapper.insert(userInfo);
        return userInfoMapper.selectById(userInfo.getUserId());
    }

    public UserInfo createUserInfoByPhone(String phone) {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhoneNumber(phone);
        userInfoMapper.insert(userInfo);
        return userInfoMapper.selectById(userInfo.getUserId());
    }

    public UserInfo createUserInfoByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfoMapper.insert(userInfo);
        return userInfoMapper.selectById(userInfo.getUserId());
    }
}
