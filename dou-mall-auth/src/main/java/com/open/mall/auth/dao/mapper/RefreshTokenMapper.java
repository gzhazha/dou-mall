package com.open.mall.auth.dao.mapper;

import com.open.mall.auth.domain.po.RefreshToken;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author guang
* @description 针对表【refresh_token(存储用户的刷新令牌)】的数据库操作Mapper
* @createDate 2025-04-28 15:29:11
* @Entity com.open.mall.auth.domain.po.RefreshToken
*/
@Mapper
public interface RefreshTokenMapper extends BaseMapper<RefreshToken> {

}




