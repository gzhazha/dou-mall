package com.open.mall.api.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * LoginDto
 *
 * @author zhoug
 * @date 2025/4/16 18:58
 */


@Schema(description = "登录请求信息")
@Data
public class LoginDto {
    @Schema(description = "手机号")
    private String phone;
    @Schema(description = "验证码")
    private String captcha;
}
