package com.zlzc.modules.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.modules.user.entity.UserMenuEntity;

/**
 * 用户与菜单对应关系
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2020-01-15 16:54:58
 */
@Mapper
public interface UserMenuDao extends BaseMapper<UserMenuEntity> {

	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long userId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] userIds);

}
