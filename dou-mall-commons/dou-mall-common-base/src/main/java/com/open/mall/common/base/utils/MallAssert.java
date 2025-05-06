package com.open.mall.common.base.utils;

import com.open.mall.common.base.enums.ErrorCode;
import com.open.mall.common.base.enums.ErrorEnum;
import com.open.mall.common.base.exception.MallBaseException;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

/**
 * MallAssert
 *
 * @author zhoug
 * @date 2025/4/17 23:08
 */


public class MallAssert {
    private MallAssert() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 断言表达式为真，如果为假则抛出异常
     *
     * @param expression 表达式
     * @param supplier   异常提供者
     * @param <T>        异常类型
     * @throws T 如果表达式为假，则抛出异常
     */
    public static <T extends RuntimeException> void isTrue(boolean expression, Supplier<T> supplier) throws T {
        if(!expression){
            throw supplier.get();
        }
    }

    /**
     * 断言表达式为假，如果为真则抛出异常
     *
     * @param expression 表达式
     * @param supplier   异常提供者
     * @param <T>        异常类型
     * @throws T 如果表达式为真，则抛出异常
     */
    public static <T extends Throwable> void isFalse(boolean expression, Supplier<T> supplier) throws T {
        if(expression){
            throw supplier.get();
        }
    }

    /**
     * 断言表达式为真，如果为假则抛出系统异常
     *
     * @param expression 表达式
     * @param message    异常消息
     * @throws MallBaseException 如果表达式为假，则抛出系统异常
     */
    public static void isTrue(boolean expression, String message) throws MallBaseException {
        isTrue(expression, () -> new MallBaseException(ErrorEnum.SYSTEM_ERROR, message));
    }
    
    /**
     * 断言表达式为真，如果为假则抛出指定错误码异常
     *
     * @param expression 表达式
     * @param errorCode  错误码
     * @throws MallBaseException 如果表达式为假，则抛出指定错误码异常
     */
    public static void isTrue(boolean expression, ErrorCode errorCode) throws MallBaseException {
        isTrue(expression, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言表达式为真，如果为假则抛出指定错误码异常
     *
     * @param expression 表达式
     * @param errorCode  错误码
     * @param message    异常消息
     * @throws MallBaseException 如果表达式为假，则抛出指定错误码异常
     */
    public static void isTrue(boolean expression, ErrorCode errorCode, String message) throws MallBaseException {
        isTrue(expression, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言表达式为假，如果为真则抛出系统异常
     *
     * @param expression 表达式
     * @param message    异常消息
     * @throws MallBaseException 如果表达式为真，则抛出系统异常
     */
    public static void isFalse(boolean expression, String message) throws MallBaseException {
        isFalse(expression, () -> new MallBaseException(ErrorEnum.SYSTEM_ERROR, message));
    }
    
    /**
     * 断言表达式为假，如果为真则抛出指定错误码异常
     *
     * @param expression 表达式
     * @param errorCode  错误码
     * @throws MallBaseException 如果表达式为真，则抛出指定错误码异常
     */
    public static void isFalse(boolean expression, ErrorCode errorCode) throws MallBaseException {
        isFalse(expression, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言表达式为假，如果为真则抛出指定错误码异常
     *
     * @param expression 表达式
     * @param errorCode  错误码
     * @param message    异常消息
     * @throws MallBaseException 如果表达式为真，则抛出指定错误码异常
     */
    public static void isFalse(boolean expression, ErrorCode errorCode, String message) throws MallBaseException {
        isFalse(expression, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言对象不为空，如果为空则抛出异常
     *
     * @param object    对象
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果对象为空，则抛出异常
     */
    public static <T extends RuntimeException> void notNull(Object object, Supplier<T> supplier) throws T {
        if(object == null){
            throw supplier.get();
        }
    }

    /**
     * 断言对象不为空，如果为空则抛出系统异常
     *
     * @param object   对象
     * @param message  异常消息
     * @throws MallBaseException 如果对象为空，则抛出系统异常
     */
    public static void notNull(Object object, String message) throws MallBaseException {
        notNull(object, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言对象不为空，如果为空则抛出指定错误码异常
     *
     * @param object    对象
     * @param errorCode 错误码
     * @throws MallBaseException 如果对象为空，则抛出指定错误码异常
     */
    public static void notNull(Object object, ErrorCode errorCode) throws MallBaseException {
        notNull(object, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言对象不为空，如果为空则抛出指定错误码异常
     *
     * @param object    对象
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果对象为空，则抛出指定错误码异常
     */
    public static void notNull(Object object, ErrorCode errorCode, String message) throws MallBaseException {
        notNull(object, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言对象为空，如果不为空则抛出异常
     *
     * @param object    对象
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果对象不为空，则抛出异常
     */
    public static <T extends RuntimeException> void isNull(Object object, Supplier<T> supplier) throws T {
        if(object != null){
            throw supplier.get();
        }
    }

    /**
     * 断言对象为空，如果不为空则抛出系统异常
     *
     * @param object   对象
     * @param message  异常消息
     * @throws MallBaseException 如果对象不为空，则抛出系统异常
     */
    public static void isNull(Object object, String message) throws MallBaseException {
        isNull(object, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言对象为空，如果不为空则抛出指定错误码异常
     *
     * @param object    对象
     * @param errorCode 错误码
     * @throws MallBaseException 如果对象不为空，则抛出指定错误码异常
     */
    public static void isNull(Object object, ErrorCode errorCode) throws MallBaseException {
        isNull(object, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言对象为空，如果不为空则抛出指定错误码异常
     *
     * @param object    对象
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果对象不为空，则抛出指定错误码异常
     */
    public static void isNull(Object object, ErrorCode errorCode, String message) throws MallBaseException {
        isNull(object, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言字符串不为空白，如果为空白则抛出异常
     *
     * @param text      字符串
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果字符串为空白，则抛出异常
     */
    public static <T extends RuntimeException> void notBlank(String text, Supplier<T> supplier) throws T {
        if(text == null || text.trim().isEmpty()){
            throw supplier.get();
        }
    }

    /**
     * 断言字符串不为空白，如果为空白则抛出系统异常
     *
     * @param text     字符串
     * @param message  异常消息
     * @throws MallBaseException 如果字符串为空白，则抛出系统异常
     */
    public static void notBlank(String text, String message) throws MallBaseException {
        notBlank(text, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言字符串不为空白，如果为空白则抛出指定错误码异常
     *
     * @param text      字符串
     * @param errorCode 错误码
     * @throws MallBaseException 如果字符串为空白，则抛出指定错误码异常
     */
    public static void notBlank(String text, ErrorCode errorCode) throws MallBaseException {
        notBlank(text, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言字符串不为空白，如果为空白则抛出指定错误码异常
     *
     * @param text      字符串
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果字符串为空白，则抛出指定错误码异常
     */
    public static void notBlank(String text, ErrorCode errorCode, String message) throws MallBaseException {
        notBlank(text, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言字符串为空白，如果不为空白则抛出异常
     *
     * @param text      字符串
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果字符串不为空白，则抛出异常
     */
    public static <T extends RuntimeException> void isBlank(String text, Supplier<T> supplier) throws T {
        if(text != null && !text.trim().isEmpty()){
            throw supplier.get();
        }
    }

    /**
     * 断言字符串为空白，如果不为空白则抛出系统异常
     *
     * @param text     字符串
     * @param message  异常消息
     * @throws MallBaseException 如果字符串不为空白，则抛出系统异常
     */
    public static void isBlank(String text, String message) throws MallBaseException {
        isBlank(text, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言字符串为空白，如果不为空白则抛出指定错误码异常
     *
     * @param text      字符串
     * @param errorCode 错误码
     * @throws MallBaseException 如果字符串不为空白，则抛出指定错误码异常
     */
    public static void isBlank(String text, ErrorCode errorCode) throws MallBaseException {
        isBlank(text, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言字符串为空白，如果不为空白则抛出指定错误码异常
     *
     * @param text      字符串
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果字符串不为空白，则抛出指定错误码异常
     */
    public static void isBlank(String text, ErrorCode errorCode, String message) throws MallBaseException {
        isBlank(text, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言字符串不为空，如果为空则抛出异常
     *
     * @param text      字符串
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果字符串为空，则抛出异常
     */
    public static <T extends RuntimeException> void notEmpty(String text, Supplier<T> supplier) throws T {
        if(text == null || text.isEmpty()){
            throw supplier.get();
        }
    }

    /**
     * 断言字符串不为空，如果为空则抛出系统异常
     *
     * @param text     字符串
     * @param message  异常消息
     * @throws MallBaseException 如果字符串为空，则抛出系统异常
     */
    public static void notEmpty(String text, String message) throws MallBaseException {
        notEmpty(text, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言字符串不为空，如果为空则抛出指定错误码异常
     *
     * @param text      字符串
     * @param errorCode 错误码
     * @throws MallBaseException 如果字符串为空，则抛出指定错误码异常
     */
    public static void notEmpty(String text, ErrorCode errorCode) throws MallBaseException {
        notEmpty(text, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言字符串不为空，如果为空则抛出指定错误码异常
     *
     * @param text      字符串
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果字符串为空，则抛出指定错误码异常
     */
    public static void notEmpty(String text, ErrorCode errorCode, String message) throws MallBaseException {
        notEmpty(text, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言集合不为空，如果为空则抛出异常
     *
     * @param collection 集合
     * @param supplier   异常提供者
     * @param <T>        异常类型
     * @throws T 如果集合为空，则抛出异常
     */
    public static <T extends RuntimeException> void notEmpty(Collection<?> collection, Supplier<T> supplier) throws T {
        if(collection == null || collection.isEmpty()){
            throw supplier.get();
        }
    }

    /**
     * 断言集合不为空，如果为空则抛出系统异常
     *
     * @param collection 集合
     * @param message    异常消息
     * @throws MallBaseException 如果集合为空，则抛出系统异常
     */
    public static void notEmpty(Collection<?> collection, String message) throws MallBaseException {
        notEmpty(collection, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言集合不为空，如果为空则抛出指定错误码异常
     *
     * @param collection 集合
     * @param errorCode  错误码
     * @throws MallBaseException 如果集合为空，则抛出指定错误码异常
     */
    public static void notEmpty(Collection<?> collection, ErrorCode errorCode) throws MallBaseException {
        notEmpty(collection, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言集合不为空，如果为空则抛出指定错误码异常
     *
     * @param collection 集合
     * @param errorCode  错误码
     * @param message    异常消息
     * @throws MallBaseException 如果集合为空，则抛出指定错误码异常
     */
    public static void notEmpty(Collection<?> collection, ErrorCode errorCode, String message) throws MallBaseException {
        notEmpty(collection, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言Map不为空，如果为空则抛出异常
     *
     * @param map       Map
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果Map为空，则抛出异常
     */
    public static <T extends RuntimeException> void notEmpty(Map<?, ?> map, Supplier<T> supplier) throws T {
        if(map == null || map.isEmpty()){
            throw supplier.get();
        }
    }

    /**
     * 断言Map不为空，如果为空则抛出系统异常
     *
     * @param map      Map
     * @param message  异常消息
     * @throws MallBaseException 如果Map为空，则抛出系统异常
     */
    public static void notEmpty(Map<?, ?> map, String message) throws MallBaseException {
        notEmpty(map, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言Map不为空，如果为空则抛出指定错误码异常
     *
     * @param map       Map
     * @param errorCode 错误码
     * @throws MallBaseException 如果Map为空，则抛出指定错误码异常
     */
    public static void notEmpty(Map<?, ?> map, ErrorCode errorCode) throws MallBaseException {
        notEmpty(map, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言Map不为空，如果为空则抛出指定错误码异常
     *
     * @param map       Map
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果Map为空，则抛出指定错误码异常
     */
    public static void notEmpty(Map<?, ?> map, ErrorCode errorCode, String message) throws MallBaseException {
        notEmpty(map, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言数组不为空，如果为空则抛出异常
     *
     * @param array     数组
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果数组为空，则抛出异常
     */
    public static <T extends RuntimeException> void notEmpty(Object[] array, Supplier<T> supplier) throws T {
        if(array == null || array.length == 0){
            throw supplier.get();
        }
    }

    /**
     * 断言数组不为空，如果为空则抛出系统异常
     *
     * @param array    数组
     * @param message  异常消息
     * @throws MallBaseException 如果数组为空，则抛出系统异常
     */
    public static void notEmpty(Object[] array, String message) throws MallBaseException {
        notEmpty(array, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言数组不为空，如果为空则抛出指定错误码异常
     *
     * @param array     数组
     * @param errorCode 错误码
     * @throws MallBaseException 如果数组为空，则抛出指定错误码异常
     */
    public static void notEmpty(Object[] array, ErrorCode errorCode) throws MallBaseException {
        notEmpty(array, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言数组不为空，如果为空则抛出指定错误码异常
     *
     * @param array     数组
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果数组为空，则抛出指定错误码异常
     */
    public static void notEmpty(Object[] array, ErrorCode errorCode, String message) throws MallBaseException {
        notEmpty(array, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言对象相等，如果不相等则抛出异常
     *
     * @param expected  预期对象
     * @param actual    实际对象
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果对象不相等，则抛出异常
     */
    public static <T extends RuntimeException> void equals(Object expected, Object actual, Supplier<T> supplier) throws T {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw supplier.get();
        }
    }

    /**
     * 断言对象相等，如果不相等则抛出系统异常
     *
     * @param expected  预期对象
     * @param actual    实际对象
     * @param message   异常消息
     * @throws MallBaseException 如果对象不相等，则抛出系统异常
     */
    public static void equals(Object expected, Object actual, String message) throws MallBaseException {
        equals(expected, actual, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言对象相等，如果不相等则抛出指定错误码异常
     *
     * @param expected  预期对象
     * @param actual    实际对象
     * @param errorCode 错误码
     * @throws MallBaseException 如果对象不相等，则抛出指定错误码异常
     */
    public static void equals(Object expected, Object actual, ErrorCode errorCode) throws MallBaseException {
        equals(expected, actual, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言对象相等，如果不相等则抛出指定错误码异常
     *
     * @param expected  预期对象
     * @param actual    实际对象
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果对象不相等，则抛出指定错误码异常
     */
    public static void equals(Object expected, Object actual, ErrorCode errorCode, String message) throws MallBaseException {
        equals(expected, actual, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言对象不相等，如果相等则抛出异常
     *
     * @param unexpected 不期望的对象
     * @param actual     实际对象
     * @param supplier   异常提供者
     * @param <T>        异常类型
     * @throws T 如果对象相等，则抛出异常
     */
    public static <T extends RuntimeException> void notEquals(Object unexpected, Object actual, Supplier<T> supplier) throws T {
        if (unexpected == null ? actual == null : unexpected.equals(actual)) {
            throw supplier.get();
        }
    }

    /**
     * 断言对象不相等，如果相等则抛出系统异常
     *
     * @param unexpected 不期望的对象
     * @param actual     实际对象
     * @param message    异常消息
     * @throws MallBaseException 如果对象相等，则抛出系统异常
     */
    public static void notEquals(Object unexpected, Object actual, String message) throws MallBaseException {
        notEquals(unexpected, actual, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言对象不相等，如果相等则抛出指定错误码异常
     *
     * @param unexpected 不期望的对象
     * @param actual     实际对象
     * @param errorCode  错误码
     * @throws MallBaseException 如果对象相等，则抛出指定错误码异常
     */
    public static void notEquals(Object unexpected, Object actual, ErrorCode errorCode) throws MallBaseException {
        notEquals(unexpected, actual, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言对象不相等，如果相等则抛出指定错误码异常
     *
     * @param unexpected 不期望的对象
     * @param actual     实际对象
     * @param errorCode  错误码
     * @param message    异常消息
     * @throws MallBaseException 如果对象相等，则抛出指定错误码异常
     */
    public static void notEquals(Object unexpected, Object actual, ErrorCode errorCode, String message) throws MallBaseException {
        notEquals(unexpected, actual, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言数值大于指定值，如果小于等于则抛出异常
     *
     * @param value     数值
     * @param min       最小值（不包含）
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果数值小于等于指定值，则抛出异常
     */
    public static <T extends RuntimeException> void greaterThan(Number value, Number min, Supplier<T> supplier) throws T {
        notNull(value, supplier);
        notNull(min, supplier);
        if (value.doubleValue() <= min.doubleValue()) {
            throw supplier.get();
        }
    }

    /**
     * 断言数值大于指定值，如果小于等于则抛出系统异常
     *
     * @param value    数值
     * @param min      最小值（不包含）
     * @param message  异常消息
     * @throws MallBaseException 如果数值小于等于指定值，则抛出系统异常
     */
    public static void greaterThan(Number value, Number min, String message) throws MallBaseException {
        greaterThan(value, min, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言数值大于指定值，如果小于等于则抛出指定错误码异常
     *
     * @param value     数值
     * @param min       最小值（不包含）
     * @param errorCode 错误码
     * @throws MallBaseException 如果数值小于等于指定值，则抛出指定错误码异常
     */
    public static void greaterThan(Number value, Number min, ErrorCode errorCode) throws MallBaseException {
        greaterThan(value, min, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言数值大于指定值，如果小于等于则抛出指定错误码异常
     *
     * @param value     数值
     * @param min       最小值（不包含）
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果数值小于等于指定值，则抛出指定错误码异常
     */
    public static void greaterThan(Number value, Number min, ErrorCode errorCode, String message) throws MallBaseException {
        greaterThan(value, min, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言数值大于等于指定值，如果小于则抛出异常
     *
     * @param value     数值
     * @param min       最小值（包含）
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果数值小于指定值，则抛出异常
     */
    public static <T extends RuntimeException> void greaterThanOrEqual(Number value, Number min, Supplier<T> supplier) throws T {
        notNull(value, supplier);
        notNull(min, supplier);
        if (value.doubleValue() < min.doubleValue()) {
            throw supplier.get();
        }
    }

    /**
     * 断言数值大于等于指定值，如果小于则抛出系统异常
     *
     * @param value    数值
     * @param min      最小值（包含）
     * @param message  异常消息
     * @throws MallBaseException 如果数值小于指定值，则抛出系统异常
     */
    public static void greaterThanOrEqual(Number value, Number min, String message) throws MallBaseException {
        greaterThanOrEqual(value, min, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言数值大于等于指定值，如果小于则抛出指定错误码异常
     *
     * @param value     数值
     * @param min       最小值（包含）
     * @param errorCode 错误码
     * @throws MallBaseException 如果数值小于指定值，则抛出指定错误码异常
     */
    public static void greaterThanOrEqual(Number value, Number min, ErrorCode errorCode) throws MallBaseException {
        greaterThanOrEqual(value, min, () -> new MallBaseException(errorCode, errorCode.getMsg()));
    }
    
    /**
     * 断言数值大于等于指定值，如果小于则抛出指定错误码异常
     *
     * @param value     数值
     * @param min       最小值（包含）
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果数值小于指定值，则抛出指定错误码异常
     */
    public static void greaterThanOrEqual(Number value, Number min, ErrorCode errorCode, String message) throws MallBaseException {
        greaterThanOrEqual(value, min, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言数值小于指定值，如果大于等于则抛出异常
     *
     * @param value     数值
     * @param max       最大值（不包含）
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果数值大于等于指定值，则抛出异常
     */
    public static <T extends RuntimeException> void lessThan(Number value, Number max, Supplier<T> supplier) throws T {
        notNull(value, supplier);
        notNull(max, supplier);
        if (value.doubleValue() >= max.doubleValue()) {
            throw supplier.get();
        }
    }

    /**
     * 断言数值小于指定值，如果大于等于则抛出系统异常
     *
     * @param value    数值
     * @param max      最大值（不包含）
     * @param message  异常消息
     * @throws MallBaseException 如果数值大于等于指定值，则抛出系统异常
     */
    public static void lessThan(Number value, Number max, String message) throws MallBaseException {
        lessThan(value, max, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言数值小于指定值，如果大于等于则抛出指定错误码异常
     *
     * @param value     数值
     * @param max       最大值（不包含）
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果数值大于等于指定值，则抛出指定错误码异常
     */
    public static void lessThan(Number value, Number max, ErrorCode errorCode, String message) throws MallBaseException {
        lessThan(value, max, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言数值小于等于指定值，如果大于则抛出异常
     *
     * @param value     数值
     * @param max       最大值（包含）
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果数值大于指定值，则抛出异常
     */
    public static <T extends RuntimeException> void lessThanOrEqual(Number value, Number max, Supplier<T> supplier) throws T {
        notNull(value, supplier);
        notNull(max, supplier);
        if (value.doubleValue() > max.doubleValue()) {
            throw supplier.get();
        }
    }

    /**
     * 断言数值小于等于指定值，如果大于则抛出系统异常
     *
     * @param value    数值
     * @param max      最大值（包含）
     * @param message  异常消息
     * @throws MallBaseException 如果数值大于指定值，则抛出系统异常
     */
    public static void lessThanOrEqual(Number value, Number max, String message) throws MallBaseException {
        lessThanOrEqual(value, max, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言数值小于等于指定值，如果大于则抛出指定错误码异常
     *
     * @param value     数值
     * @param max       最大值（包含）
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果数值大于指定值，则抛出指定错误码异常
     */
    public static void lessThanOrEqual(Number value, Number max, ErrorCode errorCode, String message) throws MallBaseException {
        lessThanOrEqual(value, max, () -> new MallBaseException(errorCode, message));
    }

    /**
     * 断言数值在指定范围内，如果不在则抛出异常
     *
     * @param value     数值
     * @param min       最小值（包含）
     * @param max       最大值（包含）
     * @param supplier  异常提供者
     * @param <T>       异常类型
     * @throws T 如果数值不在指定范围内，则抛出异常
     */
    public static <T extends RuntimeException> void between(Number value, Number min, Number max, Supplier<T> supplier) throws T {
        notNull(value, supplier);
        notNull(min, supplier);
        notNull(max, supplier);
        if (value.doubleValue() < min.doubleValue() || value.doubleValue() > max.doubleValue()) {
            throw supplier.get();
        }
    }

    /**
     * 断言数值在指定范围内，如果不在则抛出系统异常
     *
     * @param value    数值
     * @param min      最小值（包含）
     * @param max      最大值（包含）
     * @param message  异常消息
     * @throws MallBaseException 如果数值不在指定范围内，则抛出系统异常
     */
    public static void between(Number value, Number min, Number max, String message) throws MallBaseException {
        between(value, min, max, () -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, message));
    }
    
    /**
     * 断言数值在指定范围内，如果不在则抛出指定错误码异常
     *
     * @param value     数值
     * @param min       最小值（包含）
     * @param max       最大值（包含）
     * @param errorCode 错误码
     * @param message   异常消息
     * @throws MallBaseException 如果数值不在指定范围内，则抛出指定错误码异常
     */
    public static void between(Number value, Number min, Number max, ErrorCode errorCode, String message) throws MallBaseException {
        between(value, min, max, () -> new MallBaseException(errorCode, message));
    }
}
