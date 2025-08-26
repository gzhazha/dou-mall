package com.open.mall.auth.mapper;

import com.open.mall.auth.domain.po.UserAuth;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author guang
* @description 针对表【user_auth(用户认证表)】的数据库操作Mapper
* @createDate 2025-08-22 17:22:49
* @Entity com.open.mall.auth.domain.po.UserAuth
*/
@Repository
public interface UserAuthMapper extends BaseMapper<UserAuth> {

}




