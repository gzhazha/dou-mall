package com.dou.mall.idgen.config;

import com.dou.mall.idgen.utils.SnowflakeKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * IdGenConfig
 *
 * @author zhoug
 * @date 2025/2/18 16:25
 */


@Configuration
public class IdGenConfig {

    @Bean
    public SnowflakeKeyGenerator snowflakeKeyGenerator(){
        return new SnowflakeKeyGenerator();
    }
}
