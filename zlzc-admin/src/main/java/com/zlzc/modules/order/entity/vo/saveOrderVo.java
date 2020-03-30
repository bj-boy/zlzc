package com.zlzc.modules.order.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;
import com.zlzc.modules.order.order_commodity_middle.entity.OrderCommodityMiddleEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(description = "新增订单参数列表")
@Data
@Accessors(chain = true)
public class saveOrderVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 店铺id
	 */
	@ApiModelProperty(name = "shopId", value = "店铺id", example = "店铺id")
	private Long shopId;

	/**
	 * 用户id
	 */
	@ApiModelProperty(name = "userId", value = "用户id", example = "用户id")
	private Long userId;

	/**
	 * 商户id
	 */
	@ApiModelProperty(name = "merchantId", value = "商户id", example = "商户id")
	private Long merchantId;

	/**
	 * 订单包含的商品相关信息(可包含多个商品) commodityId skuId number price discountAmount
	 */
//	@ApiModelProperty(name = "commodities", value = "商户id", example = "订单包含的商品相关信息")
	private List<OrderCommodityMiddleEntity> commodities;

	/**
	 * 订单编号
	 */
	@ApiModelProperty(name = "orderNumber", value = "订单编号", example = "订单编号", hidden = true)
	private String orderNumber;

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
	 * 订单件数（所有商品数量的总和）
	 */
	@ApiModelProperty(name = "orderNumberPieces", value = "订单件数", example = "订单件数", hidden = true)
	private Integer orderNumberPieces;

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

	/**
	 * 备注
	 */
	@ApiModelProperty(name = "orderRemark", value = "备注", example = "备注")
	private String orderRemark;

	/**
	 * 提交时间
	 */
	@ApiModelProperty(name = "orderSubmissionTime", value = "提交时间", example = "提交时间", hidden = true)
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date orderSubmissionTime;

	/**
	 * 删除标识（新增时默认为0正常；1删除）
	 */
	@ApiModelProperty(name = "orderRemove", value = "删除标识", example = "删除标识", hidden = true)
	private Integer orderRemove;

	/**
	 * 收件人
	 */
	@ApiModelProperty(name = "logisticsRecipient", value = "收件人", example = "收件人")
	private String logisticsRecipient;

	/**
	 * 收件人手机号
	 */
	@ApiModelProperty(name = "logisticsRecipientPhone", value = "收件人手机号", example = "收件人手机号")
	private String logisticsRecipientPhone;

	/**
	 * 收件人地址
	 */
	@ApiModelProperty(name = "logisticsRecipientAddress", value = "收件人地址", example = "收件人地址")
	private String logisticsRecipientAddress;

	/**
	 * 收件人邮编
	 */
	@ApiModelProperty(name = "logisticsRecipientPostcode", value = "收件人邮编", example = "收件人邮编")
	private String logisticsRecipientPostcode;
	
	/**
	 * 数据库中暂无此字段，需要新增
	 */
	@ApiModelProperty(name = "logisticsFreight", value = "物流运费", example = "物流运费")
	private BigDecimal logisticsFreight;
	
}
