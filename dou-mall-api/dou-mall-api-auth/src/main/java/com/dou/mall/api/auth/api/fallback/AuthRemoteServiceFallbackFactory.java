package com.dou.mall.api.auth.api.fallback;

import com.dou.mall.api.auth.api.AuthFeignClient;
import com.dou.mall.api.auth.bo.AuthUserInfoBo;
import com.dou.mall.api.auth.vo.TokenInfoVo;
import com.dou.mall.common.base.vo.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * AuthRemoteServiceFallbackFactory
 *
 * @author zhoug
 * @date 2025/2/18 15:49
 */

@Slf4j
@Component
public class AuthRemoteServiceFallbackFactory implements FallbackFactory<AuthFeignClient> {
    @Override
    public AuthFeignClient create(Throwable cause) {
        log.error("", cause);
        return new AuthFeignClient() {
            @Override
            public ResponseEntity<TokenInfoVo> ctOrGetTokenInfoVo(AuthUserInfoBo authUserInfoBo) {
                return ResponseEntity.fail();
            }

            @Override
            public ResponseEntity<AuthUserInfoBo> checkToken(String authCode) {
                return ResponseEntity.fail();
            }
        };
    }
}
