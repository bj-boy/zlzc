package com.zlzc.modules.merchant.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
	 * ID
	 */
	@ApiModelProperty(name = "merchntId", value = "商户ID", example = "001")
	@TableId
	private Long merchntId;
	/**
	 * 商户账号(系统用户账号)
	 */
	@ApiModelProperty(name = "merchntAccount", value = "商户账号", example = "123556822")
	private String merchntAccount;
	/**
	 * 商户名称
	 */
	@ApiModelProperty(name = "merchntName", value = "商户名称", example = "张三")
	private String merchntName;
	/**
	 * 商户昵称
	 */
	@ApiModelProperty(name = "merchntNick", value = "商户昵称", example = "大仙儿")
	private String merchntNick;
	/**
	 * 公司名称
	 */
	@ApiModelProperty(name = "merchntCompanyName", value = "公司名称", example = "xxx公司")
	private String merchntCompanyName;
	/**
	 * 公司注册地址
	 */
	@ApiModelProperty(name = "merchntRegistAddr", value = "公司注册地址", example = "北京市-昌平区-回龙观")
	private String merchntRegistAddr;
	/**
	 * 营业执照
	 */
	@ApiModelProperty(name = "merchntBusiLicenseUrl", value = "营业执照URL", example = "http://sss.com/xxx.jpg")
	private String merchntBusiLicenseUrl;
	/**
	 * 供应等级
	 */
	@ApiModelProperty(name = "merchntSupplyLevel", value = "供应等级", example = "1")
	private Integer merchntSupplyLevel;
	/**
	 * 联系人
	 */
	@ApiModelProperty(name = "merchntLinkman", value = "联系人", example = "佘仙儿")
	private String merchntLinkman;
	/**
	 * 联系方式
	 */
	@ApiModelProperty(name = "merchntTel", value = "联系方式", example = "15200000000")
	private String merchntTel;
	/**
	 * 联系地址
	 */
	@ApiModelProperty(name = "merchntAddr", value = "联系地址", example = "xxx家园201号")
	private String merchntAddr;
	/**
	 * 所在区域
	 */
	@ApiModelProperty(name = "merchntRegion", value = "所在区域", example = "北京市-昌平区-回龙观")
	private String merchntRegion;
	/**
	 * 经营模式
	 */
	@ApiModelProperty(name = "merchntMode", value = "经营模式", example = "1")
	private Integer merchntMode;
	/**
	 * 经营范围
	 */
	@ApiModelProperty(name = "merchntScope", value = "经营范围", example = "2")
	private Integer merchntScope;
	/**
	 * 入驻时间
	 */
	@ApiModelProperty(name = "merchntRegistDate", value = "入驻时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date merchntRegistDate;
	/**
	 * 审核状态
	 */
	@ApiModelProperty(name = "merchntApprovalStatus", value = "审核状态", example = "2")
	private Integer merchntApprovalStatus;
	/**
	 * 商户审核人员
	 */
	@ApiModelProperty(name = "merchntAuditors", value = "商户审核人员", example = "admin")
	private String merchntAuditors;
	/**
	 * 商户审核结果
	 */
	@ApiModelProperty(name = "merchntAuditResults", value = "商户审核结果", example = "1")
	private Integer merchntAuditResults;
	/**
	 * 商户审核反馈
	 */
	@ApiModelProperty(name = "merchntFeedback", value = "商户审核反馈", example = "图片不合格")
	private String merchntFeedback;
	
	/**
	 * 商户审核时间
	 */
	@ApiModelProperty(name = "merchntDate", value = "商户审核时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date merchntDate;
	/**
	 * 商户审核详情
	 */
	@ApiModelProperty(name = "merchntDetails", value = "商户审核详情", example = "图片不合格,请从新是上传图片")
	private String merchntDetails;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "updateTime", value = "更新时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "admin")
	private String operator;

}
