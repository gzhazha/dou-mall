package com.open.mall.auth.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 权限表
 * @TableName permission
 */
@TableName(value ="permission")
@Data
public class Permission implements Serializable {
    /**
     * 权限ID
     */
    @TableId(value = "perm_id", type = IdType.AUTO)
    private Long permId;

    /**
     * 权限唯一标识
     */
    @TableField(value = "perm_key")
    private String permKey;

    /**
     * 资源类型: api/menu/button
     */
    @TableField(value = "resource_type")
    private String resourceType;

    /**
     * 资源路径: URL/菜单路由/按钮ID
     */
    @TableField(value = "resource_path")
    private String resourcePath;

    /**
     * 描述
     */
    @TableField(value = "desc")
    private String desc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}