package com.open.mall.common.feign.core;

import com.open.mall.common.feign.constants.FeignConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.core.Ordered;

/**
 * FeignAuthIn
 *
 * @author zhoug
 * @date 2025/5/8 18:37
 */


public class FeignAuthInterceptor implements RequestInterceptor, Ordered {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(FeignConstant.FEIGN_FROM, FeignConstant.FEIGN_IN);
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
