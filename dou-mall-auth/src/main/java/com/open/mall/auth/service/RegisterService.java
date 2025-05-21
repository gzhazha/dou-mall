package com.open.mall.auth.service;

import com.open.mall.api.auth.domain.bo.AuthRegisterBo;

/**
 * RegisterService
 *
 * @author zhoug
 * @date 2025/5/20 16:25
 */

public interface RegisterService {
    void register(AuthRegisterBo authRegisterBo);
}
