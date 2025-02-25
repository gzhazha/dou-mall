package com.dou.mall.api.idgen.api.fallback;

import com.dou.mall.api.idgen.api.IdGenFeignClient;
import com.dou.mall.common.base.vo.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * IdGenRemoteServiceFallbackFactory
 *
 * @author zhoug
 * @date 2025/2/18 16:10
 */
@Slf4j
@Component
public class IdGenRemoteServiceFallbackFactory implements FallbackFactory<IdGenFeignClient> {
    @Override
    public IdGenFeignClient create(Throwable cause) {
        log.error("",cause);
        return key -> ResponseEntity.fail();
    }
}
