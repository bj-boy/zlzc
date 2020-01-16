package com.zlzc.common.security.support;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.zlzc.modules.user.entity.UserEntity;
import com.zlzc.modules.user.service.UserService;

/**
 * @author Lsr
 */
@Component("methodService")
public class DefaultMethodAuthorizeServiceImpl implements MethodAuthorizeService {

	private AntPathMatcher antPathMatcher = new AntPathMatcher();

	@Autowired
	private UserService userService;

	@Override
	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
		String username = (String) authentication.getPrincipal();
		boolean hasPermission = false;
		if (StringUtils.equalsIgnoreCase(username, "admin")) {
			hasPermission = true;
		} else {
			UserEntity dbUser = userService.getUserByUserName(username);
			if (Objects.isNull(dbUser)) {
				return hasPermission;
			}
			List<String> apiUrls = userService.queryAllApiUrls(dbUser.getUserId());
			for (String url : apiUrls) {
				if (antPathMatcher.match(url, request.getServletPath())) {
					hasPermission = true;
					break;
				}
			}
		}
		return hasPermission;
	}

}
