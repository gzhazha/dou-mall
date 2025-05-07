package com.open.mall.leaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * LeafApplication
 *
 * @author zhoug
 * @date 2025/5/7 11:24
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LeafApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeafApplication.class, args);
    }
}
