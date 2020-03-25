package com.zlzc.security.validate.code.sms;

/**
 * @author Lsr
 *
 */
public interface SmsCodeSender {

	/**
	 * @param mobile
	 * @param code
	 */
	void send(String mobile, String code);

}