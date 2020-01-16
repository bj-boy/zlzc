package com.zlzc.api.rest.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.api.rest.commodity.entity.*;

import java.util.Map;

/**
 * 商品-价格-中间表
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-17 15:53:14
 */
public interface CommodityPriceMiddleService extends IService<CommodityPriceMiddleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

