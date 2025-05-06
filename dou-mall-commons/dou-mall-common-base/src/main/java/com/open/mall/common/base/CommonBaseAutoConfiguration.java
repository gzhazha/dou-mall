package com.open.mall.common.base;

import com.open.mall.common.base.api.handler.MallHttpHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * CommonBaseAutoConfig
 *
 * @author zhoug
 * @date 2025/4/17 10:25
 */


@AutoConfiguration
public class CommonBaseAutoConfiguration {
    @Bean
    public MallHttpHandler mallHttpHandler() {
        return new MallHttpHandler();
    }

}
