package com.dou.mall.common.cache.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * RedisUtil
 *
 * @author zhoug
 * @date 2025/2/20 16:32
 */

@Component
public class RedisUtil {

    private static RedisTemplate<String, Object> REDIS_TEMPLATE;
    private static StringRedisTemplate STRING_REDIS_TEMPLATE;

    public RedisUtil(RedisTemplate<String, Object> redisTemplate, StringRedisTemplate stringRedisTemplate) {
        REDIS_TEMPLATE = redisTemplate;
        STRING_REDIS_TEMPLATE = stringRedisTemplate;
    }

    public static void set(String key, String value) {
        STRING_REDIS_TEMPLATE.opsForValue().set(key, value);
    }

    public static void set(String key, String value, long timeout) {
        if (timeout < 0) {
            STRING_REDIS_TEMPLATE.opsForValue().set(key, value);
        } else {
            STRING_REDIS_TEMPLATE.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
        }
    }

    public static void set(String key, Object value) {
        REDIS_TEMPLATE.opsForValue().set(key, value);
    }

    public static void set(String key, Object value, long timeout) {
        if (timeout < 0) {
            REDIS_TEMPLATE.opsForValue().set(key, value);
        } else {
            REDIS_TEMPLATE.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
        }
    }

    public static String getStr(String key) {
        return STRING_REDIS_TEMPLATE.opsForValue().get(key);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) REDIS_TEMPLATE.opsForValue().get(key);
    }

}
