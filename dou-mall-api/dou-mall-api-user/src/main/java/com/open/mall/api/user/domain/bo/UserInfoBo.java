package com.open.mall.api.user.domain.bo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * UserInfo
 *
 * @author zhoug
 * @date 2025/4/28 15:42
 */

@Schema(description = "UserInfoBo")
@Data
public class UserInfoBo {

    /**
     * 全局唯一用户ID (UUID格式), 由本服务生成
     */
    @Schema(description = "全局唯一用户ID")
    private Long userId;

    /**
     * 可选的唯一用户名, 可用于登录或显示
     */
    @Schema(description = "唯一用户名")
    private String username;

    /**
     * 唯一电子邮箱地址, 可用于登录、通知、密码重置等
     */
    @Schema(description = "唯一电子邮箱地址, 可用于登录、通知、密码重置等")
    private String email;

    /**
     * 唯一手机号码, 可用于登录、通知、密码重置等
     */
    @Schema(description = "唯一手机号码, 可用于登录、通知、密码重置等")
    private String phoneNumber;

    /**
     * 用户对外显示的昵称
     */
    @Schema(description = "用户对外显示的昵称")
    private String nickname;

    /**
     * 用户头像图片的URL链接
     */
    @Schema(description = "用户头像图片的URL链接")
    private String avatarUrl;

    /**
     * 用户账户状态 (例如:0=初始化/刚注册，只能获取临时token 1=正常/活跃, 2=待验证, 3=已禁用/暂停, 4=已注销/软删除)
     */
    @Schema(description = "用户账户状态 (例如:0=初始化/刚注册，只能获取临时token 1=正常/活跃, 2=待验证, 3=已禁用/暂停, 4=已注销/软删除)")
    private Integer status;


}
