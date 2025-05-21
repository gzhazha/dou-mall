package com.open.mall.user.service.impl;

import cn.hutool.core.lang.Validator;
import com.open.mall.api.auth.domain.bo.AuthRegisterBo;
import com.open.mall.api.auth.feign.AuthFeignClient;
import com.open.mall.api.leaf.constants.LeafConstant;
import com.open.mall.api.leaf.feign.SegmentFeignClient;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.common.base.enums.SystemError;
import com.open.mall.common.base.enums.UserError;
import com.open.mall.common.base.exception.MallBaseException;
import com.open.mall.common.base.utils.MallAssert;
import com.open.mall.common.trace.TraceUtil;
import com.open.mall.user.converter.UserBeanConverter;
import com.open.mall.user.dao.mapper.UserInfoMapper;
import com.open.mall.user.domain.dto.ClientRegisterDto;
import com.open.mall.user.domain.po.UserInfo;
import com.open.mall.user.service.RegisterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * RegisterServiceImpl
 *
 * @author zhoug
 * @date 2025/5/20 15:46
 */

@Service
@Slf4j
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserInfoMapper userInfoMapper;
    private final AuthFeignClient authFeignClient;
    private final SegmentFeignClient segmentFeignClient;
    private final UserBeanConverter userBeanConverter;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long registerClient(ClientRegisterDto clientRegisterDto) {
        String traceId = TraceUtil.getTraceId();
        checkClientRegisterDto(clientRegisterDto);
        BaseResult<Long> segmentId = segmentFeignClient.getSegmentId(LeafConstant.AUTH);
        Long id = Optional.ofNullable(segmentId)
                .map(BaseResult::getData)
                .orElseThrow(() -> new MallBaseException(SystemError.SYSTEM_INTERNAL_ERROR1.format("生成id失败")));
        UserInfo userInfo = userBeanConverter.toUserInfo(id, clientRegisterDto);
        MallAssert.isTrue(userInfoMapper.insert(userInfo)>0, UserError.REGISTER_ERROR);
        AuthRegisterBo authRegisterBo = userBeanConverter.toAuthRegisterBo(id,clientRegisterDto);
        BaseResult<Void> result =  authFeignClient.register(authRegisterBo);
        MallAssert.isTrue(result!=null&&result.getSuccess(),UserError.REGISTER_ERROR);
        return id;
    }

    private void checkClientRegisterDto(ClientRegisterDto clientRegisterDto) {
        MallAssert.notNull(clientRegisterDto, "clientRegisterDto must not be null");
        MallAssert.notBlank(clientRegisterDto.getUsername(), "username must not be blank");
        MallAssert.notBlank(clientRegisterDto.getPassword(), "password must not be blank");
        MallAssert.notBlank(clientRegisterDto.getPhoneNumber(), "phoneNumber must not be blank");
        Validator.isMobile(clientRegisterDto.getPhoneNumber());
        if (StringUtils.isNotBlank(clientRegisterDto.getEmail())) {
            Validator.isEmail(clientRegisterDto.getEmail());
        }
    }
}
