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
@TableName("zlzc_commodity_attr")
@Accessors(chain = true)
public class CommodityAttrEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 属性ID
	 */
	@ApiModelProperty(name = "attrId", value = "属性ID", example = "1")
	@TableId
	private Long attrId;
	/**
	 * 商户ID
	 */
	@ApiModelProperty(name = "merchantId", value = "商户ID", example = "1")
	private Long merchantId;
	/**
	 * 店铺ID
	 */
	@ApiModelProperty(name = "shopId", value = "店铺ID", example = "1")
	private Long shopId;
	/**
	 * 商品属性编号
	 */
	@ApiModelProperty(name = "attrNo", value = "商品属性编号", example = "121213")
	private Long attrNo;
	/**
	 * 商品属性名称
	 */
	@ApiModelProperty(name = "attrName", value = "商品属性名称", example = "商品属性01")
	private String attrName;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "updateTime", value = "更新时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "admin")
	private String operator;

}
