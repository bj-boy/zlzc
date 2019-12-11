package com.zlzc.modules.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.commodity.entity.CommodityAlbumEntity;
import com.zlzc.modules.commodity.vo.CommodityAlbumVo;

import java.util.Collection;
import java.util.Map;

/**
 * 
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
public interface CommodityAlbumService extends IService<CommodityAlbumEntity> {

	PageUtils queryPage(Map<String, Object> params);

	boolean saveBatchSub(Collection<CommodityAlbumVo> entityList, int batchSize);
}
