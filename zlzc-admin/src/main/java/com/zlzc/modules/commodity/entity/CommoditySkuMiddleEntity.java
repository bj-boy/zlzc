package com.zlzc.modules.commodity.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品-SKU-中间表
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-17 15:53:14
 */
@Data
@TableName("zlzc_commodity_sku_middle")
@Accessors(chain = true)
public class CommoditySkuMiddleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@ApiModelProperty(name = "middleId", value = "id", example = "id")
	@TableId
	private Long middleId;
	/**
	 * 库存ID
	 */
	@ApiModelProperty(name = "repoId", value = "库存ID", example = "库存ID")
	private Long repoId;
	/**
	 * 相册ID
	 */
	@ApiModelProperty(name = "albumId", value = "相册ID", example = "相册ID")
	private Long albumId;
	/**
	 * 价格ID
	 */
	@ApiModelProperty(name = "priceId", value = "价格ID", example = "价格ID")
	private Long priceId;
	/**
	 * SKU ID
	 */
	@ApiModelProperty(name = "skuId", value = "SKU ID", example = "SKU ID")
	private Long skuId;
	/**
	 * 商品ID
	 */
	@ApiModelProperty(name = "commodityId", value = "商品ID", example = "商品ID")
	private Long commodityId;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "创建时间")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "updateTime", value = "更新时间", example = "更新时间")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "操作人")
	private String operator;

}
