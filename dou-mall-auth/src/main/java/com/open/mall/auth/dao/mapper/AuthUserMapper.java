package com.open.mall.auth.dao.mapper;

import com.open.mall.auth.domain.po.AuthUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
* @author guang
* @description 针对表【auth_user(存储认证系统中的用户状态)】的数据库操作Mapper
* @createDate 2025-04-28 15:29:11
* @Entity com.open.mall.auth.domain.po.AuthUser
*/
@Mapper
public interface AuthUserMapper extends BaseMapper<AuthUser> {

    @Update("update auth_user set failed_attempts = failed_attempts+1 where user_id = #{userId}")
    void addOneFailure(@Param("userId") Long userId);
}




