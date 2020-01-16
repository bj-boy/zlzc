package com.zlzc.common.security.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图片验证码配置项
 * 
 * @author Lsr
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImageCodeProperties extends SmsCodeProperties {

	public ImageCodeProperties() {
		setLength(4);
	}

	/**
	 * 图片宽
	 */
	private int width = 67;
	/**
	 * 图片高
	 */
	private int height = 23;
}
