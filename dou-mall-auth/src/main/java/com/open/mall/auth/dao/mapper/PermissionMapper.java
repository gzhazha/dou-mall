package com.open.mall.auth.dao.mapper;

import com.open.mall.auth.domain.po.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author guang
* @description 针对表【permission(系统定义的细粒度权限)】的数据库操作Mapper
* @createDate 2025-04-28 15:29:11
* @Entity com.open.mall.auth.domain.po.Permission
*/
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}




