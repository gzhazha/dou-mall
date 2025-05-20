package com.open.mall.common.security.adapter;

import java.util.List;

/**
 * AuthPathAdapter
 *
 * @author zhoug
 * @date 2025/4/29 16:47
 */

public interface AuthPathAdapter {
    /**
     * 需要授权登陆的路径
     *
     * @return 需要授权登陆的路径列表
     */
    List<String> getRequiresAuthorizationPaths();

    /**
     * 不需要授权登陆的路径
     *
     * @return 不需要授权登陆的路径列表
     */
    List<String> getNoAuthorizationPaths();


}
