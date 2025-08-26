package com.open.mall.api.auth.domain.dto;

import lombok.Data;

/**
 * AuthSaveDto
 *
 * @author zhoug
 * @date 2025/8/25 09:40
 */


@Data
public class AuthSaveDto {

    /**
     * 用户ID（关联用户库）
     */
    private Long userId;

    /**
     * 认证类型: password/sms/email/oauth
     */
    private String authType;

    /**
     * 账号标识: 手机号/邮箱/第三方ID
     */
    private String identifier;

    /**
     * 密码哈希/三方token
     */
    private String credential;
}
