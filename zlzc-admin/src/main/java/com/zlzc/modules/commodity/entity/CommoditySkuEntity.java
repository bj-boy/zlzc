package com.zlzc.modules.commodity.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("zlzc_commodity_sku")
@Accessors(chain = true)
public class CommoditySkuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * SKU_ID
	 */
	@ApiModelProperty(name = "skuId", value = "SKU_ID", example = "SKU_ID")
	@TableId
	private Long skuId;
	/**
	 * 库存ID
	 */
	@ApiModelProperty(name = "repoId", value = "库存ID", example = "库存ID")
	@TableField(exist = false)
	private Long repoId;
	/**
	 * 相册ID
	 */
	@ApiModelProperty(name = "albumId", value = "相册ID", example = "相册ID")
	@TableField(exist = false)
	private Long albumId;
	/**
	 * sku编号
	 */
	@ApiModelProperty(name = "skuNo", value = "sku编号", example = "sku编号")
	private Long skuNo;
	/**
	 * 商品属性ID
	 */
	@ApiModelProperty(name = "attrId", value = "商品属性ID", example = "商品属性ID")
	private Long attrId;
	/**
	 * SKU名称
	 */
	@ApiModelProperty(name = "skuName", value = "SKU名称", example = "SKU名称")
	private String skuName;
	/**
	 * SKU值列表
	 */
	@ApiModelProperty(name = "skuVals", value = "SKU值列表", example = "SKU值列表")
	private String skuVals;
	/**
	 * 国别
	 */
	@ApiModelProperty(name = "countryCode", value = "国别", example = "国别")
	private String countryCode;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "skuOrder", value = "排序", example = "排序")
	private Integer skuOrder;
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
