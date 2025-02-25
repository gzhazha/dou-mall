package com.dou.mall.common.base.content;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * RequestContext
 *
 * @author xuyaguang
 * @date 2015年11月3日 下午2:49
 */
public class RequestContext {

    private static final ThreadLocal<HttpServletRequest> REQUEST_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<HttpServletResponse> RESPONSE_THREAD_LOCAL = new ThreadLocal<>();

    public static void init(HttpServletRequest req, HttpServletResponse res) {
        REQUEST_THREAD_LOCAL.set(req);
        RESPONSE_THREAD_LOCAL.set(res);
    }

    public static void remove() {
        REQUEST_THREAD_LOCAL.remove();
        RESPONSE_THREAD_LOCAL.remove();
    }

    public static HttpServletRequest getRequest() {
        return REQUEST_THREAD_LOCAL.get();
    }

    public static HttpServletResponse getResponse() {
        return RESPONSE_THREAD_LOCAL.get();
    }

}
