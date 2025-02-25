package com.dou.mall.user.service;

import com.dou.mall.api.auth.vo.TokenInfoVo;
import com.dou.mall.user.dto.RegisterDto;

/**
 * RegisterService
 *
 * @author zhoug
 * @date 2025/2/18 17:25
 */


public interface RegisterService {
    /**
     * 用户注册
     * @param registerDto {@link RegisterDto} 注册参数
     * @return token信息 {@link TokenInfoVo}
     */
    TokenInfoVo register(RegisterDto registerDto);
}
