package com.dou.mall.api.auth.bo;

import lombok.Data;

/**
 * AuthInfoBo
 *
 * @author zhoug
 * @date 2025/2/18 15:46
 */


@Data
public class AuthUserInfoBo {
    /** 平台id */
    private Long uid;
    /** 用户id */
    private Long userId;
    /** 租户id */
    private Long tenantId;
    /** 是否是管理员 1：是  0：否 */
    private Integer isAdmin;
    /** 系统类型用户类型见{@link com.dou.mall.api.auth.enums.SysTypeEnum} 0.普通用户系统 1.商家端 2平台端 */
    private Integer sysType;
}
