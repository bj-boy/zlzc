package com.zlzc.common.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.zlzc.common.security.support.SecurityConstants;

/**
 * 表单登录配置
 * 
 * @author Lsr
 */
@Component
public class FormAuthenticationConfig {

	@Autowired
	protected AuthenticationSuccessHandler zlzcAuthenticationSuccessHandler;
	
	@Autowired
	protected AuthenticationFailureHandler zlzcAuthenticationFailureHandler;
	
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
			.loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
			.successHandler(zlzcAuthenticationSuccessHandler)
			.failureHandler(zlzcAuthenticationFailureHandler);
	}
	
}