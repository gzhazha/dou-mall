package com.open.mall.auth.manager;

import com.open.mall.auth.domain.po.AuthToken;
import com.open.mall.auth.domain.po.RefreshToken;
import com.open.mall.common.base.enums.auth.AuthTypeEnum;

/**
 * TokenManager
 *
 * @author zhoug
 * @date 2025/8/26 16:00
 */

public interface TokenManager {

    RefreshToken createRefreshToken(Long userId, String authCode, AuthTypeEnum authTypeEnum);

    AuthToken createAuthToken(String refreshToken);
}
