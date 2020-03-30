package com.zlzc.modules.order.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.order.entity.OrderEntity;
import com.zlzc.modules.order.entity.vo.OrderDetailsVo;
import com.zlzc.modules.order.entity.vo.saveOrderVo;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderDetailsVoService  extends IService<OrderEntity> {

    public PageUtils ListGetDetails(Map<String, Object> params, OrderDetailsVo ordeAndLogisticsVo);

    public OrderDetailsVo getOrdeAndLogisticsVoDetails(@Param("id") String id);

    public  int   saveOrder( OrderDetailsVo orderDetailsVo);

    public   boolean  updateStatus(OrderDetailsVo orderDetailsVo);

    public   boolean  removeStatus(List<String> strings);

    public boolean addOrder(saveOrderVo saveOrderVo);

    public com.zlzc.modules.order.vo.OrderDetailsVo getOrderDetails(Long orderId);

}
