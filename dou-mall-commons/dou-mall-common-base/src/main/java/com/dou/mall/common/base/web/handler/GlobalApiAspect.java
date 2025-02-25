package com.dou.mall.common.base.web.handler;

import com.dou.mall.common.base.constants.Constants;
import com.dou.mall.common.base.content.RequestContext;
import com.dou.mall.common.base.content.ThreadContext;
import com.dou.mall.common.base.utils.ApiLogUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * GlobalApiAspect
 *
 * @author zhoug
 * @date 2025/2/17 17:31
 */

@Slf4j
@Aspect
@Component
public class GlobalApiAspect {
    @Pointcut("execution(* com.dou.mall..*.web.api..*Api.*(..)) && !execution(* com.dou.mall.BasicErrorApi.*(..))")
    public void api() {
    }

    @Before("api()")
    public void before(JoinPoint joinPoint) {
        ThreadContext.put(Constants.BEGIN_TIME, System.currentTimeMillis());
        // 填充通用参数
        // 解析request
        HttpServletRequest request = RequestContext.getRequest();
        String ip = request.getRemoteAddr();
        String reqMethod = request.getMethod();
        String url = ApiLogUtil.parseUrl(request);
        // 解析body
        String body = ApiLogUtil.parseBody(joinPoint);

        // 请求参数大于5KB的，截取前面5KB的数据，防止全部打印出来，导致系统被kill
        if (StringUtils.isNotEmpty(body) && body.length() > 5 * 1024) {
            body = StringUtils.substring(body, 0, 5 * 1024);
        }
        String bodyFormat = "";
        if (body != null) {
            bodyFormat = "body: " + body;
        }
        // 打印请求
        log.info("Request  >> ip: {} method: {} url: {} {}", ip, reqMethod, url, bodyFormat);
    }


    @AfterReturning(value = "api()", returning = "res")
    public void afterReturning(Object res) {
        ApiLogUtil.logResponse(res);
    }
}
