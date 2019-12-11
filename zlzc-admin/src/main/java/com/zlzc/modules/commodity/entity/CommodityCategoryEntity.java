package com.zlzc.modules.commodity.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Data
@TableName("zlzc_commodity_category")
public class CommodityCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分类ID
	 */
	@ApiModelProperty(name = "categoryId", value = "分类ID", example = "1")
	@TableId
	private Long categoryId;
	/**
	 * 分类编号
	 */
	@ApiModelProperty(name = "categoryNo", value = "分类编号", example = "131313")
	private Long categoryNo;
	/**
	 * 分类名称
	 */
	@ApiModelProperty(name = "categoryName", value = "分类名称", example = "分类01")
	private String categoryName;
	/**
	 * 父ID
	 */
	@ApiModelProperty(name = "parentCategoryId", value = "父ID", example = "")
	private Long parentCategoryId;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "categoryOrder", value = "排序", example = "1")
	private Integer categoryOrder;
	/**
	 * 分类图标
	 */
	@ApiModelProperty(name = "categoryIcon", value = "分类图标", example = "icon01")
	private String categoryIcon;
	/**
	 * 分类描述
	 */
	@ApiModelProperty(name = "categoryDesc", value = "分类描述", example = "分类01描述")
	private String categoryDesc;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "updateTime", value = "更新时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "admin")
	private String operator;

}
