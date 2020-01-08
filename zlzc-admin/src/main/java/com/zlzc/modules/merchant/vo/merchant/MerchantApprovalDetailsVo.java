package com.zlzc.modules.merchant.vo.merchant;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
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

	// ####### 商户属性 ####### // 

	/**
	 * 商户账号(系统用户账号)
	 */
	@ApiModelProperty(name = "merchantAccount", value = "商户账号", example = "123556822")
	private String merchantAccount;
	/**
	 * 商户名称
	 */
	@ApiModelProperty(name = "merchantName", value = "商户名称", example = "张三")
	private String merchantName;
	/**
	 * 商户昵称
	 */
	@ApiModelProperty(name = "merchantNick", value = "商户昵称", example = "大仙儿")
	private String merchantNick;
	/**
	 * 公司名称
	 */
	@ApiModelProperty(name = "merchantCompanyName", value = "公司名称", example = "xxx公司")
	private String merchantCompanyName;
	/**
	 * 公司注册地址
	 */
	@ApiModelProperty(name = "merchantRegistAddr", value = "公司注册地址", example = "北京市-昌平区-回龙观")
	private String merchantRegistAddr;
	/**
	 * 营业执照
	 */
	@ApiModelProperty(name = "merchantBusiLicenseUrl", value = "营业执照URL", example = "http://sss.com/xxx.jpg")
	private String merchantBusiLicenseUrl;
	/**
	 * 供应等级
	 */
	@ApiModelProperty(name = "merchantSupplyLevel", value = "供应等级", example = "1")
	private Integer merchantSupplyLevel;
	/**
	 * 联系人
	 */
	@ApiModelProperty(name = "merchantLinkman", value = "联系人", example = "佘仙儿")
	private String merchantLinkman;
	/**
	 * 联系方式
	 */
	@ApiModelProperty(name = "merchantTel", value = "联系方式", example = "15200000000")
	private String merchantTel;
	/**
	 * 联系地址
	 */
	@ApiModelProperty(name = "merchantAddr", value = "联系地址", example = "xxx家园201号")
	private String merchantAddr;
	/**
	 * 所在区域
	 */
	@ApiModelProperty(name = "merchantRegion", value = "所在区域", example = "北京市-昌平区-回龙观")
	private String merchantRegion;
	/**
	 * 经营模式
	 */
	@ApiModelProperty(name = "merchantMode", value = "经营模式", example = "1")
	private Integer merchantMode;
	/**
	 * 经营范围
	 */
	@ApiModelProperty(name = "merchantScope", value = "经营范围", example = "2")
	private Integer merchantScope;
	/**
	 * 入驻时间
	 */
	@ApiModelProperty(name = "merchantRegistDate", value = "入驻时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date merchantRegistDate;

}
