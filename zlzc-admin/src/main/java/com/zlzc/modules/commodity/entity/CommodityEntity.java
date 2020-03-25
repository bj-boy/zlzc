package com.zlzc.modules.commodity.entity;

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
 * 
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Data
@Accessors(chain = true)
@TableName("zlzc_commodity")
public class CommodityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品ID
	 */
	@ApiModelProperty(name = "commodityId", value = "商品ID", example = "1")
	@TableId
	private Long commodityId;
	/**
	 * 商户ID
	 */
	@ApiModelProperty(name = "merchantId", value = "商户ID", example = "1")
	private Long merchantId;
	/**
	 * 店铺ID
	 */
	@ApiModelProperty(name = "shopId", value = "店铺ID", example = "1")
	private Long shopId;
	/**
	 * 品牌ID
	 */
	@ApiModelProperty(name = "brandId", value = "品牌ID", example = "1")
	private Long brandId;
	/**
	 * 商品分类ID
	 */
	@ApiModelProperty(name = "commodityCategoryId", value = "商品分类ID", example = "1")
	private Long commodityCategoryId;
	/**
	 * 商品属性ID
	 */
	@ApiModelProperty(name = "commodityAttrId", value = "商品属性ID", example = "1")
	private Long commodityAttrId;
	/**
	 * 库存ID
	 */
	@ApiModelProperty(name = "commodityRepoId", value = "库存ID", example = "1")
	private Long commodityRepoId;
	/**
	 * 相册ID
	 */
	@ApiModelProperty(name = "comodityAlbumId", value = "相册ID", example = "1")
	private Long comodityAlbumId;
	/**
	 * 商品货号
	 */
	@ApiModelProperty(name = "commodityNo", value = "商品货号", example = "商品货号")
	private Long commodityNo;
	/**
	 * 商品名称
	 */
	@ApiModelProperty(name = "commodityName", value = "商品名称", example = "商品名称")
	private String commodityName;
	/**
	 * 商品副标题
	 */
	@ApiModelProperty(name = "commoditySubName", value = "商品副标题", example = "商品副标题")
	private String commoditySubName;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "commodityOrder", value = "排序", example = "排序")
	private Integer commodityOrder;
	/**
	 * 商品状态
	 */
	@ApiModelProperty(name = "commodityStatus", value = "商品状态  0 : 未审核；1 : 审核通过", example = "商品状态")
	private Integer commodityStatus;
	/**
	 * 国别
	 */
	@ApiModelProperty(name = "countryCode", value = "国别", example = "国别")
	private String countryCode;
	/**
	 * 商品备注
	 */
	@ApiModelProperty(name = "commodityRemark", value = "商品备注", example = "商品备注")
	private String commodityRemark;
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
	
	/**
	 * 删除标识
	 */
	@ApiModelProperty(name = "del", value = "删除标识", example = "0", hidden = true)
	private Integer del;
	
	/**
	 * <pre>
	 * 商品标签，可以为多个，用逗号分隔
	 * </pre>
	 */
	@ApiModelProperty(name = "commodityLabel", value = "商品标签  0：上架；1：下架；2：新品；3：推荐", example = "0,1,2", hidden = true)
	private String commodityLabel;
}
