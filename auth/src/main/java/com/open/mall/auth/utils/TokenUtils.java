package com.open.mall.auth.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomUtils;


/**
 * TokenUtils
 *
 * @author zhoug
 * @date 2025/8/26 11:29
 */


@UtilityClass
public class TokenUtils {


    public static String buildRefreshTokenCode(Long userId) {
        String code = userId + System.currentTimeMillis() + RandomUtils.insecure().randomInt(0, 100)+"";
        return DigestUtils.md5Hex(code).toUpperCase();
    }

    public static String buildAuthTokenCode(String refreshCode) {
        String code = refreshCode + System.currentTimeMillis() + RandomUtils.insecure().randomInt(0, 100);
        return DigestUtils.md5Hex(code).toUpperCase();
    }

}
