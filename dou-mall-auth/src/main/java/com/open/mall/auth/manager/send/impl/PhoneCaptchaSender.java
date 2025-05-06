package com.open.mall.auth.manager.send.impl;

import cn.hutool.core.lang.Validator;
import com.open.mall.api.auth.enums.CaptchaChannel;
import com.open.mall.api.auth.enums.CaptchaType;
import com.open.mall.auth.manager.send.CaptchaSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * PhoneCaptchaSender
 *
 * @author zhoug
 * @date 2025/4/24 14:48
 */
@Slf4j
@Component
public class PhoneCaptchaSender implements CaptchaSender {
    @Override
    public void sendCaptcha(CaptchaType type, String identifier, String captcha) {
        String context = String.format(type.getMsg(), captcha);
        log.info("发送验证码，手机:{},验证码:{},内容:{}", identifier,captcha, context);
    }

    @Override
    public CaptchaChannel getCaptchaChannel() {
        return CaptchaChannel.MOBILE;
    }

    @Override
    public boolean checkIdentifier(String identifier) {
        return Validator.isMobile(identifier);
    }
}
