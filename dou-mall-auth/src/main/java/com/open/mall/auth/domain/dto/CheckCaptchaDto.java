package com.open.mall.auth.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * GetCaptchaDto
 *
 * @author zhoug
 * @date 2025/4/21 15:39
 */

@Schema(description = "验证码校验dto")
@Data
public class CheckCaptchaDto {
    @NotBlank
    @Schema(description = "手机号/邮箱")
    private String identifier;
    @NotBlank
    @Schema(description = "验证码")
    private String captcha;
}
