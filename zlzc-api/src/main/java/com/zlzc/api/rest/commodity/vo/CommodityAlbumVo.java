package com.zlzc.api.rest.commodity.vo;

import com.zlzc.api.rest.commodity.entity.CommodityAlbumEntity;
import com.zlzc.api.rest.commodity.entity.CommodityPicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommodityAlbumVo extends CommodityAlbumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<CommodityPicEntity> commodityPics;
}
