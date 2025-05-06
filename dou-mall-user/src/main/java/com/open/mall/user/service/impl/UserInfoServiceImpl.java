package com.open.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.open.mall.api.user.domain.bo.UserInfoBo;
import com.open.mall.common.base.utils.MallAssert;
import com.open.mall.user.converter.UserBeanConverter;
import com.open.mall.user.dao.manager.UserInfoManager;
import com.open.mall.user.domain.po.UserInfo;
import com.open.mall.user.dao.mapper.UserInfoMapper;
import com.open.mall.user.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author guang
 * @description 针对表【user_info(存储核心用户身份信息)】的数据库操作Service实现
 * @createDate 2025-04-28 16:46:52
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoMapper userInfoMapper;
    private final UserInfoManager userInfoManager;
    private final UserBeanConverter userBeanConverter;

    @Override
    public UserInfoBo getUserInfoByMobile(String mobile) {
        LambdaQueryWrapper<UserInfo> wrapper = Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getPhoneNumber, mobile);
        UserInfo userInfo = userInfoMapper.selectOne(wrapper);
        if (userInfo == null) {
            userInfo = userInfoManager.createUserInfoByPhone(mobile);
        }
        return buildUserInfoBo(userInfo);
    }

    @Override
    public UserInfoBo getUserInfoByEmail(String email) {
        LambdaQueryWrapper<UserInfo> wrapper = Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getEmail, email);
        UserInfo userInfo = userInfoMapper.selectOne(wrapper);
        if (userInfo == null) {
            userInfo = userInfoManager.createUserInfoByEmail(email);
        }
        return buildUserInfoBo(userInfo);
    }

    private UserInfoBo buildUserInfoBo(UserInfo userInfo) {
        MallAssert.notNull(userInfo, "userInfo为空");
        return userBeanConverter.toUserInfoBo(userInfo);
    }

    @Override
    public UserInfoBo getUserInfoByUsername(String username) {
        LambdaQueryWrapper<UserInfo> wrapper = Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUsername, username);
        UserInfo userInfo = userInfoMapper.selectOne(wrapper);
        if (userInfo == null) {
            userInfo = userInfoManager.createUserInfoByUsername(username);
        }
        return buildUserInfoBo(userInfo);
    }
}




