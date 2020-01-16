package com.zlzc.common.security.support;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

public interface MethodAuthorizeService {

	boolean hasPermission(HttpServletRequest request, Authentication authentication);

}