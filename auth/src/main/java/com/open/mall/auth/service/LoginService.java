package com.open.mall.auth.service;

import com.open.mall.auth.domain.dto.LoginDto;
import com.open.mall.auth.domain.vo.TokenInfoVo;

/**
 * LoginService
 *
 * @author zhoug
 * @date 2025/8/26 10:04
 */

public interface LoginService {
    /**
     * 登陆
     * @param loginDto {@link LoginDto}
     * @return {@link TokenInfoVo}
     */
    TokenInfoVo login(LoginDto loginDto);
}
