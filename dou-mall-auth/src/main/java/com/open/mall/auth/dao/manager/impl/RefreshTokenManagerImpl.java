package com.open.mall.auth.dao.manager.impl;

import cn.hutool.crypto.SecureUtil;
import com.open.mall.auth.dao.manager.RefreshTokenManager;
import com.open.mall.auth.dao.mapper.RefreshTokenMapper;
import com.open.mall.auth.domain.po.RefreshToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;


/**
 * RefreshTokenManager
 *
 * @author zhoug
 * @date 2025/4/29 11:02
 */

@Slf4j
@RequiredArgsConstructor
@Component
public class RefreshTokenManagerImpl implements RefreshTokenManager {
    private final RefreshTokenMapper refreshTokenMapper;

    public void storeRefreshToken(String token, Long userId, String ipAddress, long expireTime) {
        Date issuedAt = new Date();
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setTokenHash(buildTokenHash(token));
        refreshToken.setUserId(userId);
        refreshToken.setIpAddress(ipAddress);
        refreshToken.setIssuedAt(issuedAt);
        refreshToken.setExpiresAt(DateUtils.addMilliseconds(issuedAt, (int) expireTime));
        refreshToken.setRevoked(0);
        refreshTokenMapper.insert(refreshToken);
    }

    public Optional<RefreshToken> getRefreshToken(String token) {
        return Optional.ofNullable(refreshTokenMapper.selectById(buildTokenHash(token)));
    }

    public void deleteRefreshToken(String token) {
        refreshTokenMapper.deleteById(buildTokenHash(token));
    }

    private String buildTokenHash(String token) {
        return SecureUtil.md5(token);
    }
}
