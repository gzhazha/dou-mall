package com.open.mall.common.base.context;

import cn.hutool.core.convert.Convert;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;


public class ThreadContext {

    private static final ThreadLocal<Map<String, Object>> MAP_THREAD_LOCAL = ThreadLocal.withInitial(Maps::newHashMap);

    public static void remove() {
        MAP_THREAD_LOCAL.remove();
    }

    public static void put(String k, Object v) {
        MAP_THREAD_LOCAL.get().put(k, v);
    }

    public static Object get(String k) {
        return MAP_THREAD_LOCAL.get().get(k);
    }

    public static <T> T getObject(String key, Class<T> clazz) {
        Object obj = get(key);
        return Convert.convert(clazz, obj);
    }

    public static Boolean getBoolean(String key) {
        Object value = get(key);
        return Convert.toBool(value);
    }

    public static byte[] getBytes(String key) {
        Object value = get(key);
        return Convert.toPrimitiveByteArray(value);
    }

    public static boolean getBooleanValue(String key) {
        Object value = get(key);
        return Convert.toBool(value, false);
    }

    public static Byte getByte(String key) {
        Object value = get(key);
        return Convert.toByte(value);
    }

    public static byte getByteValue(String key) {
        Object value = get(key);
        return Convert.toByte(value, (byte) 0);
    }

    public static Short getShort(String key) {
        Object value = get(key);
        return Convert.toShort(value);
    }

    public static short getShortValue(String key) {
        Object value = get(key);
        return Convert.toShort(value, (short) 0);
    }

    public static Integer getInteger(String key) {
        Object value = get(key);
        return Convert.toInt(value);
    }

    public static int getIntValue(String key) {
        Object value = get(key);
        return Convert.toInt(value, 0);
    }

    public static Long getLong(String key) {
        Object value = get(key);
        return Convert.toLong(value);
    }

    public static long getLongValue(String key) {
        Object value = get(key);
        return Convert.toLong(value, 0L);
    }

    public static Float getFloat(String key) {
        Object value = get(key);
        return Convert.toFloat(value);
    }

    public static float getFloatValue(String key) {
        Object value = get(key);
        return Convert.toFloat(value, 0F);
    }

    public static Double getDouble(String key) {
        Object value = get(key);
        return Convert.toDouble(value);
    }

    public static double getDoubleValue(String key) {
        Object value = get(key);
        return Convert.toDouble(value, 0D);
    }

    public static BigDecimal getBigDecimal(String key) {
        Object value = get(key);
        return Convert.toBigDecimal(value);
    }

    public static BigInteger getBigInteger(String key) {
        Object value = get(key);
        return Convert.toBigInteger(value);
    }

    public static String getString(String key) {
        Object value = get(key);
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public static Date getDate(String key) {
        Object value = get(key);
        return Convert.toDate(value);
    }
}