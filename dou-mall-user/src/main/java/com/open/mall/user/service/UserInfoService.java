package com.open.mall.user.service;


import com.open.mall.api.user.domain.bo.UserInfoBo;

/**
* @author guang
* @description 针对表【user_info(存储核心用户身份信息)】的数据库操作Service
* @createDate 2025-04-28 16:46:52
*/
public interface UserInfoService {

    UserInfoBo getUserInfoByMobile(String mobile);

    UserInfoBo getUserInfoByEmail(String email);

    UserInfoBo getUserInfoByUsername(String username);
}
