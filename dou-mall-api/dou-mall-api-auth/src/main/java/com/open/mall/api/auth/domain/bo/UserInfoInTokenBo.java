package com.open.mall.api.auth.domain.bo;

import lombok.Data;

/**
 * TokenCheckBo
 *
 * @author zhoug
 * @date 2025/4/29 17:30
 */


@Data
public class UserInfoInTokenBo {
    private Long userId;
    private String token;
}
