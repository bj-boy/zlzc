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
@TableName("zlzc_commodity_detail")
@Accessors(chain = true)
public class CommodityDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 详情ID
	 */
	@ApiModelProperty(name = "detailId", value = "详情ID", example = "详情ID")
	@TableId
	private Long detailId;
	/**
	 * 商品ID
	 */
	@ApiModelProperty(name = "commodityId", value = "商品ID", example = "商品ID")
	private Long commodityId;
	/**
	 * 详情类型(PC / 移动)
	 */
	@ApiModelProperty(name = "detailType", value = "详情类型(PC / 移动)", example = "详情类型(PC / 移动)")
	private Integer detailType;
	/**
	 * 详情URL
	 */
	@ApiModelProperty(name = "detailUrl", value = "详情URL", example = "详情URL")
	private String detailUrl;
	/**
	 * 国别
	 */
	@ApiModelProperty(name = "countryCode", value = "国别", example = "国别")
	private String countryCode;
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
