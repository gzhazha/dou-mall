package com.open.mall.common.security.adapter;

import com.google.common.collect.Sets;
import com.open.mall.common.base.constants.UrlWhiteList;

import java.util.Set;

/**
 * AuthPathAdapter
 *
 * @author zhoug
 * @date 2025/4/29 16:47
 */

public interface AuthPathAdapter {
    Set<String> WHITELIST = Sets.newHashSet(UrlWhiteList.LOGIN_CAPTCHA, UrlWhiteList.LOGIN_PASSWORD,UrlWhiteList.CHECK_TOKEN);
    /**
     * 需要授权登陆的路径
     *
     * @return 需要授权登陆的路径列表
     */
    Set<String> requiresAuthorizationPaths();

    /**
     * 不需要授权登陆的路径
     *
     * @return 不需要授权登陆的路径列表
     */
    Set<String> noAuthorizationPaths();

    default boolean mathExcludePath(String reqUrl){
        return WHITELIST.contains(reqUrl)||noAuthorizationPaths().contains(reqUrl);
    };
}
