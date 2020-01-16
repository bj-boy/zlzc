package com.zlzc.api.rest.shopping.vo;


import com.zlzc.api.rest.commodity.entity.*;
import com.zlzc.api.rest.shopping.entity.ShoppingEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class ShoppingVo extends ShoppingEntity implements Serializable {

    /**
     * 商品
     */
    private CommodityEntity commodityEntity;
    /**
     * 商品价格中间
     */
    private CommodityPriceMiddleEntity commodityPriceMiddleEntity;
    /**
     * 价格
     */
    private CommodityPriceEntity commodityPriceEntity;
    /**
     * 图片
     */
    private CommodityPicEntity commodityPicEntity;
    /**
     * 库存
     */
    private CommodityRepoEntity commodityRepoEntity;

}
