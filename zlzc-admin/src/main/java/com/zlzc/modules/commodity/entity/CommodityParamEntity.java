package com.zlzc.modules.commodity.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

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
@TableName("zlzc_commodity_param")
@Accessors(chain = true)
public class CommodityParamEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 参数ID
	 */
	@ApiModelProperty(name = "paramId", value = "参数ID", example = "参数ID")
	@TableId
	private Long paramId;
	/**
	 * 商品属性ID
	 */
	@ApiModelProperty(name = "attrId", value = "商品属性ID", example = "商品属性ID")
	private Long attrId;
	/**
	 * 参数名称
	 */
	@ApiModelProperty(name = "paramName", value = "参数名称", example = "参数名称")
	private String paramName;
	/**
	 * 参数值列表
	 */
	@ApiModelProperty(name = "paramVals", value = "参数值列表", example = "参数值列表")
	private String paramVals;
	/**
	 * 国别
	 */
	@ApiModelProperty(name = "countryCode", value = "国别", example = "国别")
	private String countryCode;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "paramOrder", value = "排序", example = "排序")
	private Integer paramOrder;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "updateTime", value = "更新时间", example = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "操作人")
	private String operator;

}
