package com.open.mall.user.manager.impl;

import com.open.mall.user.converter.UserBeanConverter;
import com.open.mall.user.domain.bo.UserInfoBo;
import com.open.mall.user.domain.bo.UserRegisterBo;
import com.open.mall.user.domain.po.UserAccount;
import com.open.mall.user.domain.po.UserProfile;
import com.open.mall.user.domain.po.UserSetting;
import com.open.mall.user.manager.UserInfoManager;
import com.open.mall.user.mapper.UserAccountMapper;
import com.open.mall.user.mapper.UserExtendMapper;
import com.open.mall.user.mapper.UserProfileMapper;
import com.open.mall.user.mapper.UserSettingMapper;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * UserInfoManagerImpl
 *
 * @author zhoug
 * @date 2025/8/25 10:21
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class UserInfoManagerImpl implements UserInfoManager {
    private final UserSettingMapper userSettingMapper;
    private final UserProfileMapper userProfileMapper;
    private final UserExtendMapper userExtendMapper;
    private final UserAccountMapper userAccountMapper;
    private final UserBeanConverter userBeanConverter;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoBo registerUser(UserRegisterBo userRegisterBo) {
        UserProfile userProfile = userBeanConverter.toUserProfile(userRegisterBo);
        if (userProfile == null) {
            return null;
        }
        int insert = userProfileMapper.insert(userProfile);
        if (insert != 1) {
            return null;
        }
        Long userId = userProfile.getUserId();
        this.insertDefault(userId);
        return userBeanConverter.toUserInfoBo(userProfileMapper.selectById(userId));
    }

    private void insertDefault(Long userId) {
        if (userId == null) {
            return;
        }
        insertDefaultUserSetting(userId);
        insertDefaultUserAccount(userId);
    }

    private void insertDefaultUserAccount(Long userId) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(userId);
        userAccount.setLevel(0);
        userAccount.setPoints(0);
        userAccount.setBalance(new BigDecimal("0"));
        userAccountMapper.insert(userAccount);
    }

    private void insertDefaultUserSetting(Long userId) {
        UserSetting userSetting = new UserSetting();
        userSetting.setUserId(userId);
        userSetting.setLanguage("zh_CN");
        userSetting.setTimezone("");
        userSetting.setNotifyEmail(0);
        userSetting.setNotifySms(0);
        userSetting.setNotifyPush(0);
        userSetting.setTheme("light");
        userSettingMapper.insert(userSetting);
    }
}
