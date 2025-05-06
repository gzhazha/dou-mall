package com.open.mall.common.cache.constant;

/**
 * AuthCacheName
 *
 * @author zhoug
 * @date 2025/4/17 22:50
 */


public class AuthCacheName {
    public static final String CACHE_PREFIX = BaseCacheName.MALL_CACHE_PREFIX + "auth:";
    //-----------验证码
    public static final String CAPTCHA_PREFIX = CACHE_PREFIX + "captcha:";
    public static final String CAPTCHA_CODE_PREFIX = CAPTCHA_PREFIX + "code:";
    public static final String CAPTCHA_RATE_LIMIT_PREFIX = CAPTCHA_PREFIX + "limit:";

    //-----------token
    public static final String TOKEN_PREFIX = CACHE_PREFIX + "token:";
    public static final String ACCESS_TOKEN_PREFIX = TOKEN_PREFIX + "access:";
    public static final String REFRESH_TOKEN_PREFIX = TOKEN_PREFIX + "refresh:";

}
