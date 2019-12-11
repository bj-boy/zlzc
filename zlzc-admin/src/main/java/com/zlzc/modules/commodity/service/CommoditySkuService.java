package com.zlzc.modules.commodity.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.commodity.entity.CommoditySkuEntity;
import com.zlzc.modules.commodity.vo.CommoditySkuVo;

/**
 * 
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
public interface CommoditySkuService extends IService<CommoditySkuEntity> {

	PageUtils queryPage(Map<String, Object> params);

	@Transactional(rollbackFor = Exception.class)
	boolean saveBatchSub(Collection<CommoditySkuVo> entityList, int batchSize);

}
