package com.open.mall.common.security.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
  * DefaultAuthPathAdapter
  *
  * @author zhoug
  * @date 2025/5/20 09:53
  */

@Component
@Slf4j
public class DefaultAuthPathAdapter extends AbsAuthPathAdapter{
    public DefaultAuthPathAdapter() {
        log.info("DefaultAuthPathAdapter init ......");
    }

    @Override
    protected List<String> addNoAuthorizationPaths() {
        return List.of();
    }
}
