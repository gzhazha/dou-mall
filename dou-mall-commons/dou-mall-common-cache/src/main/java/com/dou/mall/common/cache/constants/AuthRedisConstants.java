package com.dou.mall.common.cache.constants;

import static com.dou.mall.common.cache.constants.CommonRedisConstants.AUTH_PREFIX;

/**
 * AuthRedisConstants
 *
 * @author zhoug
 * @date 2025/2/24 09:40
 */

public interface AuthRedisConstants {

    /** token相关 */
    String AUTH_TOKEN_PREFIX = AUTH_PREFIX + "token:";
    String AUTH_TOKEN_CODE_PREFIX = AUTH_TOKEN_PREFIX + "code:";
    String AUTH_TOKEN_REFRESH_CODE_PREFIX = AUTH_TOKEN_PREFIX + "refresh_code:";
    String AUTH_TOKEN_UID_CODE_PREFIX = AUTH_TOKEN_PREFIX + "uid_code:";

    /** 验证码相关 */
    String AUTH_VERIFY_CODE = AUTH_PREFIX + "verify:";
    String AUTH_VERIFY_PHONE_CODE = AUTH_VERIFY_CODE + "phone:";
}
