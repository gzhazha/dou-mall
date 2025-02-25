package com.dou.mall.auth.model.bo;

import jakarta.persistence.Id;
import lombok.Data;

/**
 * AuthAccountBo
 *
 * @author zhoug
 * @date 2025/2/24 23:06
 */


@Data
public class AuthAccountBo {
    /**
     * 平台用户标识
     */
    @Id
    private Long uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态，状态 1:启用 0:禁用 -1:删除
     */
    private Integer status;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户类型见SysTypeEnum 0.普通用户系统 1.商家端 2平台端
     */
    private Integer sysType;

    /**
     * 来源
     */
    private Integer source;

    /**
     * 所属租户
     */
    private Long tenantId;

    /**
     * 是否是管理员 1:是 0:不是
     */
    private Integer isAdmin;
}
