package com.open.mall.auth.web.api;

import com.open.mall.auth.domain.dto.LoginDto;
import com.open.mall.auth.domain.vo.TokenInfoVo;
import com.open.mall.auth.service.LoginService;
import com.open.mall.common.base.doman.vo.BaseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginApi
 *
 * @author zhoug
 * @date 2025/8/26 10:01
 */


@RestController
@RequiredArgsConstructor
@Validated
public class LoginApi {

    private final LoginService loginService;

    @PostMapping("/login")
    public BaseResult<TokenInfoVo> login(LoginDto loginDto){
        return BaseResult.success(loginService.login(loginDto));
    }
}
