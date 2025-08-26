package com.open.mall.common.base.utils;

import com.open.mall.common.base.enums.CommonCodeEnum;
import com.open.mall.common.base.enums.ResultCode;
import com.open.mall.common.base.exception.DouException;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * DouAssertion 断言工具类
 * 提供常用的断言方法，当条件不满足时抛出DouException异常
 *
 * @author zhoug
 * @date 2025/8/25 15:11
 */
@UtilityClass
public class DouAssertion {

    /**
     * 断言表达式为真，否则抛出异常
     *
     * @param expression 表达式
     * @param message    异常消息
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言表达式为真，否则抛出异常
     *
     * @param expression 表达式
     * @param resultCode 结果码
     */
    public static void isTrue(boolean expression, ResultCode resultCode) {
        if (!expression) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言表达式为假，否则抛出异常
     *
     * @param expression 表达式
     * @param message    异常消息
     */
    public static void isFalse(boolean expression, String message) {
        if (expression) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言表达式为假，否则抛出异常
     *
     * @param expression 表达式
     * @param resultCode 结果码
     */
    public static void isFalse(boolean expression, ResultCode resultCode) {
        if (expression) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言对象不为null，否则抛出异常
     *
     * @param object  对象
     * @param message 异常消息
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new DouException(ResultCode.custom(message));
        }
    }
    /**
     * 断言对象不为null，否则抛出异常
     *
     * @param object  对象
     */
    public static void notNull(Object object) {
        if (object == null) {
            throw new DouException(CommonCodeEnum.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 断言对象不为null，否则抛出异常
     *
     * @param object     对象
     * @param resultCode 结果码
     */
    public static void notNull(Object object, ResultCode resultCode) {
        if (object == null) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言对象为null，否则抛出异常
     *
     * @param object  对象
     * @param message 异常消息
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言对象不为null，否则抛出异常
     *
     * @param object     对象
     * @param resultCode 结果码
     */
    public static void notBlank(String object, ResultCode resultCode) {
        if (object == null || object.isEmpty()) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言对象为null，否则抛出异常
     *
     * @param object     对象
     * @param resultCode 结果码
     */
    public static void isNull(Object object, ResultCode resultCode) {
        if (object != null) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言字符串不为空（不为null且不为空字符串），否则抛出异常
     *
     * @param text    字符串
     * @param message 异常消息
     */
    public static void hasText(String text, String message) {
        if (text == null || text.trim().isEmpty()) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言字符串不为空（不为null且不为空字符串），否则抛出异常
     *
     * @param text       字符串
     * @param resultCode 结果码
     */
    public static void hasText(String text, ResultCode resultCode) {
        if (text == null || text.trim().isEmpty()) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言字符串为空（为null或为空字符串），否则抛出异常
     *
     * @param text    字符串
     * @param message 异常消息
     */
    public static void noText(String text, String message) {
        if (text != null && !text.trim().isEmpty()) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言字符串为空（为null或为空字符串），否则抛出异常
     *
     * @param text       字符串
     * @param resultCode 结果码
     */
    public static void noText(String text, ResultCode resultCode) {
        if (text != null && !text.trim().isEmpty()) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言集合不为空，否则抛出异常
     *
     * @param collection 集合
     * @param message    异常消息
     */
    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言集合不为空，否则抛出异常
     *
     * @param collection 集合
     * @param resultCode 结果码
     */
    public static void notEmpty(Collection<?> collection, ResultCode resultCode) {
        if (collection == null || collection.isEmpty()) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言Map不为空，否则抛出异常
     *
     * @param map     Map对象
     * @param message 异常消息
     */
    public static void notEmpty(Map<?, ?> map, String message) {
        if (map == null || map.isEmpty()) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言Map不为空，否则抛出异常
     *
     * @param map        Map对象
     * @param resultCode 结果码
     */
    public static void notEmpty(Map<?, ?> map, ResultCode resultCode) {
        if (map == null || map.isEmpty()) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言数组不为空，否则抛出异常
     *
     * @param array   数组
     * @param message 异常消息
     */
    public static void notEmpty(Object[] array, String message) {
        if (array == null || array.length == 0) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言数组不为空，否则抛出异常
     *
     * @param array      数组
     * @param resultCode 结果码
     */
    public static void notEmpty(Object[] array, ResultCode resultCode) {
        if (array == null || array.length == 0) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言两个对象相等，否则抛出异常
     *
     * @param obj1    对象1
     * @param obj2    对象2
     * @param message 异常消息
     */
    public static void equals(Object obj1, Object obj2, String message) {
        if (!Objects.equals(obj1, obj2)) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言两个对象相等，否则抛出异常
     *
     * @param obj1       对象1
     * @param obj2       对象2
     * @param resultCode 结果码
     */
    public static void equals(Object obj1, Object obj2, ResultCode resultCode) {
        if (!Objects.equals(obj1, obj2)) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言两个对象不相等，否则抛出异常
     *
     * @param obj1    对象1
     * @param obj2    对象2
     * @param message 异常消息
     */
    public static void notEquals(Object obj1, Object obj2, String message) {
        if (Objects.equals(obj1, obj2)) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言两个对象不相等，否则抛出异常
     *
     * @param obj1       对象1
     * @param obj2       对象2
     * @param resultCode 结果码
     */
    public static void notEquals(Object obj1, Object obj2, ResultCode resultCode) {
        if (Objects.equals(obj1, obj2)) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言数值大于指定值，否则抛出异常
     *
     * @param value   数值
     * @param min     最小值
     * @param message 异常消息
     */
    public static void greaterThan(Number value, Number min, String message) {
        if (value == null || min == null || value.doubleValue() <= min.doubleValue()) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言数值大于指定值，否则抛出异常
     *
     * @param value      数值
     * @param min        最小值
     * @param resultCode 结果码
     */
    public static void greaterThan(Number value, Number min, ResultCode resultCode) {
        if (value == null || min == null || value.doubleValue() <= min.doubleValue()) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言数值大于等于指定值，否则抛出异常
     *
     * @param value   数值
     * @param min     最小值
     * @param message 异常消息
     */
    public static void greaterThanOrEqual(Number value, Number min, String message) {
        if (value == null || min == null || value.doubleValue() < min.doubleValue()) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言数值大于等于指定值，否则抛出异常
     *
     * @param value      数值
     * @param min        最小值
     * @param resultCode 结果码
     */
    public static void greaterThanOrEqual(Number value, Number min, ResultCode resultCode) {
        if (value == null || min == null || value.doubleValue() < min.doubleValue()) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言数值小于指定值，否则抛出异常
     *
     * @param value   数值
     * @param max     最大值
     * @param message 异常消息
     */
    public static void lessThan(Number value, Number max, String message) {
        if (value == null || max == null || value.doubleValue() >= max.doubleValue()) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言数值小于指定值，否则抛出异常
     *
     * @param value      数值
     * @param max        最大值
     * @param resultCode 结果码
     */
    public static void lessThan(Number value, Number max, ResultCode resultCode) {
        if (value == null || max == null || value.doubleValue() >= max.doubleValue()) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言数值小于等于指定值，否则抛出异常
     *
     * @param value   数值
     * @param max     最大值
     * @param message 异常消息
     */
    public static void lessThanOrEqual(Number value, Number max, String message) {
        if (value == null || max == null || value.doubleValue() > max.doubleValue()) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言数值小于等于指定值，否则抛出异常
     *
     * @param value      数值
     * @param max        最大值
     * @param resultCode 结果码
     */
    public static void lessThanOrEqual(Number value, Number max, ResultCode resultCode) {
        if (value == null || max == null || value.doubleValue() > max.doubleValue()) {
            throw new DouException(resultCode);
        }
    }

    /**
     * 断言数值在指定范围内，否则抛出异常
     *
     * @param value   数值
     * @param min     最小值
     * @param max     最大值
     * @param message 异常消息
     */
    public static void inRange(Number value, Number min, Number max, String message) {
        if (value == null || min == null || max == null || 
            value.doubleValue() < min.doubleValue() || value.doubleValue() > max.doubleValue()) {
            throw new DouException(ResultCode.custom(message));
        }
    }

    /**
     * 断言数值在指定范围内，否则抛出异常
     *
     * @param value      数值
     * @param min        最小值
     * @param max        最大值
     * @param resultCode 结果码
     */
    public static void inRange(Number value, Number min, Number max, ResultCode resultCode) {
        if (value == null || min == null || max == null || 
            value.doubleValue() < min.doubleValue() || value.doubleValue() > max.doubleValue()) {
            throw new DouException(resultCode);
        }
    }

}
