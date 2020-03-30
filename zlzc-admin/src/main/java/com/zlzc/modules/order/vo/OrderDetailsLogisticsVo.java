package com.zlzc.modules.order.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(description = "订单详情物流相关返回字段说明")
public class OrderDetailsLogisticsVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 物流id
	 */
	@ApiModelProperty(name = "logisticsId", value = "物流id", example = "物流id")
	private Long logisticsId;

	/**
	 * 物流名称
	 */
	@ApiModelProperty(name = "logisticsName", value = "物流名称", example = "物流名称")
	private String logisticsName;

	/**
	 * 快递单号
	 */
	@ApiModelProperty(name = "logisticsSingleNumber", value = "快递单号", example = "快递单号")
	private String logisticsSingleNumber;

	/**
	 * 配送方式
	 */
	@ApiModelProperty(name = "logisticsDelivery", value = "配送方式", example = "配送方式")
	private Integer logisticsDelivery;

	/**
	 * 发货物流单号
	 */
	@ApiModelProperty(name = "logisticsSerialNumber", value = "发货物流单号", example = "发货物流单号")
	private String logisticsSerialNumber;

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
	
}
