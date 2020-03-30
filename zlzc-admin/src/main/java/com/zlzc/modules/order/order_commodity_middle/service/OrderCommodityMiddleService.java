package com.zlzc.modules.order.order_commodity_middle.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.order.order_commodity_middle.entity.OrderCommodityMiddleEntity;

/**
 * 订单商品中间表
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2020-03-29 12:24:57
 */
public interface OrderCommodityMiddleService extends IService<OrderCommodityMiddleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

