package com.open.mall.auth.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName permission_resource
 */
@TableName(value ="permission_resource")
@Data
public class PermissionResource implements Serializable {
    /**
     * 权限资源ID
     */
    @TableId(value = "permission_resource_id", type = IdType.AUTO)
    private Long permissionResourceId;

    /**
     * 
     */
    @TableField(value = "perm_id")
    private Long permId;

    /**
     * 
     */
    @TableField(value = "resource_id")
    private Long resourceId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}