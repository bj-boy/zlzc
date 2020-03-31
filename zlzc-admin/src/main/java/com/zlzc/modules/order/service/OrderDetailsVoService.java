package com.zlzc.modules.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.order.entity.OrderEntity;
import com.zlzc.modules.order.entity.vo.OrderDetailsVo;
import com.zlzc.modules.order.entity.vo.saveOrderVo;
import com.zlzc.modules.order.vo.UpdRecipientVo;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OrderDetailsVoService extends IService<OrderEntity> {

	public PageUtils ListGetDetails(Map<String, Object> params, OrderDetailsVo ordeAndLogisticsVo);

	public OrderDetailsVo getOrdeAndLogisticsVoDetails(@Param("id") String id);

	public int saveOrder(OrderDetailsVo orderDetailsVo);

	public boolean updateStatus(OrderDetailsVo orderDetailsVo);

	public boolean removeStatus(List<String> strings);

	public boolean addOrder(saveOrderVo saveOrderVo);

	public com.zlzc.modules.order.vo.OrderDetailsVo getOrderDetails(Long orderId);

	public boolean updCost(Long orderId, Long commodityId, Long skuId, Long logisticsId, BigDecimal discountAmount,
			BigDecimal logisticsFreight);

	public boolean updCommodityInfo(Long orderId, Long commodityId, Long skuId, Integer commodityNumber);

	public boolean updOrderRemark(Long orderId, String orderRemark);

	public String getOrderRemark(Long orderId);

	public boolean closeOrder(Long orderId);

	public boolean updRecipientInfo(UpdRecipientVo updRecipientVo);

}
