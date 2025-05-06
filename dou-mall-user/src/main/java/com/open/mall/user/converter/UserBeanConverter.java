package com.open.mall.user.converter;

import com.open.mall.api.user.domain.bo.UserInfoBo;
import com.open.mall.user.domain.po.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * Converter
 *
 * @author zhoug
 * @date 2025/4/30 14:20
 */


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserBeanConverter {

    UserInfoBo toUserInfoBo(UserInfo userInfo);
    
}
