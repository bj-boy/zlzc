package com.zlzc.common.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.zlzc.common.security.support.AuthUser;
import com.zlzc.modules.user.entity.UserEntity;
import com.zlzc.modules.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ZlzcAdminUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("=========> " + username + " 尝试登陆。");
		
		// 查询数据库用户
		UserEntity dbUser = userService.getUserByUserName(username);
		if(Objects.isNull(dbUser)) {
			throw new UsernameNotFoundException(username + " ：没有查询到匹配用户。");
		}
		
		// 根据数据库用户状态填充返回User对象状态   
		Integer status = dbUser.getUserStatus();
		
		// 查询当前用户的权限集合
		List<String> permsList = userService.queryAllPerms(dbUser.getUserId());		
		// 集合去重转换为字符串
		String authorityStr = StringUtils.join(permsList.stream().distinct().collect(Collectors.toList()), ",");
		// 构建返回用户
		AuthUser returnUser = new AuthUser(dbUser.getUsername(), dbUser.getUserPassword(), 
				true, true, true, true,
				StringUtils.isNotBlank(authorityStr) ? AuthorityUtils.commaSeparatedStringToAuthorityList(authorityStr) : AuthorityUtils.NO_AUTHORITIES);
		// 自定义设置User的一些属性。
		returnUser.setUserId(dbUser.getUserId());
		return returnUser;
	}

}
