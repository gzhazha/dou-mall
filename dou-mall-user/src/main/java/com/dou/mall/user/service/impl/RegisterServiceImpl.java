package com.dou.mall.user.service.impl;

import com.dou.mall.api.auth.vo.TokenInfoVo;
import com.dou.mall.user.dto.RegisterDto;
import com.dou.mall.user.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * RegisterServiceImpl
 *
 * @author zhoug
 * @date 2025/2/18 17:27
 */

@Slf4j
@Service
public class RegisterServiceImpl implements RegisterService {
    @Override
    public TokenInfoVo register(RegisterDto registerDto) {
        return null;
    }
}
