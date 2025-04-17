package com.open.mall.api.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * TokenInfo
 *
 * @author zhoug
 * @date 2025/4/16 18:36
 */

@Schema(description = "登录令牌信息")
@Data
public class TokenInfo {
    @Schema(description = "用户平台id")
    private String uid;
    @Schema(description = "登录令牌")
    private String accessToken;
    @Schema(description = "刷新令牌")
    private String refreshToken;
    @Schema(description = "刷新令牌过期时间")
    private Long refreshExpiresIn;
    @Schema(description = "登录令牌过期时间")
    private Long accessExpiresIn;
}
