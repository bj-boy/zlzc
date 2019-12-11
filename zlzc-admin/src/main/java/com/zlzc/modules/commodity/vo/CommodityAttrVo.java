package com.zlzc.modules.commodity.vo;

import java.util.List;

import com.zlzc.modules.commodity.entity.CommodityAttrEntity;
import com.zlzc.modules.commodity.entity.CommodityParamEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CommodityAttrVo extends CommodityAttrEntity {
	private static final long serialVersionUID = 1L;

	List<CommoditySkuVo> commoditySkuVos;

	List<CommodityParamEntity> commodityParams;

}
