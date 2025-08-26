package com.open.mall.auth.domain.vo;

import lombok.Data;

/**
 * TokenInfoVo
 *
 * @author zhoug
 * @date 2025/8/26 10:04
 */


@Data
public class TokenInfoVo {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Long userId;
    private Long expiresIn;
    private Long refreshExpiresIn;
}
