package com.zlzc.common.security.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.zlzc.modules.user.service.UserService;
import com.zlzc.security.authorize.AuthorizeConfigProvider;

@Component
@Order(Integer.MAX_VALUE)
public class ZlzcAdminAuthorizeConfigProvider implements AuthorizeConfigProvider{

	@Autowired
	private UserService userService;
	
	@Autowired(required = false)
	private MethodSecurityMetadataSource methodSecurityMetadataSource;
	
	@Override
	public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		
		//@formatter:off
		config
			.antMatchers("/zlzc_file/**")
			.permitAll()
			.anyRequest()
			.access("@methodService.hasPermission(request, authentication)");
		//@formatter:on
		return true;
	}

}
