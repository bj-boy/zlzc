package com.zlzc.api.rest.commodity.vo;

import com.zlzc.api.rest.commodity.entity.CommodityPriceEntity;
import com.zlzc.api.rest.commodity.entity.CommodityRepoEntity;
import com.zlzc.api.rest.commodity.entity.CommoditySkuEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommoditySkuVo extends CommoditySkuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private CommodityRepoEntity commodityRepoSku;

	private CommodityAlbumVo commodityAlbumVoSku;

	private List<CommodityPriceEntity> commodityPricesSku;

}
