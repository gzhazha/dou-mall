package com.open.mall.common.base.config;

import com.open.mall.common.base.api.handler.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 *
 * @author zhoug
 * @date 2025/4/17 10:40
 */


@AutoConfiguration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Bean
    public GlobalExceptionHandler globalExceptionHandler(){
        return new GlobalExceptionHandler();
    }
}
