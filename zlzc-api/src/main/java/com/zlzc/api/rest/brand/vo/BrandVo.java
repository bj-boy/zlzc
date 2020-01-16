package com.zlzc.api.rest.brand.vo;

import com.zlzc.api.rest.brand.entity.*;
import com.zlzc.api.rest.commodity.entity.*;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class BrandVo extends BrandEntity implements Serializable {
    /**
     * 品牌分类
     */
   public BrandCategoryEntity brandCategoryEntity;
    /**
     * 品牌评价表
     */
   public BrandCommentEntity brandCommentEntity;
    /**
     * 品牌商品关联表
     */
    public BrandGoodsMiddleEntity brandGoodsMiddleEntity;
    /**
     * 品牌店铺关联表
     */
    public BrandMiddleShopEntity brandMiddleShopEntity;

    /**
     * 商品表
     */
    public CommodityEntity commodityEntity;
    /**
     * 商品价格表
     */
    public CommodityPriceEntity commodityPriceEntity;
    /**
     * 商品价格中间表
     */
    public CommodityPriceMiddleEntity commodityPriceMiddleEntity;
    /**
     * 商品图片表
     */
    public CommodityPicEntity commodityPicEntity;
    /**
     *商品相册表
     */
    public CommodityAlbumEntity commodityAlbumEntity;
    /**
     * 店铺表
     */
    public ShopEntity shopEntity;
}
