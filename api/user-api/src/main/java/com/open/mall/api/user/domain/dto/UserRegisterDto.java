package com.open.mall.api.user.domain.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * UserRegisterDto
 *
 * @author zhoug
 * @date 2025/8/25 10:04
 */


@Data
public class UserRegisterDto {

    /**
     * 认证类型: password/sms/email/oauth
     */
    private String authType;

    /**
     * 账号标识: 手机号/邮箱/第三方ID
     */
    @NotBlank(message = "账号标识不能为空")
    private String identifier;
}
