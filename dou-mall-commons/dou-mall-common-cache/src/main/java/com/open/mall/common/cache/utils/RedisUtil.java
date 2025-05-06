package com.open.mall.common.cache.utils;

import com.open.mall.common.base.utils.SpringContextUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * RedisUtil
 *
 * @author zhoug
 * @date 2025/4/17 18:59
 */


public class RedisUtil {
    private RedisUtil() {
        throw new IllegalStateException("Utility class");
    }

    private static <T> RedisTemplate<String, T> getRedisTemplate() {
        return SpringContextUtil.getBean("redisTemplate", RedisTemplate.class);
    }
    public static <T> T get(String key) {
        RedisTemplate<String, T> redisTemplate = getRedisTemplate();
        return redisTemplate.opsForValue().get(key);
    }

    public static <T> boolean set(String key, T value, long expire, TimeUnit timeUnit) {
        getRedisTemplate().opsForValue().set(key, value, expire, timeUnit);
        return true;
    }
    public static <T> boolean set(String key, T value, long expire) {
        getRedisTemplate().opsForValue().set(key, value, expire, TimeUnit.SECONDS);
        return true;
    }

    public static boolean delete(String key) {
        RedisTemplate<String,Object> redisTemplate = getRedisTemplate();
        return redisTemplate.delete(key);
    }

    public static boolean hasKey(String key) {
        RedisTemplate<String, Object> redisTemplate = getRedisTemplate();
        return redisTemplate.hasKey(key);
    }

    public static Long incrementOrSetOne(String key) {
        RedisTemplate<String, Long> redisTemplate = getRedisTemplate();
        return redisTemplate.opsForValue().increment(key);
    }

    public static boolean expire(String key, long time, TimeUnit timeUnit) {
        RedisTemplate<String, Object> redisTemplate = getRedisTemplate();
        return redisTemplate.expire(key, time, timeUnit);
    }

    public static Long getExpire(String key, TimeUnit timeUnit) {
        RedisTemplate<String, Object> redisTemplate = getRedisTemplate();
        return redisTemplate.getExpire(key, timeUnit);
    }

    public static Long getExpire(String key) {
        RedisTemplate<String, Object> redisTemplate = getRedisTemplate();
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

}
