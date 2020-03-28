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
public class UpdShopEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 店铺ID
	 */
	@ApiModelProperty(name = "shopId", value = "店铺ID", example = "店铺ID")
	@TableId
	private Long shopId;
	/**
	 * 店铺名称
	 */
	@ApiModelProperty(name = "shopName", value = "店铺名称", example = "店铺名称")
	private String shopName;
	/**
	 * 商户ID
	 */
	@ApiModelProperty(name = "merchantId", value = "商户ID", example = "商户ID", hidden = true)
	private Long merchantId;
	/**
	 * 商户名称
	 */
	@ApiModelProperty(name = "merchantName", value = "商户名称", example = "商户名称", hidden = true)
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
	 * 店铺区域
	 */
	@ApiModelProperty(name = "shopRegion", value = "店铺区域", example = "店铺区域", hidden = true)
	private String shopRegion;
	/**
	 * 店铺联系人
	 */
	@ApiModelProperty(name = " shopLinkman", value = "店铺联系人", example = "店铺联系人")
	private String shopLinkman;
	/**
	 * 联系方式
	 */
	@ApiModelProperty(name = "shopTel", value = "联系方式", example = "联系方式")
	private String shopTel;
	/**
	 * 店铺经营范围
	 */
	@ApiModelProperty(name = "shopScope", value = "店铺经营范围", example = "店铺经营范围")
	private String shopScope;
	/**
	 * 店铺状态
	 */
	@ApiModelProperty(name = "shopStatus", value = "店铺状态", example = "店铺状态", hidden = true)
	private Integer shopStatus;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "创建时间", hidden = true)
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 修改时间
	 */
	@ApiModelProperty(name = "updateTime", value = "修改时间", example = "修改时间", hidden = true)
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "操作人", hidden = true)
	private String operator;
	/**
	 * 店铺编号
	 */
	@ApiModelProperty(name = "shopNo", value = "店铺编号", example = "店铺编号", hidden = true)
	private String shopNo;

	@ApiModelProperty(name = "commodityCnt", value = "商品数量", example = "商品数量", hidden = true)
	@TableField(exist = false)
	private Integer commodityCnt;
	
	/**
	 * 店铺描述
	 */
	@ApiModelProperty(name = "shopDesc", value = "店铺描述", example = "店铺描述")
	private String shopDesc;


}
