package com.zlzc.modules.order.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.order.entity.vo.OrderDetailsVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface OrderDetailsVoService extends IService<OrderDetailsVo> {

    public PageUtils ListGetDetails(Map<String, Object> params, OrderDetailsVo ordeAndLogisticsVo);

    public OrderDetailsVo getOrdeAndLogisticsVoDetails(@Param("id") String id);
}
