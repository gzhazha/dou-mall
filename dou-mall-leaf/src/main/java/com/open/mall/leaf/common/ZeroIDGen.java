package com.open.mall.leaf.common;

import com.open.mall.leaf.IDGen;

/**
 * @author left
 */
public class ZeroIDGen implements IDGen {

	@Override
	public Result get(String key) {
		return new Result(0, Status.SUCCESS);
	}

	@Override
	public boolean init() {
		return true;
	}

}
