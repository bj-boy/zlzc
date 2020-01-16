package com.zlzc.modules.menu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.modules.menu.entity.MenuEntity;

/**
 * 菜单管理
 *
 * @author Lsr
 */
@Mapper
public interface MenuDao extends BaseMapper<MenuEntity> {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<MenuEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<MenuEntity> queryNotButtonList();

}
