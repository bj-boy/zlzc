package com.zlzc.api.rest.order.entity.vo;


import com.zlzc.api.rest.commodity.entity.CommodityEntity;
import com.zlzc.api.rest.commodity.entity.CommodityRepoEntity;
import com.zlzc.api.rest.logistics.entity.LogisticsEntity;
import com.zlzc.api.rest.merchant.entity.MerchantEntity;
import com.zlzc.api.rest.order.entity.OrderEntity;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import lombok.Data;

import java.io.Serializable;


@Data
public class OrderDetailsVo extends OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 物流
     */
    private LogisticsEntity logisticsEntity;
    /**
     * 商品
     */
    private CommodityEntity commodityEntity;
    /**
     *商户
     */
    private MerchantEntity merchantEntity;
    /**
     * 店铺
     */
    private ShopEntity shopEntity;
    /**
     * 库存
     */
    private CommodityRepoEntity commodityRepoEntity;
}
