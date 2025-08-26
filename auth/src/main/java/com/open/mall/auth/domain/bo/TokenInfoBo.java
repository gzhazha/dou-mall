package com.open.mall.auth.domain.bo;

import lombok.Data;

/**
 * TokenInfoBo
 *
 * @author zhoug
 * @date 2025/8/26 15:11
 */

@Data
public class TokenInfoBo {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Long userId;
    private Long expiresIn;
    private Long refreshExpiresIn;
}
