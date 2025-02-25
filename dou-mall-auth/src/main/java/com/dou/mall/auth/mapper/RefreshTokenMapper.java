package com.dou.mall.auth.mapper;

import com.dou.mall.auth.model.entity.RefreshToken;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author guang
* @description 针对表【refresh_token(刷新token表)】的数据库操作Mapper
* @createDate 2025-02-24 23:28:38
* @Entity com.dou.mall.auth.model.entity.RefreshToken
*/
@Repository
public interface RefreshTokenMapper extends BaseMapper<RefreshToken> {

}

