package com.zlzc.api.rest.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.commodity.entity.CommodityEntity;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.api.rest.commodity.vo.*;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
public interface CommodityService extends IService<CommodityEntity> {

	PageUtils queryPage(Map<String, Object> params);

	boolean saveCommodity(CommodityVo commodity);

	List<CommodityVo> queryCommodity();

	boolean delCommodities(Long[] commodityIds);

	boolean updCommodity(CommodityVo commodity);

	boolean updCommodityStatus(CommodityEntity commodity);

	List<Map<String, Object>> commodityStatusStatistics(Long merchantId, Long shopId);

	boolean transferCommodityByCommodityCategory(Long merchantId, Long fromCommodityCategoryId,
                                                 Long toCommodityCategoryId);

}
