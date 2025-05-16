package com.open.mall.common.security.filter;

import com.open.mall.api.auth.domain.bo.UserInfoInTokenBo;
import com.open.mall.api.auth.feign.TokenFeignClient;
import com.open.mall.common.base.api.handler.MallHttpHandler;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.common.base.enums.AuthError;
import com.open.mall.common.base.enums.SystemError;
import com.open.mall.common.feign.constants.FeignConstant;
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

@AllArgsConstructor
@Slf4j
public class AuthFilter implements Filter {
    private static final Pattern AUTHORIZATION_PATTERN =
            Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-:._~+/]+=*)$", Pattern.CASE_INSENSITIVE);
    private static final String BEARER_TOKEN_HEADER_NAME = HttpHeaders.AUTHORIZATION;


    private final AuthPathAdapter authPathAdapter;
    private final TokenFeignClient tokenFeignClient;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        
        String reqUrl = req.getRequestURI();

        // feign
        if(checkFeign(req)){
            filterChain.doFilter(req, resp);
            return;
        }

        // 校验路径白名单
        if (authPathAdapter.mathExcludePath(reqUrl)) {
            filterChain.doFilter(req, resp);
            return;
        }

        String token = getAuthorization(req);
        if(StringUtils.isBlank(token)) {
            MallHttpHandler.printServerResponseToWeb(BaseResult.failure(AuthError.ACCESS_CODE_LOGIN_ERROR));
            return;
        }
        // 校验token
        BaseResult<UserInfoInTokenBo> tokenCheckBoBaseResult = tokenFeignClient.checkToken(token);
        if(tokenCheckBoBaseResult == null || !tokenCheckBoBaseResult.getSuccess()){
            MallHttpHandler.printServerResponseToWeb(BaseResult.failure(SystemError.SYSTEM_INTERNAL_ERROR));
            return;
        }
        UserInfoInTokenBo userInfoInTokenBo = tokenCheckBoBaseResult.getData();
        try {
            AuthUserContext.set(userInfoInTokenBo);
            filterChain.doFilter(req, resp);
        } finally {
            AuthUserContext.clean();
        }
    }

    private boolean checkFeign(HttpServletRequest req) {
        if (req == null){
            return false;
        }
        String header = req.getHeader(FeignConstant.FEIGN_FROM);
        return FeignConstant.FEIGN_IN.equals(header);
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
