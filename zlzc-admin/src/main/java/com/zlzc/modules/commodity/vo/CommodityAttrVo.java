package com.zlzc.modules.commodity.vo;

import java.util.List;

import com.zlzc.modules.commodity.entity.CommodityAttrEntity;
import com.zlzc.modules.commodity.entity.CommodityParamEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommodityAttrVo extends CommodityAttrEntity {
	private static final long serialVersionUID = 1L;

	List<CommoditySkuVo> commoditySkuVos;

	List<CommodityParamEntity> commodityParams;

}
