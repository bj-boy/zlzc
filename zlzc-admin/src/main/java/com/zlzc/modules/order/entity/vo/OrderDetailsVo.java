package com.zlzc.modules.order.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zlzc.modules.commodity.entity.CommodityEntity;
import com.zlzc.modules.logistics.entity.LogisticsEntity;
import com.zlzc.modules.merchant.entity.MerchantEntity;
import com.zlzc.modules.order.entity.OrderEntity;
import com.zlzc.modules.shop.entity.ShopEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
public class OrderDetailsVo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 订单
     */
    private OrderEntity orderEntity;
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
}
