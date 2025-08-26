package com.open.mall.user.converter;

import com.open.mall.api.user.domain.dto.UserRegisterDto;
import com.open.mall.user.domain.bo.UserInfoBo;
import com.open.mall.user.domain.bo.UserRegisterBo;
import com.open.mall.user.domain.po.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * UserBeanConverter
 *
 * @author zhoug
 * @date 2025/8/25 14:46
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserBeanConverter {

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    UserProfile toUserProfile(UserRegisterBo userRegisterBo);

    UserInfoBo toUserInfoBo(UserProfile userProfile);

    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "nickname", ignore = true)
    @Mapping(target = "gender", ignore = true)
    @Mapping(target = "birthday", ignore = true)
    @Mapping(target = "avatarUrl", ignore = true)
    UserRegisterBo toUserRegisterBo(UserRegisterDto userRegisterDto);
}
