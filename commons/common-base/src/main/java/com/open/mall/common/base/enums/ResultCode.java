package com.open.mall.common.base.enums;

import com.open.mall.common.base.constants.CommonConst;

/**
 * ResultCode
 *
 * @author zhoug
 * @date 2025/8/22 18:51
 */

public interface ResultCode {
    Integer getCode();
    String getMsg();

    /**
     * 创建自定义错误信息的ResultCode
     *
     * @param customMsg 自定义错误消息
     * @return 自定义的ResultCode实例
     */
    static ResultCode custom(String customMsg) {
        return new ResultCode() {
            @Override
            public Integer getCode() {
                return CommonConst.CUSTOM_ERROR_CODE;
            }

            @Override
            public String getMsg() {
                return customMsg;
            }
        };
    }

    /**
     * 创建自定义错误码和错误信息的ResultCode
     *
     * @param customCode 自定义错误码
     * @param customMsg  自定义错误消息
     * @return 自定义的ResultCode实例
     */
    static ResultCode custom(int customCode, String customMsg) {
        return new ResultCode() {
            @Override
            public Integer getCode() {
                return customCode;
            }

            @Override
            public String getMsg() {
                return customMsg;
            }
        };
    }
}
