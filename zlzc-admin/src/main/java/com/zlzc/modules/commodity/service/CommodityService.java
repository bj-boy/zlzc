package com.zlzc.modules.commodity.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.commodity.entity.CommodityEntity;
import com.zlzc.modules.commodity.vo.CommodityVo;

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

}
