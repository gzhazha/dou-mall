package com.open.mall.auth.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PasswordController
 *
 * @author zhoug
 * @date 2025/5/6 19:01
 */


@Tag(name = "token接口")
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/password")
public class PasswordController {
}
