package com.open.mall.auth.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 验证码状态VO
 * 用于返回验证码的状态信息，包括是否存在、剩余有效时间、是否可以重新发送等
 *
 * @author zhoug
 * @date 2025/5/10 15:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "验证码状态信息")
public class CaptchaStatusVo {
    
    @Schema(description = "是否存在有效的验证码")
    private Boolean hasCaptcha;
    
    @Schema(description = "验证码剩余有效时间（秒）")
    private Long captchaExpireTime;
    
    @Schema(description = "是否可以重新发送验证码")
    private Boolean canResend;
    
    @Schema(description = "重新发送需等待时间（秒）")
    private Long resendWaitTime;
    
    @Schema(description = "今日已发送次数")
    private Integer dailySentCount;
    
    @Schema(description = "今日剩余可发送次数")
    private Integer dailyRemainCount;
}