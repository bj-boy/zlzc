package com.zlzc.modules.merchant.entity.approvalDetails;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 商户审核详情表
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-04 16:52:38
 */
@Data
@TableName("zlzc_merchant_approval_details")
public class MerchantApprovalDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long merchntApprovalDetailsId;
	/**
	 * 商户ID
	 */
	private Long merchntId;
	/**
	 * 审核状态
	 */
	private Integer merchntApprovalStatus;
	/**
	 * 商户审核人员
	 */
	private String merchntAuditors;
	/**
	 * 商户审核反馈
	 */
	private String merchntFeedback;
	/**
	 * 商户审核时间
	 */
	private Date merchntDate;
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

}
