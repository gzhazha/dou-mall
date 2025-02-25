package com.dou.mall.auth.service;

import com.dou.mall.auth.model.dto.LoginDto;
import com.dou.mall.auth.model.vo.LoginInfoVo;

/**
 * LoginService
 *
 * @author zhoug
 * @date 2025/2/19 18:39
 */

public interface LoginService {
    /**
     * 登录
     * @param loginDto 登录参数 {@link LoginDto}
     * @return token信息 {@link LoginInfoVo}
     */
    LoginInfoVo login(LoginDto loginDto);
}
