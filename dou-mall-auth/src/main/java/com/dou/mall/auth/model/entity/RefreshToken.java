package com.dou.mall.auth.model.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 刷新token表
 * @TableName refresh_token
 */
@Table(name="refresh_token")
@Data
public class RefreshToken implements Serializable {
    /**
     * 自增主键
     */
    @Id
    private Long id;

    /**
     * 用户平台id
     */
    private Long uid;

    /**
     * 用户类型见SysTypeEnum 0.普通用户系统 1.商家端 2平台端
     */
    @Column(name = "sys_type")
    private Integer sysType;

    /**
     * 授权方式
     */
    @Column(name = "auth_type")
    private Integer authType;

    /**
     * 刷新token
     */
    @Column(name = "refresh_token")
    private String refreshToken;

    /**
     * 认证token
     */
    @Column(name = "auth_token")
    private String authToken;

    /**
     * 使用次数
     */
    private Integer count;

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

    @Serial
    private static final long serialVersionUID = 1L;
}