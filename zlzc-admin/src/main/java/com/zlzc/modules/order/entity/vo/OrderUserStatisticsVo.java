package com.zlzc.modules.order.entity.vo;


import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户订单统计指标实体
 */
@ApiModel(description = "用户订单统计指标实体")
@Data
public class OrderUserStatisticsVo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 订单总金额
     */
    @ApiModelProperty(name = "totalAmount", value = "用户消费总金额", example = "2000.12")
     private BigDecimal totalAmount;
    /**
     * 订单件数
     */
    @ApiModelProperty(name = "orderCnt", value = "订单数量", example = "10")
     private Integer orderCnt;
}
