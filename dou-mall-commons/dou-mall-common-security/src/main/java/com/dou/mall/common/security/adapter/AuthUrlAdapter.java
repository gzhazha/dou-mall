package com.dou.mall.common.security.adapter;

import java.util.List;

/**
 * AuthUrlConfig
 *
 * @author zhoug
 * @date 2025/2/17 15:48
 */

public interface AuthUrlAdapter {
    /** 需要鉴权的路径 */
    List<String> getPaths();
    /** 不需要鉴权的路径 */
    List<String> getWhitePaths();
}
