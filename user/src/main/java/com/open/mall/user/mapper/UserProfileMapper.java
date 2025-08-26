package com.open.mall.user.mapper;

import com.open.mall.user.domain.po.UserProfile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author guang
* @description 针对表【user_profile(用户基本资料表)】的数据库操作Mapper
* @createDate 2025-08-25 09:58:48
* @Entity com.open.mall.user.domain.po.UserProfile
*/
@Repository
public interface UserProfileMapper extends BaseMapper<UserProfile> {

}




