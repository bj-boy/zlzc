package com.zlzc.api.rest.merchant.entity.approvalDetails;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 商户审核详情表
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-04 16:52:38
 */
@Data
@Accessors(chain = true)
@TableName("zlzc_merchant_approval_details")
public class MerchantApprovalDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(name = "merchantApprovalDetailsId", value = "ID", example = "1")
	private Long merchantApprovalDetailsId;
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
	 * 商户审核人员
	 */
	@ApiModelProperty(name = "merchantAuditors", value = "商户审核人员", example = "admin")
	private String merchantAuditors;
	/**
	 * 商户审核反馈
	 */
	@ApiModelProperty(name = "merchantFeedback", value = "商户审核反馈", example = "提交内容不合格")
	private String merchantFeedback;
	/**
	 * 商户审核时间
	 */
	@ApiModelProperty(name = "merchantDate", value = "商户审核时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date merchantDate;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "updateTime", value = "更新时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "admin")
	private String operator;

}
