package com.open.mall.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TokenTypeEnum
 *
 * @author zhoug
 * @date 2025/8/26 11:56
 */

@AllArgsConstructor
@Getter
public enum TokenTypeEnum {

    REFRESH_TOKEN("refresh", 60 * 60 * 24 * 7,"刷新token"),
    ACCESS_TOKEN("access", 60 * 60 * 24,"认证token");

    private final String type;
    private final long expires;
    private final String desc;

}
