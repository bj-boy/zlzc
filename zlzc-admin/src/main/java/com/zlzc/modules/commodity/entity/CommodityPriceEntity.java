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
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Data
@TableName("zlzc_commodity_price")
@Accessors(chain = true)
public class CommodityPriceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 价格ID
	 */
	@ApiModelProperty(name = "priceId", value = "价格ID", example = "价格ID")
	@TableId
	private Long priceId;
	/**
	 * 商品ID
	 */
	@ApiModelProperty(name = "commodityId", value = "商品ID", example = "商品ID")
	@TableField(exist = false)
	private Long commodityId;
	/**
	 * SKU_ID
	 */
	@ApiModelProperty(name = "skuId", value = "SKU_ID", example = "SKU_ID")
	@TableField(exist = false)
	private Long skuId;
	/**
	 * 销售模式 (批发/零售)
	 */
	@ApiModelProperty(name = "salesModel", value = "销售模式 (批发/零售)", example = "销售模式 (批发/零售)")
	private Integer salesModel;
	/**
	 * 价格
	 */
	@ApiModelProperty(name = "price", value = "价格", example = "价格")
	private BigDecimal price;
	/**
	 * 货币单位
	 */
	@ApiModelProperty(name = "priceUnit", value = "货币单位", example = "货币单位")
	private String priceUnit;
	/**
	 * 国别
	 */
	@ApiModelProperty(name = "countryCode", value = "国别", example = "国别")
	private String countryCode;
	/**
	 * 销售规则(eg：规定一个起批数量)    
	 */
	@ApiModelProperty(name = "salesRule", value = "销售规则(eg：规定一个起批数量)", example = "销售规则(eg：规定一个起批数量)")
	private String salesRule;
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
