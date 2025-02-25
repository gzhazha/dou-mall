package com.dou.mall.api.idgen.api;

import com.dou.mall.api.idgen.api.fallback.IdGenRemoteServiceFallbackFactory;
import com.dou.mall.common.base.vo.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * IdGenRemoteService
 *
 * @author zhoug
 * @date 2025/2/18 15:58
 */
@FeignClient(name = "dou-mall-idgen", fallbackFactory = IdGenRemoteServiceFallbackFactory.class)
public interface IdGenFeignClient {
    @GetMapping("/idgen")
    ResponseEntity<Long> getId(@RequestParam String key);
}
