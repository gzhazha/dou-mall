package com.open.mall.auth.service.impl;

import com.open.mall.api.auth.domain.bo.AuthRegisterBo;
import com.open.mall.auth.dao.manager.AuthUserManager;
import com.open.mall.auth.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * RegisterServiceImpl
 *
 * @author zhoug
 * @date 2025/5/20 16:26
 */

@AllArgsConstructor
@Service
public class RegisterServiceImpl implements RegisterService {
    private final AuthUserManager authUserManager;
    @Override
    public void register(AuthRegisterBo authRegisterBo) {
        authUserManager.register(authRegisterBo.getUserId(),authRegisterBo.getPassword());
    }
}
