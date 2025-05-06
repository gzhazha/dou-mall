package com.open.mall.auth.domain.dto;

import com.open.mall.api.auth.enums.CaptchaChannel;
import com.open.mall.api.auth.enums.CaptchaType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * GetCaptchaDto
 *
 * @author zhoug
 * @date 2025/4/21 15:39
 */


@Data
public class SendCaptchaDto {
    @NotBlank
    private String identifier;
    @NotNull
    private CaptchaChannel channel;
    @NotNull
    private CaptchaType type;
}
