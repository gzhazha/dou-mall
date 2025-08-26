package com.open.mall.auth.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * LoginDto
 *
 * @author zhoug
 * @date 2025/8/26 10:04
 */


@Data
public class LoginDto {
    /**
     * 认证类型: password/sms/email/oauth
     */
    private String authType;

    /**
     * 账号标识: 手机号/邮箱/第三方ID
     */
    @NotBlank(message = "账号标识不能为空")
    private String identifier;

    /**
     * 密码哈希/三方token
     */
    @NotBlank(message = "验证码不能为空")
    private String credential;
}
