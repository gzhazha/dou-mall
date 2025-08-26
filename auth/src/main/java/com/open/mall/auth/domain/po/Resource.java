package com.open.mall.auth.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName resource
 */
@TableName(value ="resource")
@Data
public class Resource implements Serializable {
    /**
     * 资源ID
     */
    @TableId(value = "resource_id", type = IdType.AUTO)
    private Long resourceId;

    /**
     * 资源类型: api/menu/button
     */
    @TableField(value = "resource_type")
    private String resourceType;

    /**
     * 资源唯一标识
     */
    @TableField(value = "resource_key")
    private String resourceKey;

    /**
     * 资源路径: URL/菜单路由/按钮ID
     */
    @TableField(value = "resource_path")
    private String resourcePath;

    /**
     * 
     */
    @TableField(value = "desc")
    private String desc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}