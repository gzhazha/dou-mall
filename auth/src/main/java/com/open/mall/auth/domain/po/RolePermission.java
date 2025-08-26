package com.open.mall.auth.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色与权限关系表
 * @TableName role_permission
 */
@TableName(value ="role_permission")
@Data
public class RolePermission implements Serializable {
    /**
     * 角色权限ID
     */
    @TableId(value = "role_perm_id", type = IdType.AUTO)
    private Long rolePermId;

    /**
     * 
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     * 
     */
    @TableField(value = "perm_id")
    private Long permId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}