package com.zlzc.modules.menu.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlzc.common.exception.ZException;
import com.zlzc.common.security.AbstractController;
import com.zlzc.common.utils.Constant;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.menu.entity.MenuEntity;
import com.zlzc.modules.menu.service.MenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 系统菜单
 *
 * @author Lsr
 */
@Api(value = "后台-菜单", tags = { "V1.0 Menu：后台-菜单操作相关接口" })
@RestController
@RequestMapping("menu")
public class MenuController extends AbstractController {
	
	public MenuController(UserDetailsService userDetailsService) {
		super(userDetailsService);
	}

	@Autowired
	private MenuService menuService;

	/**
	 * 导航菜单
	 */
	@ApiOperation(value = "menu-1 获取导航菜单")
	@ApiResponses(value = { 
		@ApiResponse(response = MenuEntity.class, code = 200, message = "导航菜单响应字段说明") 
	})
	@GetMapping("/nav")
	public Result nav() {
		List<MenuEntity> menuList = menuService.getUserMenuList(getUserId());
		return Result.ok().put("menuList", menuList);
	}

	/**
	 * 所有菜单列表
	 */
	@ApiOperation(value = "menu-2 获取菜单列表")
	@ApiResponses(value = { 
		@ApiResponse(response = MenuEntity.class, code = 200, message = "菜单列表响应字段说明") 
	})
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('zlzc:admin:menu:list')")
	public List<MenuEntity> list() {
		List<MenuEntity> menuList = menuService.list();
		for (MenuEntity menuEntity : menuList) {
			MenuEntity parentMenuEntity = menuService.getById(menuEntity.getParentId());
			if (parentMenuEntity != null) {
				menuEntity.setParentName(parentMenuEntity.getName());
			}
		}

		return menuList;
	}

	/**
	 * 选择菜单(添加、修改菜单)
	 */
	@ApiOperation(value = "menu-3 菜单树形结构列表")
	@ApiResponses(value = { 
		@ApiResponse(response = MenuEntity.class, code = 200, message = "菜单树形结构列表响应字段说明") 
	})
	@GetMapping("/select")
	public Result select() {
		// 查询列表数据
		List<MenuEntity> menuList = menuService.queryNotButtonList();

		// 添加顶级菜单
		MenuEntity root = new MenuEntity();
		root.setMenuId(0L);
		root.setName("一级菜单");
		root.setParentId(-1L);
		root.setOpen(true);
		menuList.add(root);

		return Result.ok().put("menuList", menuList);
	}

	/**
	 * 菜单信息
	 */
	@ApiOperation(value = "menu-4 获取菜单信息")
	@ApiResponses(value = { 
		@ApiResponse(response = MenuEntity.class, code = 200, message = "菜单信息响应字段说明") 
	})
	@ApiImplicitParams(
  		value = {
  			@ApiImplicitParam(name = "menuId", value = "菜单ID", defaultValue = "2", paramType = "path"),
  		}
  	)
	@GetMapping("/info/{menuId}")
	public Result info(@PathVariable("menuId") Long menuId) {
		MenuEntity menu = menuService.getById(menuId);
		return Result.ok().put("menu", menu);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "menu-5 新增菜单")
	@PostMapping("/save")
	public Result save(@RequestBody MenuEntity menu) {
		// 数据校验
		verifyForm(menu);

		menuService.save(menu);

		return Result.ok();
	}

	/**
	 * 修改
	 */
	@ApiOperation(value = "menu-6 修改菜单")
	@RequestMapping("/update")
	@PutMapping("/update")
	public Result update(@RequestBody MenuEntity menu) {
		// 数据校验
		verifyForm(menu);

		menuService.updateById(menu);

		return Result.ok();
	}

	/**
	 * 删除
	 */
	@ApiOperation(value = "menu-7 删除菜单")
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(name = "menuId", value = "菜单ID", defaultValue = "1", paramType = "query")
		}
	)
	@DeleteMapping("/delete")
	public Result delete(long menuId) {
//		if (menuId <= 31) {
//			return Result.error("系统菜单，不能删除");
//		}

		// 判断是否有子菜单或按钮
		List<MenuEntity> menuList = menuService.queryListParentId(menuId);
		if (menuList.size() > 0) {
			return Result.error("请先删除子菜单或按钮");
		}

		menuService.delete(menuId);

		return Result.ok();
	}

	/**
	 * 验证参数是否正确
	 */
	private void verifyForm(MenuEntity menu) {
		if (StringUtils.isBlank(menu.getName())) {
			throw new ZException("菜单名称不能为空");
		}

		if (menu.getParentId() == null) {
			throw new ZException("上级菜单不能为空");
		}

		// 菜单
		if (menu.getType() == Constant.MenuType.MENU.getValue()) {
			if (StringUtils.isBlank(menu.getUrl())) {
				throw new ZException("菜单URL不能为空");
			}
		}

		// 上级菜单类型
		int parentType = Constant.MenuType.CATALOG.getValue();
		if (menu.getParentId() != 0) {
			MenuEntity parentMenu = menuService.getById(menu.getParentId());
			parentType = parentMenu.getType();
		}

		// 目录、菜单
		if (menu.getType() == Constant.MenuType.CATALOG.getValue()
				|| menu.getType() == Constant.MenuType.MENU.getValue()) {
			if (parentType != Constant.MenuType.CATALOG.getValue()) {
				throw new ZException("上级菜单只能为目录类型");
			}
			return;
		}

		// 按钮
		if (menu.getType() == Constant.MenuType.BUTTON.getValue()) {
			if (parentType != Constant.MenuType.MENU.getValue()) {
				throw new ZException("上级菜单只能为菜单类型");
			}
			return;
		}
	}
}
