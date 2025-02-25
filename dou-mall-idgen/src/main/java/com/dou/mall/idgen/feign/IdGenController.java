package com.dou.mall.idgen.feign;

import com.dou.mall.api.idgen.api.IdGenFeignClient;
import com.dou.mall.common.base.vo.ResponseEntity;
import com.dou.mall.idgen.service.IdGenService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * IdGenController
 *
 * @author zhoug
 * @date 2025/2/18 16:18
 */


@RestController
public class IdGenController implements IdGenFeignClient {
    @Resource
    private IdGenService idGenService;

    @Override
    public ResponseEntity<Long> getId(String key) {
        return ResponseEntity.success(idGenService.buildId(key));
    }
}
