package com.open.mall.leaf.controller;

import com.open.mall.api.leaf.feign.SegmentFeignClient;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.leaf.common.Result;
import com.open.mall.leaf.common.Status;
import com.open.mall.leaf.exception.LeafServerException;
import com.open.mall.leaf.exception.NoKeyException;
import com.open.mall.leaf.service.SegmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@Slf4j
@RequiredArgsConstructor
@RestController
public class SegmentFeignController implements SegmentFeignClient {

	private final SegmentService segmentService;

	@Override
	public BaseResult<Long> getSegmentId(String key) {
		return BaseResult.success(get(key, segmentService.getId(key)));
	}


	private Long get(String key, Result id) {
		Result result;
		if (key == null || key.isEmpty()) {
			throw new NoKeyException();
		}
		result = id;
		if (Objects.equals(result.getStatus(), Status.EXCEPTION)) {
			throw new LeafServerException(result.toString());
		}
		return result.getId();
	}
}
