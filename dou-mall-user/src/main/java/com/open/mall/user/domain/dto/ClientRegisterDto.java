package com.open.mall.user.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * ClientRegisterDto
 *
 * @author zhoug
 * @date 2025/5/20 15:41
 */


@Schema(description = "客户端注册对象")
@Data
public class ClientRegisterDto {
    /**
     * 用户名，用于账号登录和身份标识
     * 必填字段，需要确保系统内唯一
     */
    @Schema(description = "用户名", example = "zhangsan", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;

    /**
     * 手机号码，用于接收验证码、通知等信息
     * 必填字段，需要符合手机号码格式规范
     */
    @Schema(description = "手机号码", example = "13800138000", requiredMode = Schema.RequiredMode.REQUIRED)
    private String phoneNumber;

    /**
     * 用户密码，用于账号安全验证
     * 必填字段，长度在6-20个字符之间，建议包含字母、数字和特殊字符
     */
    @Schema(description = "密码，长度在6-20个字符之间", example = "password123", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    /**
     * 电子邮箱，用于接收系统通知和密码重置等功能
     * 选填字段，但填写时需要符合邮箱格式规范
     */
    @Schema(description = "电子邮箱", example = "example@email.com")
    private String email;

    /**
     * 用户昵称，用于在系统中展示的用户标识
     * 选填字段，如不填写可使用用户名作为默认昵称
     */
    @Schema(description = "用户昵称", example = "张三")
    private String nickName;
    /**
     * 用户头像
     */
    @Schema(description = "用户头像", example = "http://asdads.com")
    private String avatarUrl;
}
