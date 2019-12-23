package com.zlzc.modules.commodity.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品-价格-中间表
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-17 15:53:14
 */
@Data
@TableName("zlzc_commodity_price_middle")
@Accessors(chain = true)
public class CommodityPriceMiddleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long middleId;
	/**
	 * 价格ID
	 */
	private Long priceId;
	/**
	 * 商品ID
	 */
	private Long commodityId;
	/**
	 * 创建时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 操作人
	 */
	private String operator;

}
