package com.zlzc.modules.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(description = "订单详情商品相关返回字段说明")
public class OrderDetailsCommodity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 订单商品中间表ID
	 */
	@ApiModelProperty(name = "id", value = "订单商品中间表ID", example = "订单商品中间表ID", hidden = true)
	private Long id;

	/**
	 * 商品id
	 */
	@ApiModelProperty(name = "commodityId", value = "商品id", example = "商品id")
	private Long commodityId;
	
	/**
	 * 商品名称
	 */
	@ApiModelProperty(name = "commodityName", value = "商品名称", example = "商品名称")
	private String commodityName;
	
	/**
	 * 商品货号
	 */
	@ApiModelProperty(name = "commodityNo", value = "商品货号", example = "商品货号")
	private Long commodityNo;

	/**
	 * sku id
	 */
	@ApiModelProperty(name = "skuId", value = "sku id", example = "sku id")
	private Long skuId;
	
	/**
	 * SKU名称
	 */
	@ApiModelProperty(name = "skuName", value = "SKU名称", example = "SKU名称")
	private String skuName;
	
	/**
	 * 商品数量
	 */
	@ApiModelProperty(name = "commodityNumber", value = "商品数量", example = "商品数量")
	private Integer commodityNumber;
	
	/**
	 * 商品单价
	 */
	@ApiModelProperty(name = "commodityPrice", value = "商品单价", example = "商品单价")
	private BigDecimal commodityPrice;

}
