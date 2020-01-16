package com.zlzc.common.security;

import org.apache.shiro.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.zlzc.common.security.support.AuthUser;
import com.zlzc.modules.user.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller公共组件
 *
 * @author Lsr
 */
@Slf4j
public abstract class AbstractController {

	private final UserDetailsService userDetailsService;

	public AbstractController(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	private Authentication getAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication;
	}
	
	protected AuthUser getUser() {
		AuthUser user = (AuthUser) userDetailsService.loadUserByUsername((String) getAuthentication().getPrincipal());
		return user;
	}

	protected String getUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String authUserName = (String) authentication.getPrincipal();
		return authUserName;
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}

	protected Long getDeptId() {
		// return getUser().getDeptId();
		return null;
	}
}
