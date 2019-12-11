package com.zlzc.modules.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface OrderService extends IService<OrderEntity> {

    public OrderEntity getDetails(@Param("number") String number);



    public PageUtils ListGetDetails(Map<String, Object> params, OrderEntity orderEntity);
}
