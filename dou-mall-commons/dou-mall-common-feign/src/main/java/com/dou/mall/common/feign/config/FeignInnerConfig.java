package com.dou.mall.common.feign.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * FeignInnerConfig
 *
 * @author zhoug
 * @date 2025/2/19 18:24
 */


@RefreshScope
@Configuration
@ConfigurationProperties("feign.inner")
public class FeignInnerConfig {
    /** feign调用路径前缀 */
    public static final String FEIGN_PATH_PREFIX = "/feign";
}
