package com.open.mall.user.converter;

import com.open.mall.api.auth.domain.bo.AuthRegisterBo;
import com.open.mall.api.user.domain.bo.UserInfoBo;
import com.open.mall.user.domain.dto.ClientRegisterDto;
import com.open.mall.user.domain.po.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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

    @Mapping(target = "userId",ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "registrationIp", ignore = true)
    @Mapping(target = "phoneVerified", ignore = true)
    @Mapping(target = "nickname", ignore = true)
    @Mapping(target = "emailVerified", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    UserInfo toUserInfo(ClientRegisterDto clientRegisterDto);

    AuthRegisterBo toAuthRegisterBo(Long userId,ClientRegisterDto clientRegisterDto);
}
