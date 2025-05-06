package com.open.mall.api.auth.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * LoginDto
 *
 * @author zhoug
 * @date 2025/4/16 18:58
 */


@Schema(description = "账户密码登录请求信息")
@Data
public class PasswordLoginDto {
    @NotBlank
    @Schema(description = "用户名")
    private String username;
    @NotBlank
    @Schema(description = "密码")
    private String password;
}
