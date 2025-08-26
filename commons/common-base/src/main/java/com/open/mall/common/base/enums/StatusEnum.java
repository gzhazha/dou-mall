package com.open.mall.common.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * StatusEnum 状态
 * 定义与业务无关的通用状态码和错误信息
 *
 * @author zhoug
 * @date 2025/8/22 18:50
 */

@AllArgsConstructor
@Getter
public enum StatusEnum {

    VALID(1, "有效"),
    DISABLED(0, "禁用"),
    ;

    private final Integer status;
    private final String desc;

    public static boolean isValid(Integer status) {
        return VALID.getStatus().equals(status);
    }

}

