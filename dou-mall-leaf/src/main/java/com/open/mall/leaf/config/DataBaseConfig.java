package com.open.mall.leaf.config;

import com.alibaba.druid.spring.boot3.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * DataBaseConfig
 *
 * @author zhoug
 * @date 2025/5/7 14:29
 */


@Configuration
public class DataBaseConfig {

    @ConfigurationProperties("spring.datasource.druid")
    @Bean
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
