package com.open.mall.auth.controller;

import com.open.mall.common.base.domain.vo.BaseResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * CaptchaController
 *
 * @author zhoug
 * @date 2025/4/17 09:47
 */

@Slf4j
@Tag(name = "验证码接口")
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @GetMapping("/phone")
    public BaseResult<Void> getCaptchaByPhone(String phone) {
        log.info("测试");
        return BaseResult.success();
    }
}
