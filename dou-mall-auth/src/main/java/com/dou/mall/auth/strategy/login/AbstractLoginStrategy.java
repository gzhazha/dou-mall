package com.dou.mall.auth.strategy.login;

import com.dou.mall.api.auth.vo.TokenInfoVo;
import com.dou.mall.auth.manager.TokenManager;
import com.dou.mall.auth.model.bo.AuthAccountBo;
import com.dou.mall.auth.model.dto.LoginDto;
import jakarta.annotation.Resource;

/**
 * AbstractLoginStrategy
 *
 * @author zhoug
 * @date 2025/2/20 18:19
 */


public abstract class AbstractLoginStrategy implements LoginStrategy {

    @Resource
    private TokenManager tokenManager;

    public boolean support(Integer loginType) {
        return loginType != null && getLoginTypeEnum().getType() == loginType;
    }

    @Override
    public TokenInfoVo createAndStoreToken(LoginDto loginDto) {
        AuthAccountBo authAccountBo = checkLogin(loginDto);
        return tokenManager.createAndStoreToken(authAccountBo,getLoginTypeEnum().getType());
    }

}
