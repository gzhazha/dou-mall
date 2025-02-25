package com.dou.mall.common.cache.constants;

/**
 * CommonRedisConstants
 *
 * @author zhoug
 * @date 2025/2/24 09:41
 */

public interface CommonRedisConstants {
    String DOU_MALL_PREFIX = "dou_mall:";
    String COMMON_PREFIX = DOU_MALL_PREFIX + "common:";
    String PRODUCT_PREFIX = DOU_MALL_PREFIX + "product:";
    String USER_PREFIX = DOU_MALL_PREFIX + "user:";
    String ORDER_PREFIX = DOU_MALL_PREFIX + "order:";
    String AUTH_PREFIX = DOU_MALL_PREFIX + "auth";
}
