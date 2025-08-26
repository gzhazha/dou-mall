package com.open.mall.auth.config;

import com.alibaba.druid.spring.boot3.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * DatabaseConfig
 *
 * @author zhoug
 * @date 2025/8/22 16:02
 */

@Configuration
public class DbConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
