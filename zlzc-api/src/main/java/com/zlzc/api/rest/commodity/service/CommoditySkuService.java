package com.zlzc.api.rest.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.api.rest.commodity.entity.*;
import com.zlzc.api.rest.commodity.vo.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

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
