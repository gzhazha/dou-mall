package com.open.mall.user.controller;

import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.user.domain.dto.ClientRegisterDto;
import com.open.mall.user.service.RegisterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    private final RegisterService registerService;

    @GetMapping("/client")
    public BaseResult<Long> registerClient(ClientRegisterDto clientRegisterDto) {
        return BaseResult.success(registerService.registerClient(clientRegisterDto));
    }
}
