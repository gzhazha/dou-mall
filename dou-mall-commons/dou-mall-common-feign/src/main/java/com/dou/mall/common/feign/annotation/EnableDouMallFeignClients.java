package com.dou.mall.common.feign.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * EnableDouMallFeignClients
 *
 * @author zhoug
 * @date 2025/2/17 22:46
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableDouMallFeignClients {

    String[] value() default {};

    @AliasFor(annotation = EnableFeignClients.class,attribute = "basePackages")
    String[] basePackages() default {"com.dou.mall.api.*.api"};
}
