package com.dou.mall.auth.controller;

import com.dou.mall.auth.model.dto.LoginDto;
import com.dou.mall.auth.service.LoginService;
import com.dou.mall.auth.model.vo.LoginInfoVo;
import com.dou.mall.common.base.vo.ResponseEntity;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginController
 *
 * @author zhoug
 * @date 2025/2/19 18:33
 */


@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping
    public ResponseEntity<LoginInfoVo> login(LoginDto loginDto){
        return ResponseEntity.success(loginService.login(loginDto));
    }
}
