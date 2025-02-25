package com.dou.mall.common.base.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.JsonRecyclerPools;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


@Slf4j
public class JsonUtil {

    private static final ObjectMapper OM = getObjectMapper("yyyy-MM-dd HH:mm:ss");

    private static class NonDateFormatJsonMapper {
        public static final ObjectMapper OM = getObjectMapper(null);
    }

    private static class PrettyJsonWriter {
        public static final ObjectWriter OW = OM.writerWithDefaultPrettyPrinter();
    }

    /**
     * 创建初始化信息
     *
     * @param dateFormat 时间格式
     * @return objectMapper
     */
    public static ObjectMapper getObjectMapper(String dateFormat) {
        ObjectMapper objectMapper = JsonMapper.builder()
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                // 解析器支持解析单引号
                .enable(Feature.ALLOW_SINGLE_QUOTES)
                // 解析器支持非双引号
                .enable(Feature.ALLOW_UNQUOTED_FIELD_NAMES)
                // 解析器支持解析结束符
                .enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS).build();
        if (StringUtils.isNotEmpty(dateFormat)) {
            // 设置当前json格式日期格式
            objectMapper.setDateFormat(new SimpleDateFormat(dateFormat));
        }
        objectMapper.getFactory().setRecyclerPool(JsonRecyclerPools.newConcurrentDequePool());
        return objectMapper;
    }

    /**
     * 将json字符串反序列化为java对象
     *
     * @param json  json字符串
     * @param clazz java对象类
     * @param <T>   java对象类型
     * @return java对象，参数为空或者反序列化异常会返回null
     */
    public static <T> T parse(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return OM.readValue(json, clazz);
        } catch (Exception e) {
            log.error("Parse json string to object error", e);
            return null;
        }
    }

    /**
     * 将json字符串反序列化为java对象
     *
     * @param json          json字符串
     * @param typeReference typeReference
     * @param <T>           java对象类型
     * @return java对象，参数为空或者反序列化异常会返回null
     */
    public static <T> T parse(String json, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return OM.readValue(json, typeReference);
        } catch (Exception e) {
            log.error("Parse json string to object error", e);
            return null;
        }
    }

    /**
     * 将json字符串反序列化为map对象
     *
     * @param json json字符串
     * @return map对象，参数为空或者反序列化异常会返回null
     */
    public static Map<String, Object> parseMap(String json) {
        return parse(json, new TypeReference<Map<String, Object>>() {
        });
    }

    /**
     * 将json字符串反序列化为java对象集合
     *
     * @param json  json字符串
     * @param clazz java对象类
     * @param <T>   java对象类型
     * @return java对象集合，参数为空或者反序列化异常会返回null
     */
    public static <T> List<T> parseList(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        JavaType type = OM.getTypeFactory().constructCollectionType(List.class, clazz);
        try {
            return OM.readValue(json, type);
        } catch (Exception e) {
            log.error("Parse json list string to object list error", e);
            return null;
        }
    }

    /**
     * 将json字符串反序列化为java通用类型
     *
     * @param json            json字符串
     * @param collectionClass java对象类
     * @param elementClasses  元素类型
     * @return java通用类型对象
     */
    public static <T> T parse(String json, Class<?> collectionClass, Class<?>... elementClasses) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        JavaType type = OM.getTypeFactory().constructParametricType(collectionClass, elementClasses);
        try {
            return OM.readValue(json, type);
        } catch (IOException e) {
            log.error("Parse json collection string to object list error", e);
            return null;
        }
    }

    /**
     * 将一个java对象序列化为json字符串
     *
     * @param object java对象
     * @return json字符串，参数为null或者序列化异常会返回null
     */
    public static String toJsonString(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return OM.writeValueAsString(object);
        } catch (Exception e) {
            log.error("Object to json string error", e);
            return null;
        }
    }

    /**
     * 将一个java对象序列化为pretty json字符串
     *
     * @param object java对象
     * @return pretty json字符串，参数为null或者序列化异常会返回null
     */
    public static String toPrettyJsonString(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return PrettyJsonWriter.OW.writeValueAsString(object);
        } catch (Exception e) {
            log.error("Object to json string error", e);
            return null;
        }
    }

    /**
     * 将一个java对象序列化为json字符串，无时间格式
     *
     * @param object java对象
     * @return json字符串，参数为null或者序列化异常会返回null
     */
    public static String toNullDateJsonString(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return NonDateFormatJsonMapper.OM.writeValueAsString(object);
        } catch (Exception e) {
            log.error("Object to json string error", e);
            return null;
        }
    }

    /**
     * 获取json字符串某个属性的值
     *
     * @param json  json字符串
     * @param attrs 属性名，多级用“.”分隔，如 "aa.bb.cc"
     * @return 属性值
     */
    public static String getNodeValue(String json, String attrs) {
        if (StringUtils.isEmpty(json) || StringUtils.isEmpty(attrs)) {
            return null;
        }
        try {
            JsonNode node = OM.readTree(json);
            return getNodeValue(node, attrs);
        } catch (Exception e) {
            log.error("Get json string node value error", e);
            return null;
        }
    }

    /**
     * 将json字符串转化为JsonNode
     *
     * @param json json字符串
     * @return JsonNode
     */
    public static JsonNode parseJsonNode(String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return OM.readTree(json);
        } catch (Exception e) {
            log.error("Parse json string to JsonNode error", e);
            return null;
        }
    }

    /**
     * 获取json节点某个属性的值
     *
     * @param node  json节点
     * @param attrs 属性名，多级用“.”分隔，如 "aa.bb.cc"
     * @return 属性值
     */
    public static String getNodeValue(JsonNode node, String attrs) {
        int index = attrs.indexOf('.');
        if (index == -1) {
            if (node != null && node.get(attrs) != null) {
                return node.get(attrs).asText();
            } else {
                return null;
            }
        } else {
            String s1 = attrs.substring(0, index);
            String s2 = attrs.substring(index + 1);
            return getNodeValue(node.get(s1), s2);
        }
    }
}
