package com.open.mall.common.feign.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * CommonFeignConfig
 *
 * @author zhoug
 * @date 2025/8/25 15:27
 */

@EnableFeignClients({"com.open.mall.api.**.feign"})
@AutoConfiguration
public class CommonFeignConfig {

}
