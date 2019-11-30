package com.zlzc.modules.merchant.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商户表
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-11-30 15:07:36
 */
@Data
@TableName("zlzc_merchant")
public class MerchantEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long merchntId;
	/**
	 * 商户账号(系统用户账号)
	 */
	private String merchntAccount;
	/**
	 * 商户名称
	 */
	private String merchntName;
	/**
	 * 商户昵称
	 */
	private String merchntNick;
	/**
	 * 公司名称
	 */
	private String merchntCompanyName;
	/**
	 * 公司注册地址
	 */
	private String merchntRegistAddr;
	/**
	 * 营业执照
	 */
	private String merchntBusiLicenseUrl;
	/**
	 * 供应等级
	 */
	private Integer merchntSupplyLevel;
	/**
	 * 联系人
	 */
	private String merchntLinkman;
	/**
	 * 联系方式
	 */
	private String merchntTel;
	/**
	 * 联系地址
	 */
	private String merchntAddr;
	/**
	 * 所在区域
	 */
	private String merchntRegion;
	/**
	 * 经营模式
	 */
	private Integer merchntMode;
	/**
	 * 经营范围
	 */
	private Integer merchntScope;
	/**
	 * 入驻时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date merchntRegistDate;
	/**
	 * 审核状态
	 */
	private Integer merchntApprovalStatus;
	/**
	 * 商户审核人员
	 */
	private String merchntAuditors;
	/**
	 * 商户审核结果
	 */
	private Integer merchntAuditResults;
	/**
	 * 商户审核反馈
	 */
	private String merchntFeedback;
	/**
	 * 商户审核时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date merchntDate;
	/**
	 * 商户审核详情
	 */
	private String merchntDetails;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date updateTime;
	/**
	 * 操作人
	 */
	private String operator;

}
