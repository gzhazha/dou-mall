package com.dou.mall.common.security.context;

import com.dou.mall.api.auth.bo.AuthUserInfoBo;

/**
 * AuthUserContent
 *
 * @author zhoug
 * @date 2025/2/19 11:08
 */


public class AuthUserContext {
    private static final ThreadLocal<AuthUserInfoBo> TOKEN_INFO_HOLDER = new ThreadLocal<>();

    public static AuthUserInfoBo getTokenInfoBo() {
        return TOKEN_INFO_HOLDER.get();
    }
    public static void setTokenInfoBo(AuthUserInfoBo authUserInfoBo) {
        TOKEN_INFO_HOLDER.set(authUserInfoBo);
    }
    public static void clear(){
        if(TOKEN_INFO_HOLDER.get() != null){
            TOKEN_INFO_HOLDER.remove();
        }
    }
}
