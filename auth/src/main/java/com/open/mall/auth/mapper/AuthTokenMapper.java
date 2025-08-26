package com.open.mall.auth.mapper;

import com.open.mall.auth.domain.po.AuthToken;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author guang
* @description 针对表【auth_token(用户登录Token表)】的数据库操作Mapper
* @createDate 2025-08-26 15:47:23
* @Entity com.open.mall.auth.domain.po.AuthToken
*/
@Repository
public interface AuthTokenMapper extends BaseMapper<AuthToken> {

}




