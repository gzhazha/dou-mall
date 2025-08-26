package com.open.mall.common.base.enums.auth;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * AuthTypeEnum
 *
 * @author zhoug
 * @date 2025/8/26 09:22
 */

@Getter
@AllArgsConstructor
public enum AuthTypeEnum {

    PASSWORD("password", "密码认证"),
    SMS("sms", "短信验证码认证"),
    EMAIL("email", "邮箱认证"),
    OAUTH("oauth", "第三方OAuth认证");

    private static final Map<String, AuthTypeEnum> TYPE_ENUM_MAP = Arrays.stream(AuthTypeEnum.values()).collect(Collectors.toMap(AuthTypeEnum::getType, Function.identity()));
    private static final Set<AuthTypeEnum> DIRECTLY_LIST = Sets.newHashSet(OAUTH, SMS, EMAIL);

    private final String type;
    private final String desc;

    public static AuthTypeEnum getByType(String type) {
        return TYPE_ENUM_MAP.get(type);
    }

    public static boolean isDirectly(AuthTypeEnum authTypeEnum) {
        return DIRECTLY_LIST.contains(authTypeEnum);
    }
}
