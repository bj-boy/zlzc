package com.zlzc.modules.menu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单管理
 *
 * @author Lsr
 */
@Data
@TableName("zlzc_menu")
public class MenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 菜单ID
	 */
	@ApiModelProperty(name = "menuId", value = "菜单id", example = "1")
	@TableId
	private Long menuId;

	/**
	 * 父菜单ID，一级菜单为0
	 */
	@ApiModelProperty(name = "parentId", value = "父级菜单id", example = "0")
	private Long parentId;
	
	/**
	 * 父菜单名称
	 */
	@ApiModelProperty(name = "parentName", value = "父级菜单名称", example = "一级菜单")
	@TableField(exist=false)
	private String parentName;

	/**
	 * 菜单名称
	 */
	@ApiModelProperty(name = "name", value = "菜单名称", example = "一级菜单")
	private String name;

	/**
	 * 菜单URL
	 */
	@ApiModelProperty(name = "url", value = "菜单URL", example = "/xx/yy")
	private String url;

	/**
	 * 授权(多个用逗号分隔，如：user:list,user:create)
	 */
	@ApiModelProperty(name = "perms", value = "授权(多个用逗号分隔，如：user:list,user:create)", example = "user:list,user:create")
	private String perms;

	/**
	 * 类型     0：目录   1：菜单   2：按钮
	 */
	@ApiModelProperty(name = "type", value = "类型     0：目录   1：菜单   2：按钮", example = "0")
	private Integer type;

	/**
	 * 菜单图标
	 */
	@ApiModelProperty(name = "icon", value = "菜单图标", example = "0")
	private String icon;

	/**
	 * 排序
	 */
	@ApiModelProperty(name = "orderNum", value = "排序", example = "0")
	private Integer orderNum;
	
	/**
	 * 接口URL
	 */
	@ApiModelProperty(name = "apiUrl", value = "排序", example = "/menu/list")
	private String apiUrl;
	
	/**
	 * ztree属性
	 */
	@ApiModelProperty(name = "open", value = "ztree属性", example = "false")
	@TableField(exist=false)
	private Boolean open;

	@ApiModelProperty(name = "list", value = "列表", example = "[]")
	@TableField(exist=false)
	private List<?> list;
}
