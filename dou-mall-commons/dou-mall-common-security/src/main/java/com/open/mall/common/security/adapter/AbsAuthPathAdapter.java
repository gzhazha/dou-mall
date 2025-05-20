package com.open.mall.common.security.adapter;

import com.google.common.collect.ImmutableList;
import com.open.mall.common.feign.constants.FeignConstant;

import java.util.List;

/**
 * AbsAuthPathAdapterImpl
 *
 * @author zhoug
 * @date 2025/5/20 09:42
 */


public abstract class AbsAuthPathAdapter implements AuthPathAdapter {

    /**
     * 内部直接调用接口，无需登录权限
     */
    private static final String FEIGN_INSIDER_URI = FeignConstant.FEIGN_PATH + "/**";

    /**
     * 外部直接调用接口，无需登录权限 unwanted auth
     */
    private static final String EXTERNAL_URI = "/**/ua/**";

    /**
     * swagger
     */
    private static final String DOC_URI = "/v3/api-docs";

    private static final List<String> BASE_URL = ImmutableList.of(DOC_URI,EXTERNAL_URI,FEIGN_INSIDER_URI);

    @Override
    public List<String> getRequiresAuthorizationPaths() {
        return List.of("/**");
    }

    @Override
    public List<String> getNoAuthorizationPaths() {
        List<String> list = addNoAuthorizationPaths();
        if (list == null) {
            return BASE_URL;
        }
        list.addAll(BASE_URL);
        return list;
    }

    protected abstract List<String> addNoAuthorizationPaths();

}
