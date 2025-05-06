package com.open.mall.auth.dao.mapper;

import com.open.mall.auth.domain.po.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author guang
* @description 针对表【role(系统定义的角色)】的数据库操作Mapper
* @createDate 2025-04-28 15:29:11
* @Entity com.open.mall.auth.domain.po.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}




