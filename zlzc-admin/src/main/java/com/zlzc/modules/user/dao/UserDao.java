package com.zlzc.modules.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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


	IPage<UserEntity> getPage(IPage<UserEntity> iPage, @Param(Constants.WRAPPER) Wrapper wrapper);
}
