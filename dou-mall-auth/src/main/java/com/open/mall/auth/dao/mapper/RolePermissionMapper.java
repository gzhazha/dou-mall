package com.open.mall.auth.dao.mapper;

import com.open.mall.auth.domain.po.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author guang
* @description 针对表【role_permission(角色与权限的关联)】的数据库操作Mapper
* @createDate 2025-04-28 15:29:11
* @Entity com.open.mall.auth.domain.po.RolePermission
*/
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

}




