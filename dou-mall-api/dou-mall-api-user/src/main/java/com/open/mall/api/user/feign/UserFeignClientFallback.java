package com.open.mall.api.user.feign;

import com.open.mall.api.user.domain.bo.UserInfoBo;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.common.base.enums.SystemError;

/**
 * UserFeignClientFallback
 *
 * @author zhoug
 * @date 2025/5/22 16:46
 */

public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public BaseResult<UserInfoBo> getUserInfoByMobile(String mobile) {
        return BaseResult.failure(SystemError.SYSTEM_ERROR);
    }

    @Override
    public BaseResult<UserInfoBo> getUserInfoByEmail(String email) {
        return BaseResult.failure(SystemError.SYSTEM_ERROR);
    }

    @Override
    public BaseResult<UserInfoBo> getUserInfoByUsername(String username) {
        return BaseResult.failure(SystemError.SYSTEM_ERROR);
    }
}
