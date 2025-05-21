package com.open.mall.common.feign.config;

import com.open.mall.common.feign.core.FeignAuthInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * FeignAutoConfig
 *
 * @author zhoug
 * @date 2025/4/30 09:44
 */

@EnableFeignClients(basePackages = {"com.open.mall.**.feign"})
@AutoConfiguration
public class FeignAutoConfiguration {

    @Bean
    public FeignAuthInterceptor feignAuthInterceptor() {
        return new FeignAuthInterceptor();
    }
}
