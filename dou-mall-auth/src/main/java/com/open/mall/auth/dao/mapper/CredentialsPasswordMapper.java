package com.open.mall.auth.dao.mapper;

import com.open.mall.auth.domain.po.CredentialsPassword;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
* @author guang
* @description 针对表【credentials_password(用户密码及MFA凭证)】的数据库操作Mapper
* @createDate 2025-04-28 15:29:11
* @Entity com.open.mall.auth.domain.po.CredentialsPassword
*/
@Mapper
public interface CredentialsPasswordMapper extends BaseMapper<CredentialsPassword> {

    @Select("select password_hash from credentials_password where user_id = #{userId}")
    String getPasswordHashByUserId(@Param("userId") Long userId);
}




