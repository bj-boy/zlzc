package com.zlzc.modules.commodity.vo;

import java.io.Serializable;
import java.util.List;

import com.zlzc.modules.commodity.entity.CommodityAlbumEntity;
import com.zlzc.modules.commodity.entity.CommodityPicEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommodityAlbumVo extends CommodityAlbumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<CommodityPicEntity> commodityPics;
}
