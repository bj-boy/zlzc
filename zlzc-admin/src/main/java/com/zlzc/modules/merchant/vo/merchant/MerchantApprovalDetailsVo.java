package com.zlzc.modules.merchant.vo.merchant;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 商户审核详情表
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-04 16:52:38
 */
@Data
public class MerchantApprovalDetailsVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private Long merchantApprovalDetailsId;
	/**
	 * 商户ID
	 */
	private Long merchantId;
	/**
	 * 审核状态
	 */
	private Integer merchantApprovalStatus;
	/**
	 * 商户审核人员
	 */
	private String merchantAuditors;
	/**
	 * 商户审核反馈
	 */
	private String merchantFeedback;
	/**
	 * 商户审核时间
	 */
	private Date merchantDate;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 操作人
	 */
	private String operator;
	/**
	 * 商户账号
	 */
	private String merchantAccount;
	/**
	 * 商户名称
	 */
	private String merchantName;
	/**
	 * 商户公司名称
	 */
	private String merchantCompanyName;



}
