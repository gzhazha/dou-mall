package com.dou.mall.idgen.service.impl;

import com.dou.mall.idgen.service.IdGenService;
import com.dou.mall.idgen.utils.SnowflakeKeyGenerator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * IdGenServiceImpl
 *
 * @author zhoug
 * @date 2025/2/18 16:22
 */

@Service
public class IdGenServiceImpl implements IdGenService {

    @Resource
    private SnowflakeKeyGenerator snowflakeKeyGenerator;

    @Override
    public Long buildId(String key) {
        // todo 2025-02-18 后续完善分布式id生成，基于雪花算法，解决WORKER_ID、时间回拨的问题
        return snowflakeKeyGenerator.generateKey();
    }
}
