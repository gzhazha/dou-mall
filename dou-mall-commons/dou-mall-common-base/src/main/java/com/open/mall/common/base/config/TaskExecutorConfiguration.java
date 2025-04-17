package com.open.mall.common.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@AutoConfiguration
public class TaskExecutorConfiguration implements AsyncConfigurer {

	public static final int cpuNum = Runtime.getRuntime().availableProcessors();

	@Value("${thread.pool.corePoolSize:}")
	private Optional<Integer> corePoolSize;

	@Value("${thread.pool.maxPoolSize:}")
	private Optional<Integer> maxPoolSize;

	@Value("${thread.pool.queueCapacity:}")
	private Optional<Integer> queueCapacity;

	@Value("${thread.pool.awaitTerminationSeconds:}")
	private Optional<Integer> awaitTerminationSeconds;

	@Override
	@Bean
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		// 核心线程大小 默认区 CPU 数量
		taskExecutor.setCorePoolSize(corePoolSize.orElse(cpuNum));
		// 最大线程大小 默认区 CPU * 2 数量
		taskExecutor.setMaxPoolSize(maxPoolSize.orElse(cpuNum * 2));
		// 队列最大容量
		taskExecutor.setQueueCapacity(queueCapacity.orElse(500));
		taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		taskExecutor.setAwaitTerminationSeconds(awaitTerminationSeconds.orElse(60));
		taskExecutor.setThreadNamePrefix("Mall-Task-Thread-");
		taskExecutor.initialize();
		return taskExecutor;
	}

}
