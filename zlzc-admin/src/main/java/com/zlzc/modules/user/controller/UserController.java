package com.zlzc.modules.user.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zlzc.common.security.AbstractController;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.common.validator.Assert;
import com.zlzc.modules.commodity.respType.CommodityStatisticsByStatusRT;
import com.zlzc.modules.user.entity.UserEntity;
import com.zlzc.modules.user.service.UserMenuService;
import com.zlzc.modules.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 用户表
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2020-01-13 18:02:03
 */
@Api(value = "后台-用户", tags = { "V1.0 User：后台-用户操作相关接口" })
@RestController
@RequestMapping("user")
public class UserController extends AbstractController {
	
	public UserController(UserDetailsService userDetailsService) {
		super(userDetailsService);
	}

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserMenuService userMenuService;

	/**
	 * 所有用户列表
	 */
	//@formatter:off
	@ApiOperation(value = "user-1 获取用户列表")
	@ApiResponses(value = { 
		@ApiResponse(response = UserEntity.class, code = 200, message = "用户列表响应字段说明") 
	})
	@ApiImplicitParams(
  		value = {
  			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
  			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
  		}
  	)
	@GetMapping("/list")
	//@formatter:on
	public Result list(@ApiParam(hidden = true) @RequestParam Map<String, Object> params) {
		PageUtils page = userService.queryPage(params);

		return Result.ok().put("page", page);
	}

	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public Result info() {
		String userName = getUserName();
		return Result.ok().put("user", userService.getUserByUserName(userName));
	}

	/**
	 * 修改登录用户密码
	 */
	@ApiOperation(value = "user-2 修改用户登陆密码")
	@ApiImplicitParams(
  		value = {
  			@ApiImplicitParam(name = "password", value = "旧密码", defaultValue = "123456", paramType = "query"),
  			@ApiImplicitParam(name = "newPassword", value = "新密码", defaultValue = "123456", paramType = "query")
  		}
  	)
	@GetMapping("/password")
	public Result password(@ApiParam(hidden = true) String password, @ApiParam(hidden = true) String newPassword) {
		Assert.isBlank(newPassword, "新密码不为能空");

		// 新密码
		newPassword = passwordEncoder.encode(newPassword);

		UserEntity originUser = userService.getById(getUserId());
		if (!passwordEncoder.matches(newPassword, originUser.getUserPassword())) {
			return Result.error("原密码不正确");
		}

		// 更新密码
		boolean flag = userService.updatePassword(getUserId(), password, newPassword);

		return Result.ok().put("rs", flag);
	}

	/**
	 * 用户信息
	 */
	@ApiOperation(value = "user-3 获取用户信息")
	@ApiImplicitParams(
  		value = {
  			@ApiImplicitParam(name = "userId", value = "用户ID", defaultValue = "2", paramType = "path"),
  		}
  	)
	@ApiResponses(value = { 
		@ApiResponse(response = UserEntity.class, code = 200, message = "用户列表响应字段说明") 
	})
	@GetMapping("/info/{userId}")
	public Result info(@PathVariable("userId") Long userId) {
		UserEntity user = userService.getById(userId);

		// 获取用户所属的菜单列表
		List<Long> menuIdList = userMenuService.queryMenuIdList(userId);
		user.setMenuIdList(menuIdList);

		return Result.ok().put("user", user);
	}

	/**
	 * 保存用户
	 */
	@ApiOperation(value = "user-4 新增用户")
	@PostMapping("/save")
	public Result save(@RequestBody UserEntity user) {
		userService.saveUser(user);

		return Result.ok();
	}

	/**
	 * 修改用户
	 */
	@ApiOperation(value = "user-5 修改用户")
	@PutMapping("/update")
	public Result update(@RequestBody UserEntity user) {
		userService.update(user);

		return Result.ok();
	}

	/**
	 * 删除用户
	 */
	@ApiOperation(value = "user-6 删除用户")
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(
				name = "merchntIds", 
				value = "用户ID[]; [1,2,3]", 
				paramType = "body", 
				dataTypeClass = String.class, 
				allowMultiple = true
			)
		}
	)
	@DeleteMapping("/delete")
	public Result delete(@RequestBody Long[] userIds) {
		if (ArrayUtils.contains(userIds, 1L)) {
			return Result.error("系统管理员不能删除");
		}

		if (ArrayUtils.contains(userIds, getUserId())) {
			return Result.error("当前用户不能删除");
		}

		userService.removeByIds(Arrays.asList(userIds));

		return Result.ok();
	}

}
