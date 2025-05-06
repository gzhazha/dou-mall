package com.open.mall.api.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * CaptchaType
 *
 * @author zhoug
 * @date 2025/4/21 15:40
 */

@AllArgsConstructor
@Getter
public enum CaptchaChannel {
    MOBILE,
    EMAIL,
    ;
}
