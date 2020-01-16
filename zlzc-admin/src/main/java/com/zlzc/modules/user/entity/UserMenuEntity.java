package com.zlzc.modules.user.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 用户与菜单对应关系
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2020-01-15 16:54:58
 */
@Data
@TableName("zlzc_user_menu")
public class UserMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 菜单ID
	 */
	private Long menuId;

}
