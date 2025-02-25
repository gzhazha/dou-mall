package com.dou.mall.auth.model.dto;

import lombok.Data;

/**
 * LoginDto
 *
 * @author zhoug
 * @date 2025/2/19 18:39
 */


@Data
public class LoginDto {
    /** 登录方式 {@link com.dou.mall.auth.enums.LoginTypeEnum} */
    private Integer loginType;
    /** 手机号 */
    private String phone;
    /** 验证码 */
    private String code;
    /** 系统类型 {@link com.dou.mall.api.auth.enums.SysTypeEnum} */
    private Integer sysType;
}
