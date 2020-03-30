package com.zlzc.modules.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(description = "订单详情返回字段说明")
public class OrderDetailsVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 订单id
	 */
	@ApiModelProperty(name = "orderId", value = "订单id", example = "订单id")
	private Long orderId;

	/**
	 * 店铺id
	 */
	@ApiModelProperty(name = "shopId", value = "店铺id", example = "店铺id")
	private Long shopId;
	
	/**
	 * 店铺名称
	 */
	@ApiModelProperty(name = "shopName", value = "店铺名称", example = "店铺名称")
	private String shopName;

	/**
	 * 商户id
	 */
	@ApiModelProperty(name = "merchantId", value = "商户id", example = "商户id")
	private Long merchantId;
	
	/**
	 * 商户名称
	 */
	@ApiModelProperty(name = "merchantName", value = "商户名称", example = "商户名称")
	private String merchantName;

	/**
	 * 订单编号
	 */
	@ApiModelProperty(name = "orderNumber", value = "订单编号", example = "订单编号")
	private String orderNumber;

	/**
	 * 备注
	 */
	@ApiModelProperty(name = "orderRemark", value = "备注", example = "备注")
	private String orderRemark;

	/**
	 * 订单应付款金额（所有商品的数量*单价的总和 + 运费 + ...）
	 */
	@ApiModelProperty(name = "orderPayable", value = "订单应付款金额", example = "订单应付款金额", hidden = true)
	private BigDecimal orderPayable;

	/**
	 * 订单总金额（实付金额，可能免运费，优惠券）
	 */
	@ApiModelProperty(name = "orderTotalAmount", value = "订单总金额", example = "订单总金额", hidden = true)
	private BigDecimal orderTotalAmount;

	/**
	 * 商品合计金额（所有商品的数量*单价的总和）
	 */
	@ApiModelProperty(name = "orderCommodityTotalAmount", value = "商品合计金额", example = "商品合计金额", hidden = true)
	private BigDecimal orderCommodityTotalAmount;
	
	/**
     * 运费
     */
    @ApiModelProperty(name = "logisticsFreight", value = "运费", example = "运费")
    private BigDecimal  logisticsFreight;
    
    /**
	 * 优惠价格
	 */
	@ApiModelProperty(name = "discountAmount", value = "优惠价格", example = "优惠价格")
	private BigDecimal discountAmount;
	
	/**
	 * 支付状态（新增默认为0待支付状态）
	 */
	@ApiModelProperty(name = "orderPaymentStatus", value = "支付状态", example = "支付状态", hidden = true)
	private Integer orderPaymentStatus;

	/**
	 * 支付方式（新增订单时不填写该字段）
	 */
	@ApiModelProperty(name = "orderPaymentMethod", value = "支付方式", example = "支付方式", hidden = true)
	private Integer orderPaymentMethod;

	/**
	 * 订单来源
	 */
	@ApiModelProperty(name = "orderSource", value = "订单来源", example = "订单来源")
	private Integer orderSource;

	/**
	 * 订单状态（新增默认为0待支付订单）
	 */
	@ApiModelProperty(name = "orderStatus", value = "订单状态", example = "订单状态", hidden = true)
	private Integer orderStatus;
	
	private OrderDetailsLogisticsVo orderDetailsLogistics;
	
	private List<OrderDetailsCommodity> orderDetailsCommodities;
}
