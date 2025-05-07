package com.open.mall.api.leaf.feign;

import com.open.mall.common.base.domain.vo.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * A
 *
 * @author zhoug
 * @date 2025/5/7 11:36
 */

@FeignClient(name = "dou-mall-leaf", contextId = "segmentFeignClient")
public interface SegmentFeignClient {
    @GetMapping("/leaf/id/next")
    BaseResult<Long> getSegmentId(String key);
}
