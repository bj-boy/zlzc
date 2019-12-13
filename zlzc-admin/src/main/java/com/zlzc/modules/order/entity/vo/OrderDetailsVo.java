package com.zlzc.modules.order.entity.vo;

import com.zlzc.modules.commodity.entity.CommodityEntity;
import com.zlzc.modules.commodity.entity.CommodityPicEntity;
import com.zlzc.modules.commodity.entity.CommodityRepoEntity;
import com.zlzc.modules.logistics.entity.LogisticsEntity;
import com.zlzc.modules.merchant.entity.MerchantEntity;
import com.zlzc.modules.order.entity.OrderEntity;
import com.zlzc.modules.shop.entity.ShopEntity;
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
