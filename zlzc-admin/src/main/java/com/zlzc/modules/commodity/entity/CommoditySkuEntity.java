package com.zlzc.modules.commodity.entity;

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
	@ApiModelProperty(name = "skuId", value = "SKU_ID", example = "1")
	@TableId
	private Long skuId;
	/**
	 * 库存ID
	 */
	@ApiModelProperty(name = "repoId", value = "库存ID", example = "1")
	@TableField(exist = false)
	private Long repoId;
	/**
	 * 相册ID
	 */
	@ApiModelProperty(name = "albumId", value = "相册ID", example = "1")
	@TableField(exist = false)
	private Long albumId;
	/**
	 * sku编号
	 */
	@ApiModelProperty(name = "skuNo", value = "sku编号", example = "112233")
	private Long skuNo;
	/**
	 * 商品属性ID
	 */
	@ApiModelProperty(name = "attrId", value = "商品属性ID", example = "1")
	private Long attrId;
	/**
	 * SKU名称
	 */
	@ApiModelProperty(name = "skuName", value = "SKU名称", example = "sku01")
	private String skuName;
	/**
	 * SKU值列表
	 */
	@ApiModelProperty(name = "skuVals", value = "SKU值列表", example = "a,b,c,d")
	private String skuVals;
	/**
	 * 国别
	 */
	@ApiModelProperty(name = "countryCode", value = "国别", example = "中国")
	private String countryCode;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "skuOrder", value = "排序", example = "1")
	private Integer skuOrder;
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
