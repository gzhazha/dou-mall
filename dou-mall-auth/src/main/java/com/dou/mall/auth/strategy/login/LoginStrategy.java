package com.dou.mall.auth.strategy.login;

import com.dou.mall.api.auth.vo.TokenInfoVo;
import com.dou.mall.auth.model.bo.AuthAccountBo;
import com.dou.mall.auth.model.dto.LoginDto;
import com.dou.mall.auth.enums.LoginTypeEnum;
import com.dou.mall.auth.model.entity.AuthAccount;

/**
 * LoginStrategy
 *
 * @author zhoug
 * @date 2025/2/19 19:10
 */

public interface LoginStrategy {

    /**
     * 登录校验
     *
     * @param loginDto {@link LoginDto}
     * @return {@link TokenInfoVo}
     */
    AuthAccountBo checkLogin(LoginDto loginDto);

    /**
     * 登录，返回token
     *
     * @param loginDto {@link LoginDto}
     * @return {@link TokenInfoVo}
     */
    TokenInfoVo createAndStoreToken(LoginDto loginDto);


    /**
     * 是否支持
     *
     * @param loginType 登录类型，参考{@link com.dou.mall.auth.enums.LoginTypeEnum}
     * @return true:支持,false:不支持
     */
    boolean support(Integer loginType);


    /**
     * 获取登录类型
     *
     * @return {@link com.dou.mall.auth.enums.LoginTypeEnum}
     */
    LoginTypeEnum getLoginTypeEnum();
}
