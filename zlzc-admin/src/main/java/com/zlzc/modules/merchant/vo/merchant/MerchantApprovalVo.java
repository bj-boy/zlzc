package com.zlzc.modules.merchant.vo.merchant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MerchantApprovalVo {

	/**
	 * 商户ID
	 */
	@ApiModelProperty(name = "merchantId", value = "商户ID", example = "1")
	private Long merchantId;
	/**
	 * 审核状态
	 */
	@ApiModelProperty(name = "merchantApprovalStatus", value = "审核状态", example = "1")
	private Integer merchantApprovalStatus;

	/**
	 * 商户审核反馈
	 */
	@ApiModelProperty(name = "merchantFeedback", value = "商户审核反馈", example = "提交内容不合格")
	private String merchantFeedback;

}
