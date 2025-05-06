package com.open.mall.common.feign.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * FeignAutoConfig
 *
 * @author zhoug
 * @date 2025/4/30 09:44
 */

@EnableFeignClients(basePackages = {"com.open.mall.**.feign"})
@AutoConfiguration
public class FeignAutoConfiguration {
}
