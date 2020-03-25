package com.zlzc.security.properties;

import lombok.Data;

/**
 * @author Lsr
 */
@Data
public class OAuth2Properties {
	/**
	 * 使用jwt时为token签名的秘钥
	 */
	private String jwtSigningKey = "zlzc";
	/**
	 * 客户端配置
	 */
	private OAuth2ClientProperties[] clients = {};
}