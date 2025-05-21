package com.open.mall.user.service;

import com.open.mall.user.domain.dto.ClientRegisterDto;

/**
 * RegisterService
 *
 * @author zhoug
 * @date 2025/5/20 15:45
 */

public interface RegisterService {
    /**
     * 注册普通用户
     * @param clientRegisterDto
     * @return
     */
    Long registerClient(ClientRegisterDto clientRegisterDto);
}
