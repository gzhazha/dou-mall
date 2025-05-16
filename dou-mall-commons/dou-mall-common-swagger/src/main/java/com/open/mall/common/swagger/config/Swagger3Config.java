package com.open.mall.common.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@AutoConfiguration
public class Swagger3Config {

    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact()
                .name("dou")                             // 作者名称
                .email("")                            // 作者邮箱
                .url("")     // 介绍作者的URL地址
                .extensions(Collections.emptyMap());

        Info info = new Info()
                .title("接口文档")                               // Api接口文档标题（必填）
                .description("接口文档")                         // Api接口文档描述
                .version("1.0.0")                               // Api接口版本
                .contact(contact);                              // 设置联系人信息
        return new OpenAPI()
                .openapi("3.0.1")                               // Open API 3.0.1(默认)
                .info(info);                                    // 配置Swagger3.0描述信息
    }
}
