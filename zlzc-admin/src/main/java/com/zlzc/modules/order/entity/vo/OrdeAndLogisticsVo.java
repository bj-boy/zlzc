package com.zlzc.modules.order.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zlzc.modules.logistics.entity.LogisticsEntity;
import com.zlzc.modules.order.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
public class OrdeAndLogisticsVo implements Serializable {

    @TableField(exist = false)
    private OrderEntity orderEntity;

    @TableField(exist = false)
    private LogisticsEntity logisticsEntity;

}
