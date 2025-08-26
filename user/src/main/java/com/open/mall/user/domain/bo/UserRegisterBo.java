package com.open.mall.user.domain.bo;

import lombok.Data;

import java.util.Date;

/**
 * UserRegisterBo
 *
 * @author zhoug
 * @date 2025/8/25 10:19
 */


@Data
public class UserRegisterBo {


    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像URL
     */
    private String avatarUrl;

    /**
     * 性别: 0=未知,1=男,2=女
     */
    private Integer gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

}
