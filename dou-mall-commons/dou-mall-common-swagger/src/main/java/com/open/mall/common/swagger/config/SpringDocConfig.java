package com.open.mall.common.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

/**
 * SpringDoc配置类 - 适配Spring Boot 3.3.0
 * 
 * @author zhoug
 */
@AutoConfiguration
public class SpringDocConfig {

    @Bean
    @ConditionalOnMissingBean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact()
                .name("dou")                             // 作者名称
                .email("")                            // 作者邮箱
                .url("")     // 介绍作者的URL地址
                .extensions(Collections.emptyMap());

        Info info = new Info()
                .title("接口文档")                               // Api接口文档标题（必填）
                .description("接口文档")                         // Api接口文档描述
                .version("1.0.0")
                .contact(contact);                              // 设置联系人信息
        return new OpenAPI()
                .info(info);                                    // 配置Swagger3.0描述信息
    }

}