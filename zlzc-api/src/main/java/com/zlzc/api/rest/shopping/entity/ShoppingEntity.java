package com.zlzc.api.rest.shopping.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 购物车
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-15 11:03:02
 */
@Data
@TableName("zlzc_shopping")
public class ShoppingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId

	private Long shoppingId;
	/**
	 * 商品id
	 */
	private Long commodityId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 创建时间
	 */
	private Date shoppingTime;
	/**
	 * 商品最终的sku属性
	 */
	private  String  commoditySku;
	/**
	 * 商品数量
	 */
	private Integer commodityQuantity;

}
