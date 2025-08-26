package com.open.mall.user.service.impl;

import com.open.mall.api.user.domain.dto.UserRegisterDto;
import com.open.mall.api.user.domain.vo.UserInfoVo;
import com.open.mall.common.base.utils.DouAssertion;
import com.open.mall.user.converter.UserBeanConverter;
import com.open.mall.user.domain.bo.UserInfoBo;
import com.open.mall.user.manager.UserInfoManager;
import com.open.mall.user.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * UserInfoServiceImpl
 *
 * @author zhoug
 * @date 2025/8/25 10:06
 */

@RequiredArgsConstructor
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoManager userInfoManager;
    private final UserBeanConverter userBeanConverter;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoVo register(UserRegisterDto userRegisterDto) {
        UserInfoBo userInfoBo = userInfoManager.registerUser(userBeanConverter.toUserRegisterBo(userRegisterDto));
        DouAssertion.notNull(userInfoBo,"注册用户信息失败");
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserId(userInfoBo.getUserId());
        return userInfoVo;
    }
}
