package com.zlzc.modules.menu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.Constant;
import com.zlzc.modules.menu.dao.MenuDao;
import com.zlzc.modules.menu.entity.MenuEntity;
import com.zlzc.modules.menu.service.MenuService;
import com.zlzc.modules.user.entity.UserMenuEntity;
import com.zlzc.modules.user.service.UserMenuService;
import com.zlzc.modules.user.service.UserService;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, MenuEntity> implements MenuService {
	@Autowired
	private UserService userService;

	@Autowired
	private UserMenuService userMenuService;

	@Override
	public List<MenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
		List<MenuEntity> menuList = queryListParentId(parentId);
		if (menuIdList == null) {
			return menuList;
		}

		List<MenuEntity> userMenuList = new ArrayList<>();
		for (MenuEntity menu : menuList) {
			if (menuIdList.contains(menu.getMenuId())) {
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	@Override
	public List<MenuEntity> queryListParentId(Long parentId) {
		return baseMapper.queryListParentId(parentId);
	}

	@Override
	public List<MenuEntity> queryNotButtonList() {
		return baseMapper.queryNotButtonList();
	}

	@Override
	public List<MenuEntity> getUserMenuList(Long userId) {
		// 系统管理员，拥有最高权限
		if (userId == Constant.SUPER_ADMIN) {
			return getAllMenuList(null);
		}

		// 用户菜单列表
		List<Long> menuIdList = userService.queryAllMenuId(userId);
		return getAllMenuList(menuIdList);
	}

	@Override
	public void delete(Long menuId) {
		// 删除菜单
		this.removeById(menuId);
		
		// 删除菜单与用户关联
		userMenuService.remove(new QueryWrapper<UserMenuEntity>().eq("menu_id", menuId));
	}

	/**
	 * 获取所有菜单列表
	 */
	private List<MenuEntity> getAllMenuList(List<Long> menuIdList) {
		// 查询根菜单列表
		List<MenuEntity> menuList = queryListParentId(0L, menuIdList);
		// 递归获取子菜单
		getMenuTreeList(menuList, menuIdList);

		return menuList;
	}

	/**
	 * 递归
	 */
	private List<MenuEntity> getMenuTreeList(List<MenuEntity> menuList, List<Long> menuIdList) {
		List<MenuEntity> subMenuList = new ArrayList<MenuEntity>();

		for (MenuEntity entity : menuList) {
			// 目录
			if (entity.getType() == Constant.MenuType.CATALOG.getValue()) {
				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}

		return subMenuList;
	}
}
