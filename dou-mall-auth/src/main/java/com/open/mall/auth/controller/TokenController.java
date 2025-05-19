package com.open.mall.auth.controller;

import com.open.mall.api.auth.domain.dto.CaptchaLoginDto;
import com.open.mall.api.auth.domain.dto.PasswordLoginDto;
import com.open.mall.api.auth.domain.vo.TokenInfoVo;
import com.open.mall.auth.service.TokenService;
import com.open.mall.common.base.domain.vo.BaseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * TokenController
 *
 * @author zhoug
 * @date 2025/4/17 09:38
 */

@Tag(name = "token接口")
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/token")
public class TokenController {

    private final TokenService tokenService;

    @Operation(summary = "获取token接口", method = "POST")
    @PostMapping("/login/captcha")
    public BaseResult<TokenInfoVo> getOrCreateTokenByCaptcha(@RequestBody CaptchaLoginDto captchaLoginDto) {
        return BaseResult.success(tokenService.buildTokenInfo(captchaLoginDto));
    }

    @Operation(summary = "获取token接口", method = "POST")
    @PostMapping("/login/password")
    public BaseResult<TokenInfoVo> getOrCreateTokenByPassword(@RequestBody PasswordLoginDto passwordLoginDto) {
        return BaseResult.success(tokenService.buildTokenInfo(passwordLoginDto));
    }

}
