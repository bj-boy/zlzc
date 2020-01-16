package com.zlzc.common.security.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.zlzc.common.security.properties.SecurityProperties;
import com.zlzc.common.security.support.SecurityConstants;

/**
 * 核心模块的授权配置提供器，安全模块涉及的url的授权配置在这里。
 * 
 * @author Lsr
 *
 */
@Component
@Order(Integer.MIN_VALUE)
public class ZlzcBasicAuthorizeConfigProvider implements AuthorizeConfigProvider {

	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		//@formatter:off
		config
			// 认证权限路径放行
			.antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
				SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE,
				SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*")
			.permitAll()
			// swagger2 权限放行
			.antMatchers("/v2/api-docs", 
						 "/definitions/**", 
						 "/configuration/ui", 
						 "/swagger-resources/**", 
						 "/configuration/security", 
						 "/swagger-ui.html", 
						 "/webjars/**",
						 "/swagger-resources/configuration/ui",
						 "/swagge‌​r-ui.html")
			.permitAll()
			// 自定义静态资源的映射路径权限放行
			.antMatchers(HttpMethod.GET, "/statics/**")
			.permitAll();
		//@formatter:on
		
//		if (StringUtils.isNotBlank(securityProperties.getBrowser().getSignOutUrl())) {
//			config.antMatchers(securityProperties.getBrowser().getSignOutUrl()).permitAll();
//		}
		return false;
	}

}
