package com.open.mall.api.auth.domain.bo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * AuthRegisterBo
 *
 * @author zhoug
 * @date 2025/5/20 16:21
 */


@Schema(description = "AuthRegisterBo")
@Data
public class AuthRegisterBo {
    @Schema(description = "用户id")
    private Long userId;
    @Schema(description = "密码")
    private String password;
}
