package com.zlzc.modules.commodity.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.commodity.entity.CommodityAttrEntity;
import com.zlzc.modules.commodity.entity.CommodityParamEntity;
import com.zlzc.modules.commodity.entity.CommoditySkuEntity;

/**
 * 
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
public interface CommodityAttrService extends IService<CommodityAttrEntity> {

	PageUtils queryPage(Map<String, Object> params);

	PageUtils commodityAttrList(Map<String, Object> params, Long merchantId, Long shopId);

	boolean saveCommodityAttr(CommodityAttrEntity commodityAttr);

	boolean updCommodityAttr(CommodityAttrEntity commodityAttr);

	boolean delCommodityAttr(Long[] commodityAttrIds);

	List<CommodityParamEntity> queryAttrParamByAttrId(Long commodityAttrId);

	List<CommoditySkuEntity> queryAttrSkuByAttrId(Long commodityAttrId);

	boolean updCommodityAttrSku(CommoditySkuEntity commoditySkuEntity);

	boolean updCommodityAttrParam(CommodityParamEntity commodityParamEntity);

	boolean saveCommodityAttrParam(CommodityParamEntity commodityParamEntity);

	boolean saveCommodityAttrSku(CommoditySkuEntity commoditySkuEntity);

	boolean delCommodityAttrParam(Long[] paramIds);

	boolean delCommodityAttrSku(Long[] skuIds);


}
