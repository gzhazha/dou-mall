package com.open.mall.auth.domain.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TokenInfoBo
 *
 * @author zhoug
 * @date 2025/4/29 10:52
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenInfoBo {
    private String tokenId;
    private Long userID;
}
