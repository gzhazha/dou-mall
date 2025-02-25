package com.dou.mall.auth.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 * @TableName platform_info
 */
@Table(name="platform_info")
@Data
public class PlatformInfo implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 平台唯一id
     */
    private Long uid;

    /**
     * 第三方平台标识
     */
    private Integer platform;

    /**
     * 第三方平台id
     */
    private String openid;

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