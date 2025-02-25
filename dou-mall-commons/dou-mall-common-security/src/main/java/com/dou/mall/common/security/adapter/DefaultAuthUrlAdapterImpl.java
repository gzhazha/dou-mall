package com.dou.mall.common.security.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * DefaultAuthUrlAdapterImpl
 *
 * @author zhoug
 * @date 2025/2/17 15:54
 */


public class DefaultAuthUrlAdapterImpl implements AuthUrlAdapter {
    private static final Logger logger = LoggerFactory.getLogger(DefaultAuthUrlAdapterImpl.class);

    public DefaultAuthUrlAdapterImpl() {
        logger.info("DefaultAuthUrlAdapter initialization .......");
    }

    @Override
    public List<String> getPaths() {
        return Collections.singletonList("/*");
    }

    @Override
    public List<String> getWhitePaths() {
        return List.of();
    }
}
