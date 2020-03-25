package com.zlzc.modules.user.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.user.dao.UserDao;
import com.zlzc.modules.user.entity.UserEntity;
import com.zlzc.modules.user.service.UserMenuService;
import com.zlzc.modules.user.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserMenuService userMenuService;

	@Override
	public UserEntity getUserByUserName(String username) {
		QueryWrapper<UserEntity> qw = new QueryWrapper<UserEntity>().eq(StringUtils.isNotBlank(username), "username",
				username);
		UserEntity user = baseMapper.selectOne(qw);
		return user;
	}

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return baseMapper.queryAllMenuId(userId);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String username = (String) params.get("username");

		IPage<UserEntity> page = baseMapper.getPage(new Query<UserEntity>().getPage(params),
				new QueryWrapper<UserEntity>().like(StringUtils.isNotBlank(username), "username", username));
		
//		IPage<UserEntity> page = this.page(new Query<UserEntity>().getPage(params),
//				new QueryWrapper<UserEntity>().like(StringUtils.isNotBlank(username), "username", username));

		
		return new PageUtils(page);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveUser(UserEntity user) {
		user.setCreateTime(new Date());
		// 密码加密
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		this.save(user);

		// 保存用户与菜单关系
		userMenuService.saveOrUpdate(user.getUserId(), user.getMenuIdList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(UserEntity user) {
		if (StringUtils.isBlank(user.getUserPassword())) {
			user.setUserPassword(null);
		} else {
			UserEntity userEntity = this.getById(user.getUserId());
			user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		}
		this.updateById(user);

		// 保存用户与菜单关系
		userMenuService.saveOrUpdate(user.getUserId(), user.getMenuIdList());
	}

	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserPassword(newPassword);
		return this.update(userEntity, new QueryWrapper<UserEntity>().eq("user_id", userId));
	}

	@Override
	public List<String> queryAllPerms(Long userId) {
		return baseMapper.queryAllPerms(userId);
	}

	@Override
	public List<String> queryAllApiUrls(Long userId) {
		return baseMapper.queryAllApiUrls(userId);
	}

}
