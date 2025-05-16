package com.open.mall.common.security.adapter;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author FrozenWatermelon
 * @date 2020/7/16
 */
@Slf4j
public class DefaultAuthPathAdapter implements AuthPathAdapter {

	public DefaultAuthPathAdapter() {
		log.info("not implement other AuthConfigAdapter, use DefaultAuthConfigAdapter... all url need auth...");
	}

	/**
	 * 外部直接调用接口，无需登录权限 unwanted auth
	 */
	private static final String EXTERNAL_URI = "/**/ua/**";

	/**
	 * swagger
	 */
	private static final String DOC_URI = "/v3/api-docs/**";
	
	/**
	 * swagger-ui
	 */
	private static final String SWAGGER_UI = "/swagger-ui/**";


    @Override
    public Set<String> requiresAuthorizationPaths() {
        return Set.of("/*");
    }

    @Override
    public Set<String> noAuthorizationPaths() {
        Set<String> set = new HashSet<>();
        set.add(DOC_URI);
        set.add(EXTERNAL_URI);
        set.add(SWAGGER_UI);
        return set;
    }
}
