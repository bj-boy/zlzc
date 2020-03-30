package com.zlzc.modules.order.order_commodity_middle.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单商品中间表
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2020-03-29 12:24:57
 */
@ApiModel(description = "订单中商品相关参数说明")
@Data
@TableName("zlzc_order_commodity_middle")
@Accessors(chain = true)
public class OrderCommodityMiddleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单商品中间表ID
	 */
	@ApiModelProperty(name = "id", value = "订单商品中间表ID", example = "订单商品中间表ID", hidden = true)
	@TableId
	private Long id;
	/**
	 * 订单id
	 */
	@ApiModelProperty(name = "orderId", value = "订单id", example = "订单id", hidden = true)
	private Long orderId;
	/**
	 * 商品id
	 */
	@ApiModelProperty(name = "commodityId", value = "商品id", example = "商品id")
	private Long commodityId;
	/**
	 * sku id
	 */
	@ApiModelProperty(name = "skuId", value = "sku id", example = "sku id")
	private Long skuId;
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
	/**
	 * 优惠价格
	 */
	@ApiModelProperty(name = "discountAmount", value = "优惠价格", example = "优惠价格")
	private BigDecimal discountAmount;

}
