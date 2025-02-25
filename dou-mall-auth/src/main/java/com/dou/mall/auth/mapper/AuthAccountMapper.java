package com.dou.mall.auth.mapper;

import com.dou.mall.auth.model.entity.AuthAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* @author guang
* @description 针对表【auth_account】的数据库操作Mapper
* @createDate 2025-02-21 14:38:24
* @Entity com.dou.mall.auth.model.entity.AuthAccount
*/
@Repository
public interface AuthAccountMapper extends BaseMapper<AuthAccount> {

    com.dou.mall.auth.model.bo.AuthAccountBo selectAuthAccountBoByPhoneAndSysType(@Param("phone") String phone, @Param("sysType") Integer sysType);
}

