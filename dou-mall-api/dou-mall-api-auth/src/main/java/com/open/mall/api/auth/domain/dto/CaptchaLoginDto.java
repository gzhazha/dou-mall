package com.open.mall.api.auth.domain.dto;

import com.open.mall.api.auth.enums.CaptchaChannel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * LoginDto
 *
 * @author zhoug
 * @date 2025/4/16 18:58
 */


@Schema(description = "验证码登录请求信息")
@Data
public class CaptchaLoginDto {
    @NotBlank
    @Schema(description = "账号")
    private String identifier;
    @NotBlank
    @Schema(description = "验证码")
    private String captcha;
    @NotBlank
    @Schema(description = "渠道")
    private CaptchaChannel channel;

}
