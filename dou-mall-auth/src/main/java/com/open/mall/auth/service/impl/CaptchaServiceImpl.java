package com.open.mall.auth.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.open.mall.auth.domain.dto.CheckCaptchaDto;
import com.open.mall.auth.domain.dto.SendCaptchaDto;
import com.open.mall.auth.domain.vo.CaptchaStatusVo;
import com.open.mall.api.auth.enums.CaptchaChannel;
import com.open.mall.auth.manager.send.CaptchaSender;
import com.open.mall.auth.service.CaptchaService;
import com.open.mall.auth.utils.CaptchaUtil;
import com.open.mall.common.base.enums.ErrorEnum;
import com.open.mall.common.base.exception.MallBaseException;
import com.open.mall.common.base.utils.MallAssert;
import com.open.mall.common.base.utils.WebUtil;
import com.open.mall.common.cache.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * CaptchaServiceImpl
 *
 * @author zhoug
 * @date 2025/4/17 22:16
 */
@Service
@Slf4j
public class CaptchaServiceImpl implements CaptchaService {

    private final Map<CaptchaChannel, CaptchaSender> captchaSenderMap;

    public CaptchaServiceImpl(List<CaptchaSender> captchaSenderList) {
        if (CollUtil.isEmpty(captchaSenderList)) {
            throw new IllegalArgumentException("未注入验证码发送器");
        }
        captchaSenderMap = captchaSenderList.stream().collect(Collectors.toMap(CaptchaSender::getCaptchaChannel, Function.identity()));
    }


    @Override
    public void sendCaptcha(SendCaptchaDto sendCaptchaDto) {
        // 获取发送渠道
        CaptchaSender sender = Optional.ofNullable(captchaSenderMap.get(sendCaptchaDto.getChannel()))
                .orElseThrow(() -> new MallBaseException(ErrorEnum.ILLEGAL_PARAM, "不支持的发送渠道"));
        
        // 验证标识符格式
        MallAssert.isTrue(sender.checkIdentifier(sendCaptchaDto.getIdentifier()), "identifier格式错误");
        
        String identifier = sendCaptchaDto.getIdentifier();
        // 获取请求IP地址
        String ipAddress = WebUtil.getIpAddress();
        
        // 使用增强的验证码生成方法，包含IP限制和其他安全措施
        String captcha = CaptchaUtil.createAndStoreCaptcha(
                identifier, 
                ipAddress, 
                CaptchaUtil.CAPTCHA_LENGTH_MIN, 
                CaptchaUtil.CaptchaMode.NUMERIC, 
                CaptchaUtil.DEFAULT_EXPIRE_SECONDS);
        
        // 发送验证码
        sender.sendCaptcha(sendCaptchaDto.getType(), sendCaptchaDto.getIdentifier(), captcha);
        
        log.info("验证码已发送，接收者：{}，渠道：{}", identifier, sendCaptchaDto.getChannel());
    }

    @Override
    public void checkCaptcha(CheckCaptchaDto checkCaptchaDto) {
        CaptchaUtil.validateCaptcha(checkCaptchaDto.getIdentifier(), checkCaptchaDto.getCaptcha());
    }

    @Override
    public CaptchaStatusVo getCaptchaStatus(String identifier) {
        MallAssert.isFalse(StringUtils.isBlank(identifier), ErrorEnum.ILLEGAL_PARAM, "标识符不能为空");
        
        // 检查是否存在验证码
        boolean hasCaptcha = CaptchaUtil.hasCaptcha(identifier);
        
        // 获取验证码剩余有效时间
        long captchaExpireTime = CaptchaUtil.getCaptchaExpireTime(identifier);
        
        // 检查是否可以重新发送验证码
        boolean canResend = CaptchaUtil.checkSendRateLimit(identifier);
        
        // 获取重新发送需等待时间
        long resendWaitTime = CaptchaUtil.getRateLimitExpireTime(identifier);
        
        // 获取每日发送次数限制信息
        String dailyLimitKey = CaptchaUtil.buildCaptchaDailyLimitKey(identifier);
        String countStr = RedisUtil.get(dailyLimitKey);
        int dailySentCount = 0;
        if (StringUtils.isNotBlank(countStr)) {
            dailySentCount = Integer.parseInt(countStr);
        }
        
        // 计算剩余可发送次数
        int dailyRemainCount = Math.max(0, CaptchaUtil.DEFAULT_DAILY_LIMIT - dailySentCount);
        
        return CaptchaStatusVo.builder()
                .hasCaptcha(hasCaptcha)
                .captchaExpireTime(captchaExpireTime)
                .canResend(canResend)
                .resendWaitTime(resendWaitTime)
                .dailySentCount(dailySentCount)
                .dailyRemainCount(dailyRemainCount)
                .build();
    }
}
