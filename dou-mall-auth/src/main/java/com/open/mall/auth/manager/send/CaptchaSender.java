package com.open.mall.auth.manager.send;

import com.open.mall.api.auth.enums.CaptchaChannel;
import com.open.mall.api.auth.enums.CaptchaType;

/**
 * CaptchaSender
 *
 * @author zhoug
 * @date 2025/4/24 11:28
 */

public interface CaptchaSender {

    void sendCaptcha(CaptchaType type, String identifier, String captcha);

    default boolean supported(CaptchaChannel channel) {
        return getCaptchaChannel().equals(channel);
    }

    CaptchaChannel getCaptchaChannel();

    boolean checkIdentifier(String identifier);
}
