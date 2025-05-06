package com.open.mall.auth.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色与权限的关联
 * @TableName role_permission
 */
@TableName(value ="role_permission")
@Data
public class RolePermission implements Serializable {
    /**
     * 角色ID
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "role_id")
    private Integer roleId;

    /**
     * 权限ID
     */
    @TableField(value = "permission_id")
    private Integer permissionId;

    /**
     * 分配时间
     */
    @TableField(value = "assigned_at")
    private Date assignedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}