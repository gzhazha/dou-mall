package com.dou.mall.auth.model.bo;

import lombok.Data;

/**
 * VerifyCodeBo
 *
 * @author zhoug
 * @date 2025/2/24 15:46
 */


@Data
public class VerifyCodeBo {
    /** 验证码 */
    private String code;
    /** 验证次数 */
    private Integer count;
}
