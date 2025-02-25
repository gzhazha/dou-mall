package com.dou.mall.auth.model.vo;

import com.dou.mall.api.auth.bo.AuthUserInfoBo;
import com.dou.mall.api.auth.vo.TokenInfoVo;
import lombok.Data;

/**
 * TokenInfoVo
 *
 * @author zhoug
 * @date 2025/2/19 18:39
 */


@Data
public class LoginInfoVo {
    /** 用户信息 */
    private AuthUserInfoBo authUserInfoBo;
    /** token */
    private TokenInfoVo tokenInfoVo;
}
