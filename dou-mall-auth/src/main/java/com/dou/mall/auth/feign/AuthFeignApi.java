package com.dou.mall.auth.feign;

import com.dou.mall.api.auth.api.AuthFeignClient;
import com.dou.mall.api.auth.bo.AuthUserInfoBo;
import com.dou.mall.api.auth.vo.TokenInfoVo;
import com.dou.mall.common.base.vo.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthFeignApi
 *
 * @author zhoug
 * @date 2025/2/19 18:16
 */

@RestController
public class AuthFeignApi implements AuthFeignClient {
    @Override
    public ResponseEntity<TokenInfoVo> ctOrGetTokenInfoVo(AuthUserInfoBo authUserInfoBo) {
        return null;
    }

    @Override
    public ResponseEntity<AuthUserInfoBo> checkToken(String authCode) {
        return null;
    }
}
