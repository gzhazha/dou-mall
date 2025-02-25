package com.dou.mall.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * LoginTypeEnum
 *
 * @author zhoug
 * @date 2025/2/19 18:51
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {

    PHONE_CODE(1, "手机号验证码"),

    ;

    private final int type;
    private final String desc;

    private static final Map<Integer, LoginTypeEnum> MAP = new HashMap<>();

    LoginTypeEnum get(Integer type) {
        if (MAP.isEmpty()) {
            for (LoginTypeEnum value : LoginTypeEnum.values()) {
                MAP.put(value.getType(), value);
            }
        }
        return MAP.get(type);
    }
}
