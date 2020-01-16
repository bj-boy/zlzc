package com.zlzc.api.rest.shop.vo;

import com.zlzc.api.rest.brand.entity.BrandEntity;
import com.zlzc.api.rest.commodity.entity.CommodityCategoryEntity;
import com.zlzc.api.rest.commodity.entity.CommodityEntity;
import com.zlzc.api.rest.commodity.entity.CommodityPicEntity;
import com.zlzc.api.rest.commodity.entity.CommodityPriceEntity;
import com.zlzc.api.rest.merchant.entity.MerchantEntity;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import com.zlzc.api.rest.user.entity.UserEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class ShopVo extends ShopEntity implements Serializable{

    /**
     * 用户
     */
    private UserEntity  userEntity;
    /**
     * 商品
     */
    private CommodityEntity commodityEntity;
    /**
     * 价格
     */
    private CommodityPriceEntity commodityPriceEntity;
    /**
     * 图片
     */
    private CommodityPicEntity commodityPicEntity;

    /**
     * 品牌
     */
    private BrandEntity brandEntity;
    /**
     * 商品分类
     */
    private CommodityCategoryEntity commodityCategoryEntity;

    /**
     * 商户
     */
    private  MerchantEntity merchantEntity;
}
