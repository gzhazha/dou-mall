package com.open.mall.common.base.config;

import com.open.mall.common.base.api.filter.LogFilter;
import com.open.mall.common.base.api.handler.GlobalExceptionHandler;
import jakarta.servlet.DispatcherType;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
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

    @Bean
    public LogFilter logFilter(){
        return new LogFilter();
    }

    @Bean
    @Lazy
    public FilterRegistrationBean<LogFilter> logFilterFilterRegistrationBean(LogFilter logFilter) {
        FilterRegistrationBean<LogFilter> registration = new FilterRegistrationBean<>();
        // 添加过滤器
        registration.setFilter(logFilter);
        // 设置过滤路径，/*所有路径
        registration.addUrlPatterns("/*");
        registration.setName("logFilter");
        // 设置优先级
        registration.setOrder(0);
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        return registration;
    }
}
