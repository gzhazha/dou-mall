package com.dou.mall.api.auth.vo;

import lombok.Data;


/**
 * AuthInfoVo
 *
 * @author zhoug
 * @date 2025/2/18 15:46
 */

@Data
public class TokenInfoVo {
    /** 平台唯一id */
    private Long uid;
    /** 用户中心id */
    private Long userId;
    /** 授权码 */
    private String authToken;
    /** 刷新码 */
    private String refreshToken;
    /** 授权码过期时间 */
    private Long authExpireAt;
    /** 刷新码过期时间 */
    private Long refreshExpireAt;
}
