package com.dou.mall.common.base.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.URLUtil;
import com.dou.mall.common.base.constants.Constants;
import com.dou.mall.common.base.content.ThreadContext;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * ApiLogUtil
 *
 * @author zhoug
 * @date 2025/2/17 18:04
 */

@Slf4j
public class ApiLogUtil {

    private ApiLogUtil() {

    }

    /**
     * 获取参数拼接字符串
     *
     * @see cn.hutool.core.util.URLUtil#buildQuery(Map, Charset)
     */
    public static String getParamString(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, String> paramMap = Maps.newHashMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String name = entry.getKey();
            String[] valueArr = entry.getValue();
            String value = "";
            if (valueArr != null && valueArr.length > 0) {
                // 多个逗号分隔
                if (valueArr.length > 1) {
                    value = Joiner.on(",").join(valueArr);
                } else {
                    value = valueArr[0];
                }
            }
            paramMap.put(name, value);
        }
        return URLUtil.buildQuery(paramMap, CharsetUtil.CHARSET_UTF_8);
    }

    public static String parseUrl(HttpServletRequest request) {
        String url = request.getRequestURI();
        String params = ApiLogUtil.getParamString(request);
        if (StringUtils.isNotBlank(params)) {
            if (!url.endsWith("?")) {
                url = url + "?";
            }
            url = url + params;
        }
        return url;
    }


    public static String parseBody(JoinPoint joinPoint) {
        String body = null;
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Annotation annotation = parameter.getDeclaredAnnotation(RequestBody.class);
            if (annotation != null) {
                if (String.class.equals(parameter.getType())) {
                    body = (String) args[i];
                } else {
                    body = JsonUtil.toJsonString(args[i]);
                }
                break;
            }
        }
        return body;
    }


    public static void logResponse(Object res) {
        if (res == null) {
            return;
        }
        long beginTime = ThreadContext.getLongValue(Constants.BEGIN_TIME);
        long useTime = System.currentTimeMillis() - beginTime;
        String response = JsonUtil.toJsonString(res);
        int length = response.length();
        log.info("Response << time: {} - length: {} - data: {}", useTime, length, response);
    }
}
