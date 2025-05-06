package com.open.mall.auth.dao.mapper;

import com.open.mall.auth.domain.po.CredentialsSocial;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author guang
* @description 针对表【credentials_social(用户绑定的第三方社交账号信息)】的数据库操作Mapper
* @createDate 2025-04-28 15:29:11
* @Entity com.open.mall.auth.domain.po.CredentialsSocial
*/
@Mapper
public interface CredentialsSocialMapper extends BaseMapper<CredentialsSocial> {

}




