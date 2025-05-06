package com.open.mall.common.security.adapter;

import java.util.Set;

/**
 * AuthPathAdapter
 *
 * @author zhoug
 * @date 2025/4/29 16:47
 */

public abstract class AuthPathAdapter {
    private static final Set<String> AUTH_PATH_LIST = Set.of("", "1");

    /**
     * 需要授权登陆的路径
     *
     * @return 需要授权登陆的路径列表
     */
    protected abstract Set<String> needLoginPath();

    /**
     * 不需要授权登陆的路径
     *
     * @return 不需要授权登陆的路径列表
     */
    protected abstract Set<String> excludePath();

    private boolean matchPath(Set<String> paths, String path) {
        if (path == null || path.isEmpty()) {
            return false;
        }
        if (paths == null || paths.isEmpty()) {
            return true;
        }
        return paths.contains(path);
    }

    public final boolean mathExcludePath(String path) {
        if (AUTH_PATH_LIST.contains(path)) {
            return true;
        }
        return matchPath(excludePath(), path);
    }

    public final boolean mathNeedLoginPath(String path) {
        return matchPath(needLoginPath(), path);
    }

}
