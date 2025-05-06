package com.open.mall.user.dao.mapper;

import com.open.mall.user.domain.po.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author guang
* @description 针对表【user_info(存储核心用户身份信息)】的数据库操作Mapper
* @createDate 2025-04-28 16:46:52
* @Entity com.open.mall.user.domain.po.UserInfo
*/
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}




