package com.dou.mall.auth.strategy.login;

import com.dou.mall.api.auth.enums.SysTypeEnum;
import com.dou.mall.auth.enums.AuthErrorEnum;
import com.dou.mall.auth.mapper.AuthAccountMapper;
import com.dou.mall.auth.model.bo.AuthAccountBo;
import com.dou.mall.auth.model.bo.VerifyCodeBo;
import com.dou.mall.auth.model.dto.LoginDto;
import com.dou.mall.auth.enums.LoginTypeEnum;
import com.dou.mall.common.base.exception.DouMallException;
import com.dou.mall.common.cache.constants.AuthRedisConstants;
import com.dou.mall.common.cache.utils.RedisUtil;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * LoginWithPhoneAndCodeStrategy
 *
 * @author zhoug
 * @date 2025/2/20 10:42
 */

@Component
public class LoginWithPhoneAndCodeStrategy extends AbstractLoginStrategy {

    @Resource
    private AuthAccountMapper authAccountMapper;

    @Override
    public AuthAccountBo checkLogin(LoginDto loginDto) {
        checkLoginDto(loginDto);
        String phone = loginDto.getPhone();
        String code = loginDto.getCode();
        String key = AuthRedisConstants.AUTH_VERIFY_PHONE_CODE + phone;
        VerifyCodeBo verifyCodeBo = RedisUtil.get(key);
        if (verifyCodeBo == null || !StringUtils.equals(code, verifyCodeBo.getCode())) {
            throw new DouMallException(AuthErrorEnum.VERIFY_CODE_ERROR);
        }
        if (verifyCodeBo.getCount() == null || verifyCodeBo.getCount() >= 5) {
            throw new DouMallException(AuthErrorEnum.VERIFY_CODE_FAILURE);
        }
        AuthAccountBo authAccountBo = authAccountMapper.selectAuthAccountBoByPhoneAndSysType(loginDto.getPhone(),loginDto.getSysType());
        if (authAccountBo == null) {
            throw new DouMallException(AuthErrorEnum.INVALID_AUTH_USER);
        }
        return authAccountBo;
    }

    /**
     * 构建手机验证码key
     *
     * @param phone {@link String}
     * @return {@link String}
     */
    private String buildVerifyCodeKey(String phone) {
        return null;
    }

    private void checkLoginDto(LoginDto loginDto) {
        if (StringUtils.isBlank(loginDto.getPhone())) {
            throw new DouMallException(AuthErrorEnum.INVALID_LOGIN_PARAM, "手机号格式错误");
        }
        if (StringUtils.isBlank(loginDto.getCode())) {
            throw new DouMallException(AuthErrorEnum.INVALID_LOGIN_PARAM, "验证码格式错误");
        }
        if (SysTypeEnum.getEnum(loginDto.getSysType()) == null) {
            throw new DouMallException(AuthErrorEnum.INVALID_LOGIN_PARAM, "系统类型错误");
        }
    }

    @Override
    public LoginTypeEnum getLoginTypeEnum() {
        return LoginTypeEnum.PHONE_CODE;
    }
}
