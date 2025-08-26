package com.open.mall.auth.manager.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.open.mall.auth.domain.po.AuthToken;
import com.open.mall.auth.domain.po.RefreshToken;
import com.open.mall.auth.enums.TokenTypeEnum;
import com.open.mall.auth.manager.TokenManager;
import com.open.mall.auth.mapper.AuthTokenMapper;
import com.open.mall.auth.mapper.RefreshTokenMapper;
import com.open.mall.auth.utils.TokenUtils;
import com.open.mall.common.base.enums.CommonCodeEnum;
import com.open.mall.common.base.enums.auth.AuthTypeEnum;
import com.open.mall.common.base.utils.DouAssertion;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;



/**
 * TokenManagerImpl
 *
 * @author zhoug
 * @date 2025/8/26 16:08
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class TokenManagerImpl implements TokenManager {

    private final AuthTokenMapper authTokenMapper;
    private final RefreshTokenMapper refreshTokenMapper;

    @Override
    public RefreshToken createRefreshToken(Long userId, String authCode, AuthTypeEnum authTypeEnum) {
        DouAssertion.notNull(userId);
        String code = TokenUtils.buildRefreshTokenCode(userId);
        LocalDateTime now = LocalDateTime.now();
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUserId(userId);
        refreshToken.setAuthType(authTypeEnum.getType());
        refreshToken.setAuthCode(authCode);
        refreshToken.setRefreshToken(code);
        refreshToken.setDeviceId("");
        refreshToken.setIpAddress("");
        refreshToken.setExpiredAt(now.plusSeconds(TokenTypeEnum.REFRESH_TOKEN.getExpires()));
        refreshToken.setCreatedAt(now);
        refreshToken.setUpdatedAt(now);
        refreshTokenMapper.insert(refreshToken);
        return refreshToken;
    }

    @Override
    public AuthToken createAuthToken(String refreshCode) {
        RefreshToken refreshToken = refreshTokenMapper.selectOne(Wrappers.<RefreshToken>lambdaQuery().eq(RefreshToken::getRefreshToken, refreshCode));
        DouAssertion.notNull(refreshToken);
        LocalDateTime now = LocalDateTime.now();
        DouAssertion.isTrue(noExpired(refreshToken.getExpiredAt()), CommonCodeEnum.TOKEN_EXPIRED);
        String code = TokenUtils.buildAuthTokenCode(refreshCode);
        AuthToken authToken = new AuthToken();
        authToken.setUserId(refreshToken.getUserId());
        authToken.setRefreshToken(refreshCode);
        authToken.setAccessToken(code);
        authToken.setDeviceId("");
        authToken.setIpAddress("");
        authToken.setExpiredAt(now.plusSeconds(TokenTypeEnum.ACCESS_TOKEN.getExpires()));
        authToken.setCreatedAt(now);
        authToken.setUpdatedAt(now);
        authTokenMapper.insert(authToken);
        return authToken;
    }

    private static boolean noExpired(LocalDateTime expiredAt) {
        if (expiredAt == null) {
            return false;
        }
        return expiredAt.isBefore(LocalDateTime.now());
    }
}
