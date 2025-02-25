package com.dou.mall.common.security.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * AuthFilter
 *
 * @author zhoug
 * @date 2025/2/17 16:12
 */

@Component
public class AuthFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
