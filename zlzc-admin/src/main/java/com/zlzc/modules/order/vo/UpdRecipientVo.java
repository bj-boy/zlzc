package com.zlzc.modules.order.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UpdRecipientVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 物流id
	 */
	@ApiModelProperty(name = "logisticsId", value = "物流id", example = "物流id")
	private Long logisticsId;

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
	 * 收件人账号
	 */
	@ApiModelProperty(name = "logisticsRecipientAccount", value = "收件人账号", example = "收件人账号")
	private String logisticsRecipientAccount;
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
	 * 收件人公司地址
	 */
	@ApiModelProperty(name = "logisticsRecipientCompanyAddress", value = "收件人公司地址", example = "收件人公司地址")
	private String logisticsRecipientCompanyAddress;
	/**
	 * 收件人证件号
	 */
	@ApiModelProperty(name = "logisticsRecipientIdNumber", value = "收件人证件号", example = "收件人证件号")
	private String logisticsRecipientIdNumber;

}
