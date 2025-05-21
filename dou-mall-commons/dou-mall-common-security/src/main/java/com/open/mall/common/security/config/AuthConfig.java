package com.open.mall.common.security.config;

import cn.hutool.core.util.ArrayUtil;
import com.open.mall.api.auth.feign.AuthFeignClient;
import com.open.mall.common.feign.config.FeignAutoConfiguration;
import com.open.mall.common.security.adapter.AuthPathAdapter;
import com.open.mall.common.security.adapter.DefaultAuthPathAdapter;
import com.open.mall.common.security.filter.AuthFilter;
import jakarta.servlet.DispatcherType;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * 授权配置
 *
 * @author FrozenWatermelon
 * @date 2020/7/11
 */
@AutoConfiguration
@AutoConfigureAfter({FeignAutoConfiguration.class})
public class AuthConfig {

	@Bean
	@ConditionalOnMissingBean
	public AuthPathAdapter authPathAdapter() {
		return new DefaultAuthPathAdapter();
	}

    @Bean
    public AuthFilter authFilter(AuthPathAdapter authPathAdapter, AuthFeignClient authFeignClient) {
        return new AuthFilter(authPathAdapter, authFeignClient);
    }

	@Bean
	@Lazy
	public FilterRegistrationBean<AuthFilter> filterRegistration(AuthPathAdapter authConfigAdapter, AuthFilter authFilter) {
		FilterRegistrationBean<AuthFilter> registration = new FilterRegistrationBean<>();
		// 添加过滤器
		registration.setFilter(authFilter);
		// 设置过滤路径，/*所有路径
		registration.addUrlPatterns(ArrayUtil.toArray(authConfigAdapter.getRequiresAuthorizationPaths(), String.class));
		registration.setName("authFilter");
		// 设置优先级
		registration.setOrder(0);
		registration.setDispatcherTypes(DispatcherType.REQUEST);
		return registration;
	}

}
