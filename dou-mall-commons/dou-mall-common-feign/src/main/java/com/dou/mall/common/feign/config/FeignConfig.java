package com.dou.mall.common.feign.config;

import feign.Feign;
import feign.Logger;
import feign.okhttp.OkHttpClient;
import okhttp3.ConnectionPool;
import okhttp3.Protocol;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;


/**
 * FeignConfig
 *
 * @author zhoug
 * @date 2025/2/17 22:14
 */

@Configuration
public class FeignConfig {

    @Bean
    public Feign.Builder httpClient() {
        ConnectionPool connectionPool = new ConnectionPool(50, 5, TimeUnit.MINUTES);
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient()
                .newBuilder()
                .protocols(Collections.singletonList(Protocol.HTTP_2))
                .connectionPool(connectionPool)
                .connectTimeout(Duration.ofMinutes(5))
                .build();
        return Feign.builder()
                .client(new OkHttpClient(client))
                .logLevel(Logger.Level.FULL);
    }
}
