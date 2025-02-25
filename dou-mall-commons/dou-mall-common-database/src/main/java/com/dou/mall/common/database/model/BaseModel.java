package com.dou.mall.common.database.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BaseModel
 *
 * @author zhoug
 * @date 2025/2/17 15:26
 */

@Data
public class BaseModel implements Serializable {
    /**
     * 创建时间
     */
    protected LocalDateTime createTime;
    /**
     * 更新时间
     */
    protected LocalDateTime updateTime;
}
