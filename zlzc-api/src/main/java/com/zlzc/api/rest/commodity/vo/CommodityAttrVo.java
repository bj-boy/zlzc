package com.zlzc.api.rest.commodity.vo;

import com.zlzc.api.rest.commodity.entity.CommodityAttrEntity;
import com.zlzc.api.rest.commodity.entity.CommodityParamEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommodityAttrVo extends CommodityAttrEntity {
	private static final long serialVersionUID = 1L;

	List<CommoditySkuVo> commoditySkuVos;

	List<CommodityParamEntity> commodityParams;

}
