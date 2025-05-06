package com.open.mall.auth.domain.bo;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * TokenUserInfoBo
 *
 * @author zhoug
 * @date 2025/4/29 10:41
 */

@Schema(description = "token缓存的用户信息")
public class TokenUserInfoBo {
    /**
     * 全局唯一用户ID (UUID格式), 由本服务生成
     */
    @Schema(description = "全局唯一用户ID")
    private String userId;
}
