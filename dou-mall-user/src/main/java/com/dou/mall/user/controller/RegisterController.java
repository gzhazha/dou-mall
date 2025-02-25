package com.dou.mall.user.controller;

import com.dou.mall.api.auth.vo.TokenInfoVo;
import com.dou.mall.common.base.vo.ResponseEntity;
import com.dou.mall.user.dto.RegisterDto;
import com.dou.mall.user.service.RegisterService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RegisterController
 *
 * @author zhoug
 * @date 2025/2/18 17:22
 */

@RequestMapping("/user/register")
@RestController
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @PostMapping
    public ResponseEntity<TokenInfoVo> register(@RequestBody RegisterDto registerDto){
        return ResponseEntity.success(registerService.register(registerDto));
    }
}
