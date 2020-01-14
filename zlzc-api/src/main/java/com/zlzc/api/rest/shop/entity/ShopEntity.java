package com.zlzc.api.rest.shop.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *	店铺shop表
 *
 * @author LBB
 * @email biaobiao999@163.com
 * @date 2019-12-02 08:55:28
 */
@ApiModel(description = "店铺实体")
@Data
@TableName("zlzc_shop")
public class ShopEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 店铺ID
	 */
	@ApiModelProperty(name = "shopId", value = "店铺ID", example = "1")
	@TableId
	private Long shopId;
	/**
	 * 店铺名称
	 */
	@ApiModelProperty(name = "shopName", value = "店铺名称", example = "飞哥水果店")
	private String shopName;
	/**
	 * 商户ID
	 */
	@ApiModelProperty(name = "merchantId", value = "商户ID", example = "1")
	private Long merchantId;
	/**
	 * 商户名称
	 */
	@ApiModelProperty(name = "merchantName", value = "商户名称", example = "大志")
	private String merchantName;
	/**
	 * 店铺logo url
	 */
	@ApiModelProperty(name = "shopLogoUrl", value = "店铺logoUrl", example = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577790414255&di=0c7918624b446771f4955ee23c09eaed&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D3048152894%2C3789302586%26fm%3D214%26gp%3D0.jpg")
	private String shopLogoUrl;
	/**
	 * 店铺地址
	 */
	@ApiModelProperty(name = "shopAddr", value = "店铺地址", example = "朝信安路101")
	private String shopAddr;
	/**
	 * 店铺区域
	 */
	@ApiModelProperty(name = "shopRegion", value = "店铺区域", example = "朝阳区")
	private String shopRegion;
	/**
	 * 店铺联系人
	 */
	@ApiModelProperty(name = " shopLinkman", value = "店铺联系人", example = "花")
	private String shopLinkman;
	/**
	 * 联系方式
	 */
	@ApiModelProperty(name = "shopTel", value = "联系方式", example = "138888888")
	private String shopTel;
	/**
	 * 店铺经营范围
	 */
	@ApiModelProperty(name = "shopScope", value = "店铺经营范围", example = "1")
	private Integer shopScope;
	/**
	 * 店铺状态
	 */
	@ApiModelProperty(name = "shopStatus", value = "店铺状态", example = "1")
	private Integer shopStatus;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "shopCreateTime", value = "创建时间", example = "2019-12-01 12:12:46")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 修改时间
	 */
	@ApiModelProperty(name = "updateTime", value = "修改时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "名言")
	private String operator;
	/**
	 * 店铺编号
	 */
	@ApiModelProperty(name = "shopNo", value = "店铺编号", example = "12121")
	private String shopNo;

	@ApiModelProperty(name = "commodityCnt", value = "商品数量", example = "0")
	@TableField(exist = false)
	private Integer commodityCnt;
}
