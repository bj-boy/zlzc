package com.zlzc.modules.merchant.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "商户实体")
@Data
@TableName("zlzc_merchant")
public class MerchantEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商户ID
	 */
	@ApiModelProperty(name = "merchantId", value = "商户ID", example = "商户ID")
	@TableId
	private Long merchantId;
	/**
	 * 商户账号(系统用户账号)
	 */
	@ApiModelProperty(name = "merchantAccount", value = "商户账号", example = "商户账号")
	private String merchantAccount;
	/**
	 * 商户名称
	 */
	@ApiModelProperty(name = "merchantName", value = "商户名称", example = "商户名称")
	private String merchantName;
	/**
	 * 商户昵称
	 */
	@ApiModelProperty(name = "merchantNick", value = "商户昵称", example = "商户昵称")
	private String merchantNick;
	/**
	 * 公司名称
	 */
	@ApiModelProperty(name = "merchantCompanyName", value = "公司名称", example = "公司名称")
	private String merchantCompanyName;
	/**
	 * 公司注册地址
	 */
	@ApiModelProperty(name = "merchantRegistAddr", value = "公司注册地址", example = "公司注册地址")
	private String merchantRegistAddr;
	/**
	 * 营业执照
	 */
	@ApiModelProperty(name = "merchantBusiLicenseUrl", value = "营业执照URL", example = "营业执照URL")
	private String merchantBusiLicenseUrl;
	/**
	 * 供应等级
	 */
	@ApiModelProperty(name = "merchantSupplyLevel", value = "供应等级", example = "供应等级")
	private Integer merchantSupplyLevel;
	/**
	 * 联系人
	 */
	@ApiModelProperty(name = "merchantLinkman", value = "联系人", example = "联系人")
	private String merchantLinkman;
	/**
	 * 联系方式
	 */
	@ApiModelProperty(name = "merchantTel", value = "联系方式", example = "联系方式")
	private String merchantTel;
	/**
	 * 联系地址
	 */
	@ApiModelProperty(name = "merchantAddr", value = "联系地址", example = "联系地址")
	private String merchantAddr;
	/**
	 * 所在区域
	 */
	@ApiModelProperty(name = "merchantRegion", value = "所在区域", example = "所在区域")
	private String merchantRegion;
	/**
	 * 经营模式
	 */
	@ApiModelProperty(name = "merchantMode", value = "经营模式", example = "经营模式")
	private Integer merchantMode;
	/**
	 * 经营范围
	 */
	@ApiModelProperty(name = "merchantScope", value = "经营范围", example = "经营范围")
	private Integer merchantScope;
	/**
	 * 入驻时间
	 */
	@ApiModelProperty(name = "merchantRegistDate", value = "入驻时间", example = "入驻时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date merchantRegistDate;
	/**
	 * 审核状态
	 */
	@ApiModelProperty(name = "merchantApprovalStatus", value = "审核状态", example = "审核状态")
	private Integer merchantApprovalStatus;
	/**
	 * 商户审核人员
	 */
	@ApiModelProperty(name = "merchantAuditors", value = "商户审核人员", example = "商户审核人员")
	private String merchantAuditors;
	/**
	 * 商户审核结果
	 */
	@ApiModelProperty(name = "merchantAuditResults", value = "商户审核结果", example = "商户审核结果")
	private Integer merchantAuditResults;
	/**
	 * 商户审核反馈
	 */
	@ApiModelProperty(name = "merchantFeedback", value = "商户审核反馈", example = "商户审核反馈")
	private String merchantFeedback;

	/**
	 * 商户审核时间
	 */
	@ApiModelProperty(name = "merchantDate", value = "商户审核时间", example = "商户审核时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date merchantDate;
	
	/**
	 * 商户审核详情
	 */
	@ApiModelProperty(name = "merchantDetails", value = "商户审核详情", example = "商户审核详情")
	private String merchantDetails;
	
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "updateTime", value = "更新时间", example = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "操作人")
	private String operator;

}
