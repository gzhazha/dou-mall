package com.open.mall.common.base.api.handler;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.json.JSONUtil;
import com.open.mall.common.base.domain.vo.BaseResult;
import com.open.mall.common.base.enums.SystemError;
import com.open.mall.common.base.exception.MallBaseException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class MallHttpHandler {

	public static  <T> void printServerResponseToWeb(BaseResult<T> baseResult) {
		if (baseResult == null) {
			log.info("print obj is null");
			return;
		}

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		if (requestAttributes == null) {
			log.error("requestAttributes is null, can not print to web");
			return;
		}
		HttpServletResponse response = requestAttributes.getResponse();
		if (response == null) {
			log.error("httpServletResponse is null, can not print to web");
			return;
		}
        log.error("response error:{}", baseResult.getMsg());
		response.setCharacterEncoding(CharsetUtil.UTF_8);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		try {
            PrintWriter printWriter = response.getWriter();
			printWriter.write(JSONUtil.toJsonStr(baseResult));
		}
		catch (IOException e) {
            log.error("堆栈：",e);
			throw new MallBaseException(SystemError.SYSTEM_ERROR,"io 异常");
		}
	}

}
