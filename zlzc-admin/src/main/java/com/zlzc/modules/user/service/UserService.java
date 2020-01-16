package com.zlzc.modules.user.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.user.entity.UserEntity;

/**
 * 用户表
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2020-01-13 18:02:03
 */
public interface UserService extends IService<UserEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);
	
	/**
	 * 保存用户
	 */
	void saveUser(UserEntity user);
	
	/**
	 * 修改用户
	 */
	void update(UserEntity user);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 *            用户ID
	 * @param password
	 *            原密码
	 * @param newPassword
	 *            新密码
	 */
	boolean updatePassword(Long userId, String password, String newPassword);

	/**
	 * 登陆时获取用户信息
	 * @param username
	 * @return
	 */
	UserEntity getUserByUserName(String username);

	List<String> queryAllPerms(Long userId);

	List<String> queryAllApiUrls(Long userId);
}
