package com.open.mall.auth.controller;

import com.open.mall.auth.domain.dto.CheckCaptchaDto;
import com.open.mall.auth.domain.dto.SendCaptchaDto;
import com.open.mall.auth.domain.vo.CaptchaStatusVo;
import com.open.mall.auth.service.CaptchaService;
import com.open.mall.common.base.domain.vo.BaseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * CaptchaController
 *
 * @author zhoug
 * @date 2025/4/17 09:47
 */

@Tag(name = "验证码接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    private final CaptchaService captchaService;

    @Operation(description = "验证码发送接口")
    @PostMapping("/send")
    public BaseResult<Void> sendCaptcha(@RequestBody @Validated SendCaptchaDto sendCaptchaDto) {
        captchaService.sendCaptcha(sendCaptchaDto);
        return BaseResult.success();
    }
    
    @Operation(description = "验证码验证接口")
    @PostMapping("/check")
    public BaseResult<Void> checkCaptcha(@RequestBody @Validated CheckCaptchaDto checkCaptchaDto) {
        captchaService.checkCaptcha(checkCaptchaDto);
        return BaseResult.success();
    }
    
    @Operation(description = "验证码状态查询接口")
    @GetMapping("/status/{identifier}")
    public BaseResult<CaptchaStatusVo> getCaptchaStatus(@PathVariable("identifier") String identifier) {
        return BaseResult.success(captchaService.getCaptchaStatus(identifier));
    }
}
