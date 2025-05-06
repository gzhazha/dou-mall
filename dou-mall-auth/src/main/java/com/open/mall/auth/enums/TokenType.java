package com.open.mall.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TokenType
 *
 * @author zhoug
 * @date 2025/4/29 15:56
 */

@AllArgsConstructor
@Getter
public enum TokenType {

    ACCESS_TOKEN("access", 24 * 60 * 60, "123", "HmacSHA256"),
    REFRESH_TOKEN("refresh", 30 * 24 * 60 * 60, "123", "HmacSHA256"),
    TEMPORARY_TOKEN("temporary", 5 * 60, "123", "HmacSHA256"),
    ;
    /**
     * token 类型
     */
    private final String type;
    /**
     * 过期时间，单位：秒
     */
    private final long expireTime;
    /**
     * Token签名密钥
     */
    private final String secretKey;

    /**
     * 签名算法
     */
    private final String algorithm;
}
