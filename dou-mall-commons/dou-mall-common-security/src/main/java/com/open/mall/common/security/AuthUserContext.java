package com.open.mall.common.security;

import com.open.mall.api.auth.domain.bo.UserInfoInTokenBo;

public class AuthUserContext {

	/** The request holder. */
	private static final ThreadLocal<UserInfoInTokenBo> USER_INFO_IN_TOKEN_HOLDER = new ThreadLocal<>();

	public static UserInfoInTokenBo get() {
		return USER_INFO_IN_TOKEN_HOLDER.get();
	}

	public static void set(UserInfoInTokenBo userInfoInTokenBo) {
		USER_INFO_IN_TOKEN_HOLDER.set(userInfoInTokenBo);
	}

	public static void clean() {
		if (USER_INFO_IN_TOKEN_HOLDER.get() != null) {
			USER_INFO_IN_TOKEN_HOLDER.remove();
		}
	}
}