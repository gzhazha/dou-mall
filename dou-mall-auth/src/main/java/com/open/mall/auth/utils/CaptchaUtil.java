package com.open.mall.auth.utils;

import com.open.mall.common.base.enums.AuthError;
import com.open.mall.common.base.enums.SystemError;
import com.open.mall.common.base.utils.MallAssert;
import com.open.mall.common.cache.constant.AuthCacheName;
import com.open.mall.common.cache.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * 验证码工具类
 * 用于生成、存储和验证短信验证码
 * 支持数字验证码和字母数字混合验证码
 * 提供验证码生成、存储、验证、限流等功能
 *
 * @author zhoug
 * @date 2025/4/24 10:22
 */


public class CaptchaUtil {
    /**
     * 私有构造方法，防止实例化
     */
    private CaptchaUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 数字字符集，用于生成数字验证码
     */
    private static final String NUMERIC = "0123456789";

    /**
     * 字母字符集，用于生成字母数字混合验证码
     */
    private static final String ALPHABETIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 字母数字混合字符集
     */
    private static final String ALPHANUMERIC = NUMERIC + ALPHABETIC;

    /**
     * 随机数生成器
     */
    private static final Random RANDOM = new Random();

    /**
     * 验证码最小长度
     */
    public static final int CAPTCHA_LENGTH_MIN = 4;

    /**
     * 默认验证码过期时间（秒）
     */
    public static final int DEFAULT_EXPIRE_SECONDS = 300;

    /**
     * 默认发送频率限制时间（秒）
     */
    public static final int DEFAULT_RATE_LIMIT_SECONDS = 60;
    
    /**
     * 默认单个手机号每日最大发送次数
     */
    public static final int DEFAULT_DAILY_LIMIT = 10;
    
    /**
     * 默认单个IP每日最大发送次数
     */
    public static final int DEFAULT_IP_DAILY_LIMIT = 20;
    
    /**
     * 默认验证码最大尝试次数
     */
    public static final int DEFAULT_MAX_VERIFY_ATTEMPTS = 5;
    
    /**
     * 日期格式化器，用于生成日期相关的键
     */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * 验证码类型枚举
     */
    public enum CaptchaMode {
        /**
         * 纯数字验证码
         */
        NUMERIC,

        /**
         * 字母数字混合验证码
         */
        MIXED
    }

    /**
     * 创建数字验证码
     * 根据指定长度生成随机数字验证码，最小长度为4位
     *
     * @param length 验证码长度，如果小于4则默认使用4
     * @return {@link String} 生成的数字验证码
     */
    public static String createCaptcha(int length) {
        return createCaptcha(length, CaptchaMode.NUMERIC);
    }

    /**
     * 创建验证码
     * 根据指定长度和模式生成随机验证码
     *
     * @param length 验证码长度，如果小于4则默认使用4
     * @param mode   验证码模式，NUMERIC为纯数字，MIXED为字母数字混合
     * @return {@link String} 生成的验证码
     */
    public static String createCaptcha(int length, CaptchaMode mode) {
        length = Math.max(length, CAPTCHA_LENGTH_MIN);
        StringBuilder builder = new StringBuilder();
        String charSet = mode == CaptchaMode.NUMERIC ? NUMERIC : ALPHANUMERIC;
        int charSetLength = charSet.length();

        for (int i = 0; i < length; i++) {
            builder.append(charSet.charAt(RANDOM.nextInt(charSetLength)));
        }
        return builder.toString();
    }

    /**
     * 存储验证码到Redis缓存，使用默认过期时间（5分钟）
     *
     * @param identifier 标识符，通常是手机号
     * @param captcha    验证码
     * @return 存储是否成功
     */
    public static boolean storeCaptcha(String identifier, String captcha) {
        return storeCaptcha(identifier, captcha, DEFAULT_EXPIRE_SECONDS);
    }

    /**
     * 存储验证码到Redis缓存，并设置过期时间
     *
     * @param identifier    标识符，通常是手机号
     * @param captcha       验证码
     * @param expireSeconds 过期时间（秒）
     * @return 存储是否成功
     */
    public static boolean storeCaptcha(String identifier, String captcha, int expireSeconds) {
        if (StringUtils.isAnyBlank(identifier, captcha) || expireSeconds <= 0) {
            return false;
        }
        String key = buildCaptchaKey(identifier);
        return RedisUtil.set(key, captcha, expireSeconds, TimeUnit.SECONDS);
    }

    /**
     * 构建验证码在Redis中的键名
     *
     * @param identifier 标识符，通常是手机号
     * @return Redis中的键名
     */
    public static String buildCaptchaKey(String identifier) {
        return AuthCacheName.CAPTCHA_CODE_PREFIX + identifier;
    }

    /**
     * 生成并存储验证码
     *
     * @param identifier 标识符，通常是手机号
     * @param length     验证码长度
     * @return 生成的验证码
     */
    public static String createAndStoreCaptcha(String identifier, int length) {
        return createAndStoreCaptcha(identifier, length, CaptchaMode.NUMERIC, DEFAULT_EXPIRE_SECONDS);
    }

    /**
     * 生成并存储默认长度(4位)的验证码
     *
     * @param identifier 标识符，通常是手机号
     * @return 生成的验证码
     */
    public static String createAndStoreCaptcha(String identifier) {
        return createAndStoreCaptcha(identifier, CAPTCHA_LENGTH_MIN);
    }

    /**
     * 生成并存储验证码，可指定验证码模式
     *
     * @param identifier 标识符，通常是手机号
     * @param length     验证码长度
     * @param mode       验证码模式
     * @return 生成的验证码
     */
    public static String createAndStoreCaptcha(String identifier, int length, CaptchaMode mode) {
        return createAndStoreCaptcha(identifier, length, mode, DEFAULT_EXPIRE_SECONDS);
    }

    /**
     * 生成并存储验证码，可指定验证码模式和过期时间
     *
     * @param identifier    标识符，通常是手机号
     * @param length        验证码长度
     * @param mode          验证码模式
     * @param expireSeconds 过期时间（秒）
     * @return 生成的验证码
     */
    public static String createAndStoreCaptcha(String identifier, int length, CaptchaMode mode, int expireSeconds) {
        // 检查发送频率限制
        if (!checkSendRateLimit(identifier)) {
            return null;
        }

        String captcha = createCaptcha(length, mode);
        if (storeCaptcha(identifier, captcha, expireSeconds)) {
            // 设置发送频率限制
            setRateLimit(identifier, DEFAULT_RATE_LIMIT_SECONDS);
            return captcha;
        }
        return null;
    }
    
    /**
     * 生成并存储验证码，可指定验证码模式和过期时间，并进行IP限制
     *
     * @param identifier    标识符，通常是手机号
     * @param ip            请求IP地址
     * @param length        验证码长度
     * @param mode          验证码模式
     * @param expireSeconds 过期时间（秒）
     * @return 生成的验证码
     */
    public static String createAndStoreCaptcha(String identifier, String ip, int length, CaptchaMode mode, int expireSeconds) {
        // 检查手机号格式
        MallAssert.isTrue(isValidMobile(identifier), SystemError.ILLEGAL_PARAM, "手机号格式不正确");
        
        // 检查发送频率限制
        MallAssert.isTrue(checkSendRateLimit(identifier), AuthError.VERIFICATION_CODE_SEND_TOO_FREQUENTLY);
        
        // 检查每日发送次数限制
        MallAssert.isTrue(checkDailyLimit(identifier), AuthError.VERIFICATION_CODE_DAILY_LIMIT_EXCEEDED);
        
        // 检查IP每日发送次数限制
        if (StringUtils.isNotBlank(ip)) {
            MallAssert.isTrue(checkIpDailyLimit(ip), AuthError.VERIFICATION_CODE_IP_LIMIT_EXCEEDED);
        }

        String captcha = createCaptcha(length, mode);
        boolean stored = storeCaptcha(identifier, captcha, expireSeconds);
        MallAssert.isTrue(stored, SystemError.SYSTEM_ERROR, "验证码存储失败");
        
        // 设置发送频率限制
        setRateLimit(identifier, DEFAULT_RATE_LIMIT_SECONDS);
        
        // 增加每日发送计数
        incrementDailyCounter(identifier);
        
        // 增加IP每日发送计数
        if (StringUtils.isNotBlank(ip)) {
            incrementIpDailyCounter(ip);
        }
        
        // 重置验证尝试次数
        resetVerifyAttempts(identifier);
        
        return captcha;
    }

    /**
     * 校验验证码
     * 从Redis中获取存储的验证码并与用户提供的验证码进行比对
     * 验证成功后会自动删除验证码
     *
     * @param identifier 标识符，通常是手机号
     * @param captcha    用户提供的验证码
     */
    public static void validateCaptcha(String identifier, String captcha) {
        validateCaptcha(identifier, captcha, true);
    }

    /**
     * 校验验证码
     * 从Redis中获取存储的验证码并与用户提供的验证码进行比对
     * 可选择验证成功后是否删除验证码
     *
     * @param identifier  标识符，通常是手机号
     * @param captcha     用户提供的验证码
     * @param deleteAfter 验证成功后是否删除验证码
     */
    public static void validateCaptcha(String identifier, String captcha, boolean deleteAfter) {
        MallAssert.isFalse(StringUtils.isAnyBlank(identifier, captcha), SystemError.ILLEGAL_PARAM, "验证码或标识符格式错误");
        
        // 检查尝试次数
        checkVerifyAttempts(identifier);
        
        String key = buildCaptchaKey(identifier);
        String storedCaptcha = RedisUtil.get(key);
        MallAssert.notNull(storedCaptcha, AuthError.VERIFICATION_CODE_HAS_EXPIRED);
        
        boolean isValid = captcha.equalsIgnoreCase(storedCaptcha);
        
        if (!isValid) {
            // 增加验证尝试次数
            incrementVerifyAttempts(identifier);
            MallAssert.isTrue(false, AuthError.VERIFICATION_CODE_MISMATCH);
        }
        
        if (deleteAfter) {
            RedisUtil.delete(key);
        }
        
        // 验证成功后清除尝试次数
        resetVerifyAttempts(identifier);
    }

    /**
     * 删除验证码
     *
     * @param identifier 标识符，通常是手机号
     * @return 删除是否成功
     */
    public static boolean deleteCaptcha(String identifier) {
        if (StringUtils.isBlank(identifier)) {
            return false;
        }
        String key = buildCaptchaKey(identifier);
        return RedisUtil.delete(key);
    }

    /**
     * 检查是否存在验证码
     *
     * @param identifier 标识符，通常是手机号
     * @return 是否存在验证码
     */
    public static boolean hasCaptcha(String identifier) {
        if (StringUtils.isBlank(identifier)) {
            return false;
        }
        String key = buildCaptchaKey(identifier);
        return RedisUtil.hasKey(key);
    }

    /**
     * 构建验证码发送频率限制在Redis中的键名
     *
     * @param identifier 标识符，通常是手机号
     * @return Redis中的键名
     */
    public static String buildCaptchaLimitKey(String identifier) {
        return AuthCacheName.CAPTCHA_RATE_LIMIT_PREFIX + identifier;
    }
    
    /**
     * 构建验证码每日发送次数限制在Redis中的键名
     *
     * @param identifier 标识符，通常是手机号
     * @return Redis中的键名
     */
    public static String buildCaptchaDailyLimitKey(String identifier) {
        String today = LocalDate.now().format(DATE_FORMATTER);
        return AuthCacheName.CAPTCHA_RATE_LIMIT_PREFIX + "daily:" + identifier + ":" + today;
    }
    
    /**
     * 构建IP每日发送次数限制在Redis中的键名
     *
     * @param ip IP地址
     * @return Redis中的键名
     */
    public static String buildIpDailyLimitKey(String ip) {
        String today = LocalDate.now().format(DATE_FORMATTER);
        return AuthCacheName.CAPTCHA_RATE_LIMIT_PREFIX + "ip:" + ip + ":" + today;
    }
    
    /**
     * 构建验证码尝试次数在Redis中的键名
     *
     * @param identifier 标识符，通常是手机号
     * @return Redis中的键名
     */
    public static String buildCaptchaAttemptKey(String identifier) {
        return AuthCacheName.CAPTCHA_CODE_PREFIX + "attempt:" + identifier;
    }

    /**
     * 设置发送频率限制
     *
     * @param identifier    标识符，通常是手机号
     * @param expireSeconds 限制时间（秒）
     */
    public static void setRateLimit(String identifier, int expireSeconds) {
        if (StringUtils.isBlank(identifier) || expireSeconds <= 0) {
            return;
        }
        String key = buildCaptchaLimitKey(identifier);
        RedisUtil.set(key, "1", expireSeconds, TimeUnit.SECONDS);
    }

    /**
     * 检查发送频率限制
     * 如果在限制时间内，则不允许再次发送验证码
     *
     * @param identifier 标识符，通常是手机号
     * @return 是否允许发送验证码
     */
    public static boolean checkSendRateLimit(String identifier) {
        if (StringUtils.isBlank(identifier)) {
            return false;
        }
        String key = buildCaptchaLimitKey(identifier);
        return !RedisUtil.hasKey(key);
    }
    
    /**
     * 检查每日发送次数限制
     *
     * @param identifier 标识符，通常是手机号
     * @return 是否允许发送验证码
     */
    public static boolean checkDailyLimit(String identifier) {
        if (StringUtils.isBlank(identifier)) {
            return false;
        }
        String key = buildCaptchaDailyLimitKey(identifier);
        String countStr = RedisUtil.get(key);
        if (StringUtils.isBlank(countStr)) {
            return true;
        }
        int count = Integer.parseInt(countStr);
        return count < DEFAULT_DAILY_LIMIT;
    }
    
    /**
     * 增加每日发送计数
     *
     * @param identifier 标识符，通常是手机号
     */
    public static void incrementDailyCounter(String identifier) {
        if (StringUtils.isBlank(identifier)) {
            return;
        }
        String key = buildCaptchaDailyLimitKey(identifier);
        String countStr = RedisUtil.get(key);
        int count = 1;
        if (StringUtils.isNotBlank(countStr)) {
            count = Integer.parseInt(countStr) + 1;
        }
        // 设置过期时间为当天结束（第二天凌晨）
        long secondsUntilEndOfDay = LocalDate.now().plusDays(1).atStartOfDay()
                .toEpochSecond(java.time.ZoneOffset.of("+8")) - System.currentTimeMillis() / 1000;
        RedisUtil.set(key, String.valueOf(count), (int) secondsUntilEndOfDay, TimeUnit.SECONDS);
    }
    
    /**
     * 检查IP每日发送次数限制
     *
     * @param ip IP地址
     * @return 是否允许发送验证码
     */
    public static boolean checkIpDailyLimit(String ip) {
        if (StringUtils.isBlank(ip)) {
            return false;
        }
        String key = buildIpDailyLimitKey(ip);
        String countStr = RedisUtil.get(key);
        if (StringUtils.isBlank(countStr)) {
            return true;
        }
        int count = Integer.parseInt(countStr);
        return count < DEFAULT_IP_DAILY_LIMIT;
    }
    
    /**
     * 增加IP每日发送计数
     *
     * @param ip IP地址
     */
    public static void incrementIpDailyCounter(String ip) {
        if (StringUtils.isBlank(ip)) {
            return;
        }
        String key = buildIpDailyLimitKey(ip);
        String countStr = RedisUtil.get(key);
        int count = 1;
        if (StringUtils.isNotBlank(countStr)) {
            count = Integer.parseInt(countStr) + 1;
        }
        // 设置过期时间为当天结束（第二天凌晨）
        long secondsUntilEndOfDay = LocalDate.now().plusDays(1).atStartOfDay()
                .toEpochSecond(java.time.ZoneOffset.of("+8")) - System.currentTimeMillis() / 1000;
        RedisUtil.set(key, String.valueOf(count), (int) secondsUntilEndOfDay, TimeUnit.SECONDS);
    }
    
    /**
     * 检查验证尝试次数
     * 如果尝试次数超过限制，则抛出异常
     *
     * @param identifier 标识符，通常是手机号
     */
    public static void checkVerifyAttempts(String identifier) {
        if (StringUtils.isBlank(identifier)) {
            return;
        }
        String key = buildCaptchaAttemptKey(identifier);
        String attemptsStr = RedisUtil.get(key);
        if (StringUtils.isNotBlank(attemptsStr)) {
            int attempts = Integer.parseInt(attemptsStr);
            MallAssert.isTrue(attempts < DEFAULT_MAX_VERIFY_ATTEMPTS, 
                    AuthError.VERIFICATION_CODE_MAX_ATTEMPTS_EXCEEDED);
        }
    }
    
    /**
     * 增加验证尝试次数
     *
     * @param identifier 标识符，通常是手机号
     */
    public static void incrementVerifyAttempts(String identifier) {
        if (StringUtils.isBlank(identifier)) {
            return;
        }
        String key = buildCaptchaAttemptKey(identifier);
        String attemptsStr = RedisUtil.get(key);
        int attempts = 1;
        if (StringUtils.isNotBlank(attemptsStr)) {
            attempts = Integer.parseInt(attemptsStr) + 1;
        }
        // 设置过期时间与验证码相同
        String captchaKey = buildCaptchaKey(identifier);
        long expireTime = RedisUtil.getExpire(captchaKey);
        if (expireTime > 0) {
            RedisUtil.set(key, String.valueOf(attempts), (int) expireTime, TimeUnit.SECONDS);
        } else {
            RedisUtil.set(key, String.valueOf(attempts), DEFAULT_EXPIRE_SECONDS, TimeUnit.SECONDS);
        }
    }
    
    /**
     * 重置验证尝试次数
     *
     * @param identifier 标识符，通常是手机号
     */
    public static void resetVerifyAttempts(String identifier) {
        if (StringUtils.isBlank(identifier)) {
            return;
        }
        String key = buildCaptchaAttemptKey(identifier);
        RedisUtil.delete(key);
    }

    /**
     * 验证发送频率限制
     * 如果在限制时间内，则不允许再次发送验证码
     *
     * @param identifier 标识符，通常是手机号
     * @return 是否允许发送验证码
     * @deprecated 使用 {@link #checkSendRateLimit(String)} 替代
     */
    @Deprecated
    public static boolean validateSendLimit(String identifier) {
        return checkSendRateLimit(identifier);
    }

    /**
     * 获取验证码剩余有效时间（秒）
     *
     * @param identifier 标识符，通常是手机号
     * @return 剩余有效时间（秒），如果验证码不存在则返回-1
     */
    public static long getCaptchaExpireTime(String identifier) {
        if (StringUtils.isBlank(identifier)) {
            return -1;
        }
        String key = buildCaptchaKey(identifier);
        return RedisUtil.getExpire(key);
    }

    /**
     * 获取发送频率限制剩余时间（秒）
     *
     * @param identifier 标识符，通常是手机号
     * @return 剩余限制时间（秒），如果没有限制则返回-1
     */
    public static long getRateLimitExpireTime(String identifier) {
        if (StringUtils.isBlank(identifier)) {
            return -1;
        }
        String key = buildCaptchaLimitKey(identifier);
        return RedisUtil.getExpire(key);
    }

    /**
     * 验证手机号格式
     *
     * @param mobile 手机号
     * @return 是否是有效的手机号
     */
    public static boolean isValidMobile(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return false;
        }
        return Pattern.matches("^1[3-9]\\d{9}$", mobile);
    }
}
