package com.zlzc.common.security.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码生成器
 * 
 * @author Lsr
 *
 */
public interface ValidateCodeGenerator {

	/**
	 * 生成校验码
	 * 
	 * @param request
	 * @return
	 */
	ValidateCode generate(ServletWebRequest request);

}
