package com.zlzc.modules.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.modules.user.entity.UserEntity;

/**
 * 用户表
 * @author LSR
 * @email zlzc@example.com
 * @date 2020-01-13 18:02:03
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

	/**
	 * 查询用户的所有权限
	 * 
	 * @param userId
	 *            用户ID
	 */
	List<String> queryAllPerms(Long userId);

	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);

	/**
	 * 
	 */
	List<String> queryAllApiUrls(Long userId);


}
