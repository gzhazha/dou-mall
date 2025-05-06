package com.open.mall.common.base.enums;

/**
 * ResultCode
 *
 * @author zhoug
 * @date 2025/4/17 09:51
 */

public interface ErrorCode {
    /**
     * 获取返回码
     * @return
     */
    Integer getCode();

    /**
     * 获取响应信息
     * @return
     */
    String getMsg();

}
