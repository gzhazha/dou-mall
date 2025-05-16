package com.open.mall.auth.dao.manager;

import com.open.mall.auth.domain.po.RefreshToken;
import java.util.Optional;


/**
 * RefreshTokenManager
 *
 * @author zhoug
 * @date 2025/4/29 11:02
 */

public interface RefreshTokenManager {

    void storeRefreshToken(String token, Long userId, String ipAddress, long expireTime);

    Optional<RefreshToken> getRefreshToken(String token);

    void deleteRefreshToken(String token);

}
