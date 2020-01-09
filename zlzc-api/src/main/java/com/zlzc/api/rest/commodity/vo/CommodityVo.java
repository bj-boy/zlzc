package com.zlzc.api.rest.commodity.vo;


import com.zlzc.api.rest.commodity.entity.*;
import com.zlzc.api.rest.merchant.entity.MerchantEntity;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class CommodityVo extends CommodityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private MerchantEntity merchant;

	private ShopEntity shop;

	private CommodityCategoryEntity commodityCategory;

	private CommodityRepoEntity commodityRepo;

	private CommodityAttrVo commodityAttrVo;

	private CommodityAlbumVo commodityAlbumVo;

	private List<CommodityPriceEntity> commodityPrices;

	private List<CommodityDetailEntity> commodityDetails;
}
