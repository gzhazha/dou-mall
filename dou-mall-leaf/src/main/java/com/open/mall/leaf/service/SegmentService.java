package com.open.mall.leaf.service;

import com.open.mall.leaf.IDGen;
import com.open.mall.leaf.common.Result;
import com.open.mall.leaf.exception.InitException;
import com.open.mall.leaf.segment.SegmentIDGenImpl;
import com.open.mall.leaf.segment.dao.IDAllocManager;
import com.open.mall.leaf.segment.dao.impl.IDAllocManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * @author left
 */
@Slf4j
@Service("SegmentService")
public class SegmentService {


	private final IDGen idGen;

	public SegmentService(DataSource dataSource) throws InitException {
		// Config Dao
		IDAllocManager dao = new IDAllocManagerImpl(dataSource);

		// Config ID Gen
		idGen = new SegmentIDGenImpl();
		((SegmentIDGenImpl) idGen).setDao(dao);
		if (idGen.init()) {
			log.info("Segment Service Init Successfully");
		}
		else {
			throw new InitException("Segment Service Init Fail");
		}

	}

	public Result getId(String key) {
		return idGen.get(key);
	}

	public SegmentIDGenImpl getIdGen() {
		if (idGen instanceof SegmentIDGenImpl) {
			return (SegmentIDGenImpl) idGen;
		}
		return null;
	}

}
