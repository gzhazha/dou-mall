package com.open.mall.auth.utils;

import cn.hutool.core.util.IdUtil;
import com.open.mall.api.auth.domain.bo.UserInfoInTokenBo;
import com.open.mall.api.auth.domain.vo.TokenInfoVo;
import com.open.mall.auth.dao.manager.RefreshTokenManager;
import com.open.mall.auth.domain.bo.TokenInfoBo;
import com.open.mall.auth.enums.TokenType;
import com.open.mall.common.base.enums.AuthError;
import com.open.mall.common.base.utils.MallAssert;
import com.open.mall.common.cache.constant.AuthCacheName;
import com.open.mall.common.cache.utils.RedisUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Base64;
import java.util.Objects;

/**
 * 增强版Token工具类（包含刷新Token机制）
 * 支持配置化参数和分布式缓存
 */
@Slf4j
@Component
public class TokenUtil {

    private static RefreshTokenManager refreshTokenManager;

    @Autowired
    public TokenUtil(RefreshTokenManager refreshTokenManager) {
        TokenUtil.refreshTokenManager = refreshTokenManager;
    }

    /**
     * 生成访问Token和刷新Token对
     *
     * @param userId 用户ID
     * @return 包含accessToken和refreshToken的Map
     */
    private static TokenInfoVo generateToken(Long userId) {
        // 生成访问Token
        String accessToken = generateAccessToken(userId);

        // 生成刷新Token
        String refreshToken = generateRefreshToken(userId);

        TokenInfoVo tokenInfoVo = new TokenInfoVo();
        tokenInfoVo.setAccessToken(accessToken);
        tokenInfoVo.setRefreshToken(refreshToken);
        tokenInfoVo.setAccessExpiresIn(TokenType.ACCESS_TOKEN.getExpireTime());
        tokenInfoVo.setRefreshExpiresIn(TokenType.REFRESH_TOKEN.getExpireTime());

        return tokenInfoVo;
    }

    public static TokenInfoVo generateToken(Long userId,boolean isTemporary) {
        if (isTemporary) {
            return generateTempToken(userId);
        }
        return generateToken(userId);
    }

    private static TokenInfoVo generateTempToken(Long userId) {
        String tempToken = generateTemporaryToken(userId);

        TokenInfoVo tokenInfoVo = new TokenInfoVo();
        tokenInfoVo.setAccessToken(tempToken);
        tokenInfoVo.setAccessExpiresIn(TokenType.TEMPORARY_TOKEN.getExpireTime());

        return tokenInfoVo;
    }

    /**
     * 生成临时Token
     */
    private static String generateTemporaryToken(Long userId) {
        return generateToken(userId, TokenType.TEMPORARY_TOKEN);
    }
    /**
     * 生成访问Token
     */
    private static String generateAccessToken(Long userId) {
        return generateToken(userId, TokenType.ACCESS_TOKEN);
    }

    /**
     * 生成刷新Token
     */
    private static String generateRefreshToken(Long userId) {
        return generateToken(userId, TokenType.REFRESH_TOKEN);
    }

    /**
     * 生成Token
     *
     * @param userId         用户ID
     * @param tokenType token类型
     * @return Token字符串
     */
    private static String generateToken(Long userId,TokenType tokenType) {
        // 生成唯一标识
        String tokenId = IdUtil.simpleUUID();

        // 计算过期时间戳
        long expireTime = tokenType.getExpireTime();
        long expireAt = Instant.now().getEpochSecond() + expireTime;
        // 生成签名
        String signature = calculateHmacSignature(tokenId, userId, expireAt,tokenType);

        // 组合Token
        String token = tokenId + "." + userId + "." + expireAt + "." + tokenType.getType()+"." + signature;

        // 存储Token信息
        if (Objects.equals(tokenType,TokenType.REFRESH_TOKEN)) {
            refreshTokenManager.storeRefreshToken(tokenId,userId,"",expireTime);
        }else {
            TokenInfoBo tokenInfoBo = new TokenInfoBo(tokenId,userId);
            RedisUtil.set(buildAccessTokenKey(tokenId), tokenInfoBo, expireTime);
        }
        return Base64.getEncoder().encodeToString(token.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 验证访问Token
     */
    public static UserInfoInTokenBo verifyAccessToken(String token) {
        TokenVerifyResult result = verifyToken(token, TokenType.ACCESS_TOKEN);
        MallAssert.isTrue(result.isValid(), AuthError.ACCESS_CODE_LOGIN_ERROR);
        UserInfoInTokenBo userInfoInTokenBo = new UserInfoInTokenBo();
        userInfoInTokenBo.setToken(token);
        userInfoInTokenBo.setUserId(result.getUserId());
        return userInfoInTokenBo;
    }

    /**
     * 验证刷新Token
     */
    private static TokenVerifyResult verifyRefreshToken(String token) {
        return verifyToken(token, TokenType.REFRESH_TOKEN);
    }

    /**
     * 验证Token
     *
     * @param token          Token字符串
     * @param tokenType Token类型
     * @return 验证结果和用户ID
     */
    private static TokenVerifyResult verifyToken(String token, TokenType tokenType) {
        TokenVerifyResult result = new TokenVerifyResult();
        result.setValid(false);

        try {
            // Base64解码
            String decodedToken = new String(Base64.getDecoder().decode(token), StandardCharsets.UTF_8);
            String[] parts = decodedToken.split("\\.");

            if (parts.length != 4) {
                return result;
            }

            String tokenId = parts[0];
            Long userId = Long.parseLong(parts[1]);
            long expireAt = Long.parseLong(parts[2]);
            String signature = parts[3];

            // 检查是否过期
            if (Instant.now().getEpochSecond() > expireAt) {
                invalidateToken(token, tokenType);
                return result;
            }

            // 验证签名
            String calculatedSignature = calculateHmacSignature(tokenId, userId, expireAt,tokenType);
            if (!signature.equals(calculatedSignature)) {
                return result;
            }

            // 检查Token是否在存储中
            boolean tokenValid = false;

            if (Objects.equals(tokenType,TokenType.REFRESH_TOKEN)) {
                refreshTokenManager.getRefreshToken(tokenId)
                        .ifPresent(refreshToken ->
                                result.setValid(Objects.equals(userId, refreshToken.getUserId())));
            } else {
                TokenInfoBo tokenInfoBo = RedisUtil.get(buildAccessTokenKey(tokenId));
                result.setValid(tokenInfoBo != null && Objects.equals(tokenInfoBo.getUserID(), userId));
            }

            if (!tokenValid) {
                return result;
            }

            // 验证通过
            result.setValid(true);
            result.setUserId(userId);
            result.setTokenId(tokenId);
            return result;

        } catch (Exception e) {
            return result;
        }
    }

    /**
     * 使用刷新Token获取新的访问Token
     *
     * @param refreshToken 刷新Token
     * @return 新的访问Token和刷新Token对
     */
    public static TokenInfoVo refreshAccessToken(String refreshToken) {
        TokenVerifyResult  result= verifyRefreshToken(refreshToken);
        MallAssert.isTrue(result.isValid(), AuthError.REFRESH_CODE_LOGIN_ERROR);

        // 移除旧的刷新Token
        invalidateToken(result.getTokenId(), TokenType.REFRESH_TOKEN);

        // 生成新的Token对
        return generateToken(result.getUserId());
    }

    /**
     * 使Token失效
     *
     * @param token          Token字符串
     * @param tokenType Token类型
     */
    public static void invalidateToken(String token,TokenType tokenType) {
        try {
            String decodedToken = new String(Base64.getDecoder().decode(token), StandardCharsets.UTF_8);
            String tokenId = decodedToken.split("\\.")[0];
            if (Objects.equals(tokenType,TokenType.REFRESH_TOKEN)) {
                refreshTokenManager.deleteRefreshToken(tokenId);
            }else {
                RedisUtil.delete(buildAccessTokenKey(tokenId));
            }
        } catch (Exception e) {
            log.error("invalidateToken error", e);
        }
    }

    /**
     * 使用HMAC算法计算签名
     */
    private static String calculateHmacSignature(String tokenId, Long userId, long expireAt, TokenType tokenType) {
        try {
            String data = tokenId + userId + expireAt+tokenType;
            SecretKey secretKey = new SecretKeySpec(
                    tokenType.getSecretKey().getBytes(StandardCharsets.UTF_8),
                    tokenType.getAlgorithm()
            );

            Mac mac = Mac.getInstance(tokenType.getAlgorithm());
            mac.init(secretKey);
            byte[] hmacData = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(hmacData);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Failed to calculate signature", e);
        }
    }

    private static String buildAccessTokenKey(String tokenId) {
        return AuthCacheName.ACCESS_TOKEN_PREFIX + tokenId;
    }

    @Data
    private static class TokenVerifyResult{
        private boolean isValid;
        private Long userId;
        private String tokenId;
    }
}