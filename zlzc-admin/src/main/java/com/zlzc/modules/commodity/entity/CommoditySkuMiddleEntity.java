package com.zlzc.modules.commodity.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
	@TableId
	private Long middleId;
	/**
	 * 库存ID
	 */
	private Long repoId;
	/**
	 * 相册ID
	 */
	private Long albumId;
	/**
	 * 价格ID
	 */
	private Long priceId;
	/**
	 * SKU ID
	 */
	private Long skuId;
	/**
	 * 商品ID
	 */
	private Long commodityId;
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
