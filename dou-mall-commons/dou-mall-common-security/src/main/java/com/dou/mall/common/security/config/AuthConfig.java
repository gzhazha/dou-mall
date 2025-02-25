package com.dou.mall.common.security.config;

import com.dou.mall.common.security.adapter.AuthUrlAdapter;
import com.dou.mall.common.security.adapter.DefaultAuthUrlAdapterImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AuthConfig
 *
 * @author zhoug
 * @date 2025/2/17 16:07
 */


@Configuration
public class AuthConfig {

    @Bean
    @ConditionalOnMissingBean
    public AuthUrlAdapter authUrlAdapter() {
        return new DefaultAuthUrlAdapterImpl();
    }
}
