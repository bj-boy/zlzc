package com.zlzc.modules.commodity.vo;

import java.io.Serializable;
import java.util.List;

import com.zlzc.modules.commodity.entity.CommodityPriceEntity;
import com.zlzc.modules.commodity.entity.CommodityRepoEntity;
import com.zlzc.modules.commodity.entity.CommoditySkuEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommoditySkuVo extends CommoditySkuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private CommodityRepoEntity commodityRepoSku;

	private CommodityAlbumVo commodityAlbumVoSku;

	private List<CommodityPriceEntity> commodityPricesSku;

}
