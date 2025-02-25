package com.dou.mall.auth.manager;

import cn.hutool.core.util.StrUtil;
import com.dou.mall.api.auth.vo.TokenInfoVo;
import com.dou.mall.auth.mapper.RefreshTokenMapper;
import com.dou.mall.auth.model.bo.AuthAccountBo;
import com.dou.mall.auth.model.entity.RefreshToken;
import com.dou.mall.common.cache.constants.AuthRedisConstants;
import com.google.common.collect.Lists;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;


/**
 * TokenManager
 *
 * @author zhoug
 * @date 2025/2/20 18:22
 */

@RequiredArgsConstructor
@Component
public class TokenManager {

    private final RedisTemplate<String, Object> redisTemplate;
    private final StringRedisTemplate stringRedisTemplate;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final RedisSerializer<Object> redisSerializer;
    private final RefreshTokenMapper refreshTokenMapper;

    private final static Random TOKEN_RANDOM = new Random();

    public TokenInfoVo createAndStoreToken(AuthAccountBo authAccountBo, int type) {
        Long uid = authAccountBo.getUid();
        String refreshToken = gnRefreshToken(authAccountBo);
        String authToken = gnAuthToken(authAccountBo);
        LocalDateTime now = LocalDateTime.now();
        Long refreshExpiredAt = getRefreshExpiredAt(now);
        Long tokenExpiredAt = getTokenExpiredAt(now);
        RefreshToken refreshInfo = new RefreshToken();
        refreshInfo.setUid(uid);
        refreshInfo.setSysType(authAccountBo.getSysType());
        refreshInfo.setAuthType(type);
        refreshInfo.setRefreshToken(refreshToken);
        refreshInfo.setAuthToken(authToken);
        refreshInfo.setCount(1);
        refreshTokenMapper.insert(refreshInfo);
        String uidKey = buildUidKey(uid);
        String tkKey = buildTokenKey(authToken);
        String uidValue = refreshToken + StrUtil.COLON + authToken;
        List<String> allTokenList = Lists.newArrayList();
        allTokenList.add(uidValue);
        Long size = redisTemplate.opsForSet().size(uidKey);
        if (size != null && size > 0) {
            List<String> tokens = stringRedisTemplate.opsForSet().pop(uidKey, size);
            if (tokens != null && !tokens.isEmpty()) {
                tokens.forEach(t -> {
                    String[] split = t.split(StrUtil.COLON);
                    String s = split[0];
                    if(BooleanUtils.isTrue(redisTemplate.hasKey(s))){
                        allTokenList.add(t);
                    }
                });
            }
        }
        redisTemplate.executePipelined((RedisCallback<?>) connection->{
            byte[] uidKeyBytes = uidKey.getBytes(StandardCharsets.UTF_8);
            byte[] tkKeyBytes = tkKey.getBytes(StandardCharsets.UTF_8);
            byte[][] array = allTokenList.stream().map(s -> s.getBytes(StandardCharsets.UTF_8)).toArray(byte[][]::new);
            connection.setCommands().sAdd(uidKeyBytes, array);
            connection.keyCommands().expire(uidKeyBytes,tokenExpiredAt);
            connection.stringCommands().setEx(tkKeyBytes,tokenExpiredAt, Objects.requireNonNull(redisSerializer.serialize(authAccountBo)));
            return null;
        });
        TokenInfoVo tokenInfoVo = new TokenInfoVo();
        tokenInfoVo.setUid(authAccountBo.getUid());
        tokenInfoVo.setUserId(authAccountBo.getUserId());
        tokenInfoVo.setAuthToken(authToken);
        tokenInfoVo.setRefreshToken(refreshToken);
        tokenInfoVo.setRefreshExpireAt(refreshExpiredAt);
        tokenInfoVo.setAuthExpireAt(tokenExpiredAt);
        return tokenInfoVo;
    }

    private String buildTokenKey(String authToken) {
        return AuthRedisConstants.AUTH_TOKEN_CODE_PREFIX + authToken;
    }

    private String buildUidKey(Long uid) {
        return AuthRedisConstants.AUTH_TOKEN_UID_CODE_PREFIX + uid;
    }

    /**
     * 生成刷新token
     *
     * @param authAccount {@link AuthAccountBo}
     * @return {@link String}
     */
    public String gnRefreshToken(AuthAccountBo authAccount) {
        String s = authAccount.getUid().toString() + System.currentTimeMillis() + TOKEN_RANDOM.nextInt(100);
        return DigestUtils.md5Hex(s).toUpperCase();
    }

    /**
     * 生成authToken
     *
     * @param authAccount {@link AuthAccountBo}
     * @return {@link String}
     */
    public String gnAuthToken(AuthAccountBo authAccount) {
        String s = authAccount.getUid().toString() + System.currentTimeMillis() + TOKEN_RANDOM.nextInt(100);
        return DigestUtils.md5Hex(s).toUpperCase();
    }


    /**
     * 获取刷新token过期时间
     *
     * @param localDateTime {@link LocalDateTime} 当前时间
     * @return {@link Long} 到期时间戳
     */
    private Long getRefreshExpiredAt(LocalDateTime localDateTime) {
        return localDateTime.plusMonths(1).toInstant(ZoneOffset.of(ZoneId.systemDefault().getId())).toEpochMilli();
    }

    /**
     * 获取token过期时间
     *
     * @param localDateTime {@link LocalDateTime}
     * @return {@link Long}
     */
    private Long getTokenExpiredAt(LocalDateTime localDateTime) {
        return localDateTime.plusDays(1).toInstant(ZoneOffset.of(ZoneId.systemDefault().getId())).toEpochMilli();
    }

    public boolean checkToken(String authToken) {
        if (StringUtils.isBlank(authToken)) {
            return false;
        }
        return BooleanUtils.isTrue(redisTemplate.hasKey(buildTokenKey(authToken)));
    }

}
