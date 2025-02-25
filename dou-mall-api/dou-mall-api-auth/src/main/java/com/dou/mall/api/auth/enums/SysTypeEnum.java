package com.dou.mall.api.auth.enums;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * 系统类型
 */
@AllArgsConstructor
@Getter
public enum SysTypeEnum {

    /**
     * 用户系统
     */
    USER(0, "用户系统"),

    /**
     * 商家
     */
    MERCHANT(1, "商家"),

    /**
     * 平台
     */
    PLATFORM(2, "平台"),

    ;

    private final Integer value;
    private final String desc;

    private static final Map<Integer, SysTypeEnum> MAP = Maps.newHashMap();

    public static SysTypeEnum getEnum(Integer value) {
        if(MAP.isEmpty()){
            for (SysTypeEnum sysTypeEnum : SysTypeEnum.values()) {
                MAP.put(sysTypeEnum.getValue(), sysTypeEnum);
            }
        }
        return MAP.get(value);
    }

}
