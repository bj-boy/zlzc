package com.zlzc.modules.order.order_commodity_middle.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.order.order_commodity_middle.dao.OrderCommodityMiddleDao;
import com.zlzc.modules.order.order_commodity_middle.entity.OrderCommodityMiddleEntity;
import com.zlzc.modules.order.order_commodity_middle.service.OrderCommodityMiddleService;


@Service("orderCommodityMiddleService")
public class OrderCommodityMiddleServiceImpl extends ServiceImpl<OrderCommodityMiddleDao, OrderCommodityMiddleEntity> implements OrderCommodityMiddleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderCommodityMiddleEntity> page = this.page(
                new Query<OrderCommodityMiddleEntity>().getPage(params),
                new QueryWrapper<OrderCommodityMiddleEntity>()
        );

        return new PageUtils(page);
    }

}
