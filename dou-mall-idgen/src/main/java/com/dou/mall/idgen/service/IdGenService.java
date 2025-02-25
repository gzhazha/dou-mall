package com.dou.mall.idgen.service;


/**
 * IdGenService
 *
 * @author zhoug
 * @date 2025/2/18 16:20
 */


public interface IdGenService {
    /**
     * 分布式id生成
     * @param key 生成id的Key
     * @return id {@link Long}
     */
    Long buildId(String key);
}
