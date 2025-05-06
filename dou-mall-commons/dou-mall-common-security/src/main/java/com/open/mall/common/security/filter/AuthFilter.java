package com.open.mall.common.security.filter;

import com.open.mall.api.auth.domain.bo.UserInfoInTokenBo;
import com.open.mall.api.auth.feign.TokenFeignClient;
import com.open.mall.common.base.api.handler.MallHttpHandler;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.common.base.enums.AuthErrorEnum;
import com.open.mall.common.base.enums.ErrorEnum;
import com.open.mall.common.security.AuthUserContext;
import com.open.mall.common.security.adapter.AuthPathAdapter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * AuthFilter
 *
 * @author zhoug
 * @date 2025/4/29 16:38
 */

@Component
@AllArgsConstructor
@Slf4j
public class AuthFilter implements Filter {
    private static final Pattern AUTHORIZATION_PATTERN = Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-:._~+/]+=*)$",
            Pattern.CASE_INSENSITIVE);
    private static final String BEARER_TOKEN_HEADER_NAME = HttpHeaders.AUTHORIZATION;


    private final AuthPathAdapter authPathAdapter;
    private final TokenFeignClient tokenFeignClient;
    private final MallHttpHandler mallHttpHandler;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String reqUrl = req.getRequestURI();

        // todo 校验feign
        // 校验路径白名单
        if (authPathAdapter.mathExcludePath(reqUrl)) {
            filterChain.doFilter(req, resp);
            return;
        }

        String token = getAuthorization(req);
        if(StringUtils.isBlank(token)) {
            mallHttpHandler.printServerResponseToWeb(BaseResult.failure(AuthErrorEnum.ACCESS_CODE_LOGIN_ERROR));
            return;
        }
        // 校验token
        BaseResult<UserInfoInTokenBo> tokenCheckBoBaseResult = tokenFeignClient.checkToken(token);
        if(tokenCheckBoBaseResult == null || !tokenCheckBoBaseResult.getSuccess()){
            mallHttpHandler.printServerResponseToWeb(BaseResult.failure(ErrorEnum.SYSTEM_INTERNAL_ERROR));
            return;
        }
        UserInfoInTokenBo userInfoInTokenBo = tokenCheckBoBaseResult.getData();
        AuthUserContext.set(userInfoInTokenBo);
        filterChain.doFilter(req, resp);
    }

    private String getAuthorization(HttpServletRequest request) {
        String authorization = request.getHeader(BEARER_TOKEN_HEADER_NAME);
        if (!StringUtils.startsWithIgnoreCase(authorization, "bearer")) {
            return null;
        }
        Matcher matcher = AUTHORIZATION_PATTERN.matcher(authorization);
        if(!matcher.matches()){
            return null;
        }
        return matcher.group("token");
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
