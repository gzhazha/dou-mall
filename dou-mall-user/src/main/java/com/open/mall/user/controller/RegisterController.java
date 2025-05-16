package com.open.mall.user.controller;

import com.open.mall.common.base.domain.vo.BaseResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RegisterApi
 *
 * @author zhoug
 * @date 2025/5/9 18:42
 */

@Tag(name = "注册接口")
@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class RegisterController {

    private final UserRegisterService userRegisterService;

    @PostMapping("/client")
    public BaseResult<UserRegisterVo> register(@RequestBody UserRegisterDto userRegisterDto){
        return BaseResult.success(userRegisterDto);
    }
}
