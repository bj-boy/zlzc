package com.zlzc.modules.shop.paramType;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "店铺实体")
@Data
@TableName("zlzc_shop")
public class ShopParam implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 商户名称
	 */
	@ApiModelProperty(name = "merchantName", value = "商户名称", example = "商户名称")
	private String merchantName;
	/**
	 * 店铺logo url
	 */
	@ApiModelProperty(name = "shopLogoUrl", value = "店铺logoUrl", example = "店铺logoUrl")
	private String shopLogoUrl;
	/**
	 * 店铺地址
	 */
	@ApiModelProperty(name = "shopAddr", value = "店铺地址", example = "店铺地址")
	private String shopAddr;
	/**
	 * 店铺联系人
	 */
	@ApiModelProperty(name = " shopLinkman", value = "店铺联系人", example = "店铺联系人")
	private String shopLinkman;
	/**
	 * 店铺经营范围
	 */
	@ApiModelProperty(name = "shopScope", value = "店铺经营范围", example = "店铺经营范围")
	private Integer shopScope;
	/**
	 * 店铺状态
	 */
	@ApiModelProperty(name = "shopStatus", value = "店铺状态", example = "店铺状态")
	private Integer shopStatus;
}
