package com.open.mall.common.swagger.annotation;

import com.open.mall.common.swagger.config.SwaggerConfigProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.*;

/**
 * EnableSwagger
 *
 * @author zhoug
 * @date 2025/4/16 16:55
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({})
@EnableConfigurationProperties({SwaggerConfigProperties.class})
@PropertySource("classpath:swagger-config.properties")
public @interface EnableSwagger {
    String value();
}
