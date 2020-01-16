package com.zlzc.modules.user.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户表
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2020-01-13 18:02:03
 */
@Data
@TableName("zlzc_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty(name = "userId", value = "用户id", example = "1")
	@TableId
	private Long userId;
	/**
	 * 用户名
	 */
	@ApiModelProperty(name = "username", value = "用户名", example = "老鼠爱大米")
	private String username;
	/**
	 * 用户账号
	 */
	@ApiModelProperty(name = "userAcct", value = "用户账号", example = "admin")
	private String userAcct;
	/**
	 * 用户密码
	 */
	@ApiModelProperty(name = "userPassword", value = "用户密码", example = "123")
	private String userPassword;
	/**
	 * 手机号
	 */
	@ApiModelProperty(name = "mobile", value = "手机号", example = "13866668888")
	private String mobile;
	/**
	 * 邮箱
	 */
	@ApiModelProperty(name = "email", value = "邮箱", example = "xiaoxiannv@163.com")
	private String email;
	/**
	 * 状态 0：禁用 1：正常
	 */
	@ApiModelProperty(name = "userStatus", value = "状态 0：禁用 1：正常", example = "1")
	private Integer userStatus;
	/**
	 * 性别 0：未知 1：男 2：女
	 */
	@ApiModelProperty(name = "gender", value = "性别 0：未知 1：男 2：女", example = "1")
	private Integer gender;
	/**
	 * 生日
	 */
	@ApiModelProperty(name = "birthday", value = "生日", example = "1")
	private Date birthday;
	/**
	 * 城市
	 */
	@ApiModelProperty(name = "address", value = "城市", example = "1")
	private String address;
	/**
	 * 个性签名
	 */
	@ApiModelProperty(name = "signature", value = "个性签名", example = "12345,上山打老虎")
	private String signature;
	/**
	 * 职业
	 */
	@ApiModelProperty(name = "profession", value = "职业", example = "1")
	private String profession;
	/**
	 * 喜欢的分类，多个用逗号分隔
	 */
	@ApiModelProperty(name = "favouriteCategory", value = "喜欢的分类，多个用逗号分隔", example = "1")
	private String favouriteCategory;
	/**
	 * 来源 0：未知 1：app 2：admin
	 */
	@ApiModelProperty(name = "source", value = "来源 0：未知 1：app 2：admin", example = "1")
	private Integer source;
	/**
	 * 创建时间
	 */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-12-01 12:12:45")
	private Date createTime;
	/**
	 * 更新时间
	 */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "createTime", value = "更新时间", example = "2019-12-01 12:12:45")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "1")
	private String operator;

	/**
	 * 菜单ID列表
	 */
	@ApiModelProperty(name = "userId", value = "菜单ID列表", example = "[1]")
	@TableField(exist = false)
	private List<Long> menuIdList;

}
