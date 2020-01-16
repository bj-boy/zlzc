package com.zlzc.common.security.validate.code.sms;

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
