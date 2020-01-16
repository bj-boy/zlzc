package com.zlzc.api.rest.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.api.rest.commodity.entity.*;

import java.util.Map;

/**
 *
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
public interface CommodityCategoryService extends IService<CommodityCategoryEntity> {

	PageUtils queryPage(Map<String, Object> params);

	PageUtils commodityCategoryList(Map<String, Object> params, CommodityCategoryEntity commodityCategory);

	PageUtils querySubCommodityCategory(Map<String, Object> params, Long commodityCategoryId);

	boolean saveCommodityCategory(CommodityCategoryEntity commodityCategory);

	boolean updCommodityCategory(CommodityCategoryEntity commodityCategory);

	boolean delCommodityCategory(Long[] commodityCategoryIds);
}
