package com.zlzc.modules.commodity.vo;

import java.io.Serializable;
import java.util.List;

import com.zlzc.modules.commodity.entity.CommodityCategoryEntity;
import com.zlzc.modules.commodity.entity.CommodityDetailEntity;
import com.zlzc.modules.commodity.entity.CommodityEntity;
import com.zlzc.modules.commodity.entity.CommodityPriceEntity;
import com.zlzc.modules.commodity.entity.CommodityRepoEntity;
import com.zlzc.modules.merchant.entity.MerchantEntity;
import com.zlzc.modules.shop.entity.ShopEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
	
	private CommodityLabelVo commodityLabelVo;
}
