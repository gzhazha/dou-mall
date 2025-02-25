package com.dou.mall.auth.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 * @TableName auth_account
 */
@Table(name="auth_account")
@Data
public class AuthAccount implements Serializable {
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
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建ip
     */
    @Column(name = "create_ip")
    private String createIp;

    /**
     * 状态，状态 1:启用 0:禁用 -1:删除
     */
    private Integer status;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户类型见SysTypeEnum 0.普通用户系统 1.商家端 2平台端
     */
    @Column(name = "sys_type")
    private Integer sysType;

    /**
     * 来源
     */
    private Integer source;

    /**
     * 所属租户
     */
    @Column(name = "tenant_id")
    private Long tenantId;

    /**
     * 是否是管理员 1:是 0:不是
     */
    @Column(name = "is_admin")
    private Integer isAdmin;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}