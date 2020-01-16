package com.zlzc.api.rest.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.commodity.entity.CommodityRepoEntity;
import com.zlzc.common.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
public interface CommodityRepoService extends IService<CommodityRepoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

