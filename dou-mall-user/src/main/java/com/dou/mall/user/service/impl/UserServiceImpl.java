package com.dou.mall.user.service.impl;

import com.dou.mall.user.service.UserService;
import com.dou.mall.user.vo.UserInfoVo;
import org.springframework.stereotype.Service;



/**
 * UserServiceImpl
 *
 * @author zhoug
 * @date 2025/2/19 10:09
 */

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserInfoVo findUserInfoByUserId(Long userId) {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserId(0L);
        userInfoVo.setUserName("123");
        return userInfoVo;
    }
}
