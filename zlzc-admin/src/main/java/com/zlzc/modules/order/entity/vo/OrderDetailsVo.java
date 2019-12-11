package com.zlzc.modules.order.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zlzc.modules.logistics.entity.LogisticsEntity;
import com.zlzc.modules.order.entity.OrderEntity;
import lombok.Data;

@Data
public class OrderDetailsVo {

    @TableField(exist = false)
    private OrderEntity orderEntity;

    @TableField(exist = false)
    private LogisticsEntity logisticsEntity;


}
