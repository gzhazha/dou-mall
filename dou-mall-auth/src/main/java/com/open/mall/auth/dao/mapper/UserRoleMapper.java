package com.open.mall.auth.dao.mapper;

import com.open.mall.auth.domain.po.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author guang
* @description 针对表【user_role(用户与角色的关联)】的数据库操作Mapper
* @createDate 2025-04-28 15:29:11
* @Entity com.open.mall.auth.domain.po.UserRole
*/
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}




