package com.open.mall.common.base.api.filter;

import com.open.mall.common.base.constants.BaseConstant;
import com.open.mall.common.base.context.ThreadContext;
import com.open.mall.common.base.enums.SystemError;
import com.open.mall.common.base.exception.MallBaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * LogFilter
 *
 * @author zhoug
 * @date 2025/5/21 14:21
 */

@Slf4j
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            remove();
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
            ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
            logRequest(requestWrapper);
            filterChain.doFilter(requestWrapper, responseWrapper);
            logResponse(responseWrapper);
        } finally {
            remove();
        }
    }

    private void logResponse(ContentCachingResponseWrapper response) {
        long useTime = System.currentTimeMillis() - ThreadContext.getLong(BaseConstant.BEGIN_TIME);
        String data = getBody(response.getContentAsByteArray());
        try {
            response.copyBodyToResponse();
        } catch (IOException e) {
            throw new MallBaseException(SystemError.SYSTEM_ERROR);
        }
        log.info("Response cost: {} ,data: {}", useTime, data);
    }

    private void logRequest(ContentCachingRequestWrapper request) {
        ThreadContext.put(BaseConstant.BEGIN_TIME, System.currentTimeMillis());
        String ip = request.getRemoteAddr();
        String url = request.getRequestURI();
        String method = request.getMethod();
        if (StringUtils.isNotBlank(request.getQueryString())) {
            url = url + "?" + request.getQueryString();
        }
        String body = getBody(request.getContentAsByteArray());
        log.info("Request ip:{} method:{} URI:{} body:{}", ip, method, url, body);
    }

    private String getBody(byte[] bytes) {
        String body = "[blank]";
        if (bytes.length > 0) {
            body = new String(bytes, StandardCharsets.UTF_8);
        }
        return body;
    }

    private void remove() {
        ThreadContext.remove();
    }
}
