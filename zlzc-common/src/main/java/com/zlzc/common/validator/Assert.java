package com.zlzc.common.validator;

import org.apache.commons.lang.StringUtils;

import com.zlzc.common.exception.ZException;

/**
 * 数据校验
 */
public abstract class Assert {

	public static void isBlank(String str, String message) {
		if (StringUtils.isBlank(str)) {
			throw new ZException(message);
		}
	}

	public static void isNull(Object object, String message) {
		if (object == null) {
			throw new ZException(message);
		}
	}
}
