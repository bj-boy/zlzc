package com.zlzc.modules.order.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.CodeFactory;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.commodity.entity.CommodityEntity;
import com.zlzc.modules.commodity.entity.CommodityRepoEntity;
import com.zlzc.modules.commodity.entity.CommoditySkuEntity;
import com.zlzc.modules.commodity.service.CommodityRepoService;
import com.zlzc.modules.commodity.service.CommodityService;
import com.zlzc.modules.commodity.service.CommoditySkuService;
import com.zlzc.modules.logistics.entity.LogisticsEntity;
import com.zlzc.modules.logistics.service.LogisticsService;
import com.zlzc.modules.merchant.entity.MerchantEntity;
import com.zlzc.modules.merchant.service.MerchantService;
import com.zlzc.modules.order.dao.OrderDao;
import com.zlzc.modules.order.entity.OrderEntity;
import com.zlzc.modules.order.entity.vo.OrderDetailsVo;
import com.zlzc.modules.order.entity.vo.saveOrderVo;
import com.zlzc.modules.order.order_commodity_middle.entity.OrderCommodityMiddleEntity;
import com.zlzc.modules.order.order_commodity_middle.service.OrderCommodityMiddleService;
import com.zlzc.modules.order.service.OrderDetailsVoService;
import com.zlzc.modules.order.vo.OrderDetailsCommodity;
import com.zlzc.modules.order.vo.OrderDetailsLogisticsVo;
import com.zlzc.modules.order.vo.UpdRecipientVo;
import com.zlzc.modules.shop.entity.ShopEntity;
import com.zlzc.modules.shop.service.ShopService;

import lombok.extern.slf4j.Slf4j;

@Service("ordeAndLogisticsService")
@Slf4j
public class OrderDetailsVoServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderDetailsVoService {

	@Autowired
	private LogisticsService logisticsService;
	@Autowired
	private CommodityRepoService commodityRepoService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private CommoditySkuService commoditySkuService;

	@Autowired
	private OrderCommodityMiddleService orderCommodityMiddleService;

	@Autowired
	private MerchantService merchantService;
	@Autowired
	private ShopService shopService;

	@Override
	public PageUtils ListGetDetails(Map<String, Object> params, OrderDetailsVo ordeAndLogisticsVo) {

		QueryWrapper<OrderDetailsVo> wq = new QueryWrapper<OrderDetailsVo>()
				// 未删除
				.eq("o.order_remove", 0)
				// 订单号
				.eq(StringUtils.isNotBlank(ordeAndLogisticsVo.getOrderNumber()), "o.order_number",
						ordeAndLogisticsVo.getOrderNumber())
				// 提交时间
				.eq(ordeAndLogisticsVo.getOrderSubmissionTime() != null, "o.order_submission_time",
						ordeAndLogisticsVo.getOrderSubmissionTime())
				// 订单状态
				.eq(ordeAndLogisticsVo.getOrderStatus() != null, "o.order_status", ordeAndLogisticsVo.getOrderStatus())
				// 订单来源
				.eq(ordeAndLogisticsVo.getOrderSource() != null, "o.order_source", ordeAndLogisticsVo.getOrderStatus());
		if (ordeAndLogisticsVo != null) {
			// 收货人
			if (Objects.nonNull(ordeAndLogisticsVo.getLogisticsEntity())) {
				wq.like("l.logistics_recipient", ordeAndLogisticsVo.getLogisticsEntity().getLogisticsRecipient());
			}
			// 店铺名称
			if (Objects.nonNull(ordeAndLogisticsVo.getLogisticsEntity())) {
				wq.like(Objects.nonNull(ordeAndLogisticsVo.getLogisticsEntity()), "s.shop_name",
						ordeAndLogisticsVo.getShopEntity().getShopName());
			}
		}

		IPage<OrderDetailsVo> page = baseMapper.queryPageByCondition(new Query<OrderDetailsVo>().getPage(params), wq);

		return new PageUtils(page);
	}

	@Override
	public OrderDetailsVo getOrdeAndLogisticsVoDetails(String id) {
		OrderDetailsVo ordeAndLogisticsVo = null;

		if (StringUtils.isBlank(id)) {
			return new OrderDetailsVo();
		}

		QueryWrapper<OrderDetailsVo> wq = new QueryWrapper<OrderDetailsVo>();
		wq.eq(id != null, "o.order_number", id).eq("o.order_remove", 0);

		ordeAndLogisticsVo = baseMapper.queryApprovalDetails(wq);

		if (Objects.isNull(ordeAndLogisticsVo)) {
			QueryWrapper<OrderDetailsVo> wq1 = new QueryWrapper<OrderDetailsVo>();
			wq1.eq(id != null, "o.order_id", id).eq("o.order_remove", 0);
			ordeAndLogisticsVo = baseMapper.queryApprovalDetails(wq1);
		}
		return ordeAndLogisticsVo;

	}

	@Override
	public com.zlzc.modules.order.vo.OrderDetailsVo getOrderDetails(Long orderId) {
		// @formatter:off
		com.zlzc.modules.order.vo.OrderDetailsVo orderDetailsVo = new com.zlzc.modules.order.vo.OrderDetailsVo();

		if (orderId == null) {
			return orderDetailsVo;
		}

		// 查询订单基本信息
		OrderEntity orderEntity = getById(orderId);
		if (orderEntity == null) {
			return orderDetailsVo;
		}
		orderDetailsVo
			.setOrderId(orderEntity.getOrderId())
			.setOrderNumber(orderEntity.getOrderNumber())
			.setOrderRemark(orderEntity.getOrderRemark())
			.setOrderPayable(orderEntity.getOrderPayable())
			.setOrderTotalAmount(orderEntity.getOrderTotalAmount())
			.setOrderCommodityTotalAmount(orderEntity.getOrderCommodityTotalAmount())
			.setOrderPaymentStatus(orderEntity.getOrderPaymentStatus())
			.setOrderPaymentMethod(orderEntity.getOrderPaymentMethod())
			.setOrderSource(orderEntity.getOrderSource())
			.setOrderStatus(orderEntity.getOrderStatus());

		// 查询订单所属商户和店铺信息
		MerchantEntity merchantEntity = merchantService.getById(orderEntity.getMerchantId());
		ShopEntity shopEntity = shopService.getById(orderEntity.getShopId());
		if (merchantEntity != null) {
			orderDetailsVo
				.setMerchantId(orderEntity.getMerchantId())
				.setMerchantName(merchantEntity.getMerchantName());
		}
		if (shopEntity != null) {
			orderDetailsVo
				.setShopId(orderEntity.getShopId())
				.setShopName(shopEntity.getShopName());
		}
		
		// 查询物流相关信息
		QueryWrapper<LogisticsEntity> logisticsQW = new QueryWrapper<>();
		logisticsQW.eq("order_number", orderEntity.getOrderNumber());
		LogisticsEntity logisticsEntity = logisticsService.getOne(logisticsQW);
		orderDetailsVo
			.setLogisticsFreight(logisticsEntity.getLogisticsFreight())
			.setOrderDetailsLogistics(new OrderDetailsLogisticsVo()
						.setLogisticsId(logisticsEntity.getLogisticsId())
						.setLogisticsName(logisticsEntity.getLogisticsName())
						.setLogisticsSingleNumber(logisticsEntity.getLogisticsSingleNumber())
						.setLogisticsDelivery(logisticsEntity.getLogisticsDelivery())
						.setLogisticsSerialNumber(logisticsEntity.getLogisticsSerialNumber())
						.setLogisticsRecipient(logisticsEntity.getLogisticsRecipient())
						.setLogisticsRecipientPhone(logisticsEntity.getLogisticsRecipientPhone())
						.setLogisticsRecipientAddress(logisticsEntity.getLogisticsRecipientAddress())
						.setLogisticsRecipientPostcode(logisticsEntity.getLogisticsRecipientPostcode())
					);

		// 查询订单商品相关信息
		QueryWrapper<OrderCommodityMiddleEntity> ocmQW = new QueryWrapper<>();
		ocmQW.eq("order_id", orderEntity.getOrderId());
		List<OrderCommodityMiddleEntity> ocmList = orderCommodityMiddleService.list(ocmQW);
		ocmList.forEach(orderCommodityMiddleEntity -> {
			orderDetailsVo.setDiscountAmount(orderCommodityMiddleEntity.getDiscountAmount()); // 设置优惠价格
			Long commodityId = orderCommodityMiddleEntity.getCommodityId();
			Long skuId = orderCommodityMiddleEntity.getSkuId();
			CommodityEntity commodityEntity = commodityService.getById(commodityId);
			CommoditySkuEntity skuEntity = commoditySkuService.getById(skuId);
			List<OrderDetailsCommodity> orderDetailsCommodities = orderDetailsVo.getOrderDetailsCommodities();
			OrderDetailsCommodity orderDetailsCommodity = new OrderDetailsCommodity()
					.setId(orderCommodityMiddleEntity.getId()).setCommodityId(commodityId)
					.setCommodityName(commodityEntity.getCommodityName())
					.setCommodityNo(commodityEntity.getCommodityNo()).setSkuId(skuId).setSkuName(skuEntity.getSkuName())
					.setCommodityNumber(orderCommodityMiddleEntity.getCommodityNumber())
					.setCommodityPrice(orderCommodityMiddleEntity.getCommodityPrice());
			if (orderDetailsCommodities == null) {
				orderDetailsCommodities = new ArrayList<OrderDetailsCommodity>() {
					{
						add(orderDetailsCommodity);
					}
				};
			} else {
				orderDetailsCommodities.add(orderDetailsCommodity);
			}
			orderDetailsVo.setOrderDetailsCommodities(orderDetailsCommodities);
		});
		// @formatter:on
		return orderDetailsVo;
	}

	/**
	 * 0 创建订单成功 1 对象为空 2 用户id 商品id 不能为空 3 商品id 不存在 4 库存不足
	 * 
	 * @param orderDetailsVo
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int saveOrder(OrderDetailsVo orderDetailsVo) {

		if (Objects.isNull(orderDetailsVo)) {
			return 1;
		}
		if (StringUtils.isBlank(orderDetailsVo.getUserId() + "")
				|| StringUtils.isBlank(orderDetailsVo.getCommobityId() + "")) {
			return 2;
		}

		String orderCode = new CodeFactory().getOrderCode(orderDetailsVo.getUserId());
		CommodityEntity commodityEntity = null;

		// 商品判断
		if (StringUtils.isNotBlank(orderDetailsVo.getCommobityId() + "")) {

			QueryWrapper<CommodityEntity> wq = new QueryWrapper<CommodityEntity>().eq("commodity_id",
					orderDetailsVo.getCommobityId());
			commodityEntity = commodityService.getOne(wq);
			System.out.println(commodityEntity);
			orderDetailsVo.setMerchantId(commodityEntity.getMerchantId());
			orderDetailsVo.setShopId(commodityEntity.getShopId());
			orderDetailsVo.setOrderRemove(0);
		} else {
			return 3;
		}
		// 查看商品库存
		QueryWrapper<CommodityRepoEntity> cwq = new QueryWrapper<CommodityRepoEntity>().eq("commodity_repertory_id",
				commodityEntity.getCommodityRepoId());
		CommodityRepoEntity one = commodityRepoService.getOne(cwq);
		if (one.getRepoStock() < 0) {
			return 4;
		}

		orderDetailsVo.setOrderNumber(orderCode);
		orderDetailsVo.setOrderSubmissionTime(new Date());
		orderDetailsVo.getLogisticsEntity().setOrderNumber(orderCode);

		baseMapper.insert(orderDetailsVo);
		logisticsService.save(orderDetailsVo.getLogisticsEntity());

		return 0;
	}

	/**
	 * 
	 * @param saveOrderVo
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean addOrder(saveOrderVo saveOrderVo) {
		if (Objects.isNull(saveOrderVo)) {
			return false;
		}
		// @formatter:off
		
		// 设置订单中各个字段的值
		String orderCode = new CodeFactory().getOrderCode(saveOrderVo.getUserId());
		OrderEntity order = new OrderEntity()
				.setShopId(saveOrderVo.getShopId())
				.setUserId(saveOrderVo.getUserId())
				.setMerchantId(saveOrderVo.getMerchantId())
				.setOrderPaymentStatus(0)
				.setOrderSource(saveOrderVo.getOrderSource())
				.setOrderStatus(0)
				.setOrderRemark(saveOrderVo.getOrderRemark())
				.setOrderSubmissionTime(new Date())
				.setOrderRemove(0)
				.setOrderNumber(orderCode);
		
		// 获取订单中的商品并计算价格,保存中间表数据
		List<OrderCommodityMiddleEntity> commodities = saveOrderVo.getCommodities();
		for (OrderCommodityMiddleEntity orderCommodityMiddleEntity : commodities) {
			Long commodityId = orderCommodityMiddleEntity.getCommodityId();
			Long skuId = orderCommodityMiddleEntity.getSkuId();
			Integer number = orderCommodityMiddleEntity.getCommodityNumber();
			BigDecimal price = orderCommodityMiddleEntity.getCommodityPrice();
			BigDecimal discountAmount = orderCommodityMiddleEntity.getDiscountAmount(); // // 优惠金额
			
			/* 缺少参数验证环节 */
			
			// 设置订单应付金额
			if (order.getOrderPayable() != null) {
				order.setOrderPayable(price.multiply(BigDecimal.valueOf(number))
						   .add(order.getOrderPayable())
					 );				
			} else {
				order.setOrderPayable(price.multiply(BigDecimal.valueOf(number)));
			}

			// 设置订单实付金额
			if (order.getOrderTotalAmount() != null) {
				order.setOrderTotalAmount(price.multiply(BigDecimal.valueOf(number))
						   .add(order.getOrderTotalAmount())
						   .subtract(discountAmount)
					 );
			} else {
				order.setOrderTotalAmount(price.multiply(BigDecimal.valueOf(number))
						   .subtract(discountAmount)
					 );
			}

			// 商品合计金额
			if (order.getOrderCommodityTotalAmount() != null) {
				order.setOrderCommodityTotalAmount(price.multiply(BigDecimal.valueOf(number))
						   .add(order.getOrderCommodityTotalAmount())
					 );
			} else {
				order.setOrderCommodityTotalAmount(price.multiply(BigDecimal.valueOf(number)));
			}

			// 订单商品件数
			if (order.getOrderNumberPieces() != null) {
				order.setOrderNumberPieces(order.getOrderNumberPieces() + number);
			} else {
				order.setOrderNumberPieces(number);
			}
		}
		order.setOrderPayable(saveOrderVo.getLogisticsFreight().add(order.getOrderPayable())); // 订单应付金额 + 运费
		order.setOrderTotalAmount(saveOrderVo.getLogisticsFreight().add(order.getOrderTotalAmount())); // 订单实付金额 + 运费
		
		
		// 设置订单关联的物流信息
		LogisticsEntity logisticsEntity = new LogisticsEntity()
				.setLogisticsRecipient(saveOrderVo.getLogisticsRecipient())
				.setLogisticsRecipientPhone(saveOrderVo.getLogisticsRecipientPhone())
				.setLogisticsRecipientAddress(saveOrderVo.getLogisticsRecipientAddress())
				.setLogisticsRecipientPostcode(saveOrderVo.getLogisticsRecipientPostcode())
				.setOrderNumber(order.getOrderNumber())
				.setLogisticsFreight(saveOrderVo.getLogisticsFreight());
		
		/* 暂不考虑商品库存问题（库存是否足够，减库存等操作） */
		
		// 保存订单表，获取orderId
		if (!save(order)) {
			throw new RuntimeException("订单保存异常。");
		}
		// 保存订单商品中间表
		commodities.forEach(commodity -> {
			commodity.setOrderId(order.getOrderId());
		});
		if (!orderCommodityMiddleService.saveBatch(commodities)) {
			throw new RuntimeException("订单中商品信息保存异常。");
		}
		
		
		// 设置物流记录的orderId，保存物流表
		if (!logisticsService.save(logisticsEntity)) {
			throw new RuntimeException("订单物流信息保存异常。");
		}

		// @formatter:on

		return true;
	}

	@Transactional
	@Override
	public boolean updateStatus(OrderDetailsVo orderDetailsVo) {

		if (Objects.isNull(orderDetailsVo)) {
			return false;
		}
		QueryWrapper<OrderEntity> cwq = new QueryWrapper<OrderEntity>().eq("order_id", orderDetailsVo.getOrderId());
		OrderEntity orderEntity = baseMapper.selectOne(cwq);
		if (Objects.isNull(orderEntity)) {
			return false;
		}
		// 订单金额
		orderEntity.setOrderAmount(orderDetailsVo.getOrderAmount());
		// 应付款金额
		orderEntity.setOrderPayable(orderDetailsVo.getOrderPayable());
		// 支付状态
		orderEntity.setOrderPaymentStatus(orderDetailsVo.getOrderPaymentStatus());
		// 支付方式
		orderEntity.setOrderPaymentMethod(orderDetailsVo.getOrderPaymentMethod());
		// 订单来源
		orderEntity.setOrderSource(orderDetailsVo.getOrderSource());
		// 订单状态
		orderEntity.setOrderStatus(orderDetailsVo.getOrderStatus());
		// 订单类型
		orderEntity.setOrderOrderType(orderDetailsVo.getOrderOrderType());

		this.updateById(orderEntity);
		return true;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean removeStatus(List<String> orderIds) {
		for (int i = 0; i < orderIds.size(); i++) {
			QueryWrapper<OrderEntity> cwq = new QueryWrapper<OrderEntity>().eq("order_id", orderIds.get(i));
			OrderEntity orderEntity = baseMapper.selectOne(cwq);
			if (Objects.nonNull(orderEntity)) {
				orderEntity.setOrderRemove(1);
			}
			this.updateById(orderEntity);
		}
		return false;
	}

	/*
	 * ################################### 2020年3月30日15点35分 添加订单相关接口
	 * ###################################
	 */

	/**
	 * 修改订单收货人信息
	 * 
	 * @param updRecipientVo
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean updRecipientInfo(UpdRecipientVo updRecipientVo) {
		if (updRecipientVo.getLogisticsId() == null) {
			log.error("要修改的收件人的物流id不能为空。");
			return false;
		}

		LogisticsEntity logisticsEntity = new LogisticsEntity().setLogisticsId(updRecipientVo.getLogisticsId())
				.setLogisticsRecipient(updRecipientVo.getLogisticsRecipient())
				.setLogisticsRecipientPhone(updRecipientVo.getLogisticsRecipientPhone())
				.setLogisticsRecipientAddress(updRecipientVo.getLogisticsRecipientAddress())
				.setLogisticsRecipientPostcode(updRecipientVo.getLogisticsRecipientPostcode());

		return logisticsService.updateById(logisticsEntity);
	}

	/**
	 * 关闭订单
	 * 
	 * @param orderId
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean closeOrder(Long orderId) {
		if (orderId == null) {
			log.error("关闭订单需要参数OrderId");
			return false;
		}
		OrderEntity entity = new OrderEntity();
		entity.setOrderId(orderId);
		entity.setOrderStatus(5); // 关闭订单
		return updateById(entity);
	}

	/**
	 * 获取订单备注
	 * 
	 * @param orderId
	 * @return
	 */
	@Override
	public String getOrderRemark(Long orderId) {
		OrderEntity orderEntity = this.getById(orderId);
		return orderEntity.getOrderRemark();
	}

	/**
	 * 修改订单备注
	 * 
	 * @param orderId
	 * @param orderRemark
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean updOrderRemark(Long orderId, String orderRemark) {
		OrderEntity entity = new OrderEntity();
		entity.setOrderId(orderId).setOrderRemark(orderRemark);
		return updateById(entity);
	}

	/**
	 * 修改订单商品信息
	 * 
	 * @param orderId
	 * @param commodityId
	 * @param skuId
	 * @param commodityNumber
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean updCommodityInfo(Long orderId, Long commodityId, Long skuId, Integer commodityNumber) {
		// @formatter:off
		if (orderId == null) {
			log.error("要修改的订单商品的orderId不能为空。");
			return false;
		}
		if (commodityId == null) {
			log.error("要修改的订单商品的commodityId不能为空。");
			return false;
		}
		if (skuId == null) {
			log.error("要修改的订单商品的skuId不能为空。");
			return false;
		}
		if (commodityNumber == null) {
			return false;
		}
		
		// 获取原先订单和订单商品信息
		OrderEntity orderEntity = getById(orderId);
		OrderCommodityMiddleEntity ocmeEntity = orderCommodityMiddleService.getOne(new QueryWrapper<OrderCommodityMiddleEntity>()
					.eq("order_id", orderId)
					.eq("commodity_id", commodityId)
					.eq("sku_id", skuId)
				);
		BigDecimal originOrderPayable = orderEntity.getOrderPayable(); // 订单应付款金额（所有商品的数量*单价的总和 + 运费 + ...）
		BigDecimal originOrderTotalAmount = orderEntity.getOrderTotalAmount(); // 订单总金额（实付金额，可能免运费，优惠券）
		BigDecimal originOrderCommodityTotalAmount = orderEntity.getOrderCommodityTotalAmount(); // 商品合计金额（所有商品的数量*单价的总和）
		BigDecimal originCommodityPrice = ocmeEntity.getCommodityPrice();
		Integer originCommodityNumber = ocmeEntity.getCommodityNumber();
		
		// 修改订单中指定商品数量
		UpdateWrapper<OrderCommodityMiddleEntity> updQW = new UpdateWrapper<>();
		updQW
			.eq("order_id", orderId)
			.eq("commodity_id", commodityId)
			.eq("sku_id", skuId);
		OrderCommodityMiddleEntity orderCommodityMiddleEntity = new OrderCommodityMiddleEntity()
				.setCommodityNumber(commodityNumber);
		boolean updOrderCommodityMiddleEntity = orderCommodityMiddleService.update(orderCommodityMiddleEntity, updQW);
		
		// 重新计算订单相关价格
		BigDecimal recalcOrderPayable = originOrderPayable // 重新计算订单应付款金额
			.subtract(originCommodityPrice.multiply(BigDecimal.valueOf(originCommodityNumber)))
			.add(originCommodityPrice.multiply(BigDecimal.valueOf(commodityNumber)));
		BigDecimal recalcOrderTotalAmount = originOrderTotalAmount // 重新计算订单总金额（实付金额）
			.subtract(originCommodityPrice.multiply(BigDecimal.valueOf(originCommodityNumber)))
			.add(originCommodityPrice.multiply(BigDecimal.valueOf(commodityNumber)));
		BigDecimal recalcOrderCommodityTotalAmount = originOrderCommodityTotalAmount // 重新计算商品合计金额
			.subtract(originCommodityPrice.multiply(BigDecimal.valueOf(originCommodityNumber)))
			.add(originCommodityPrice.multiply(BigDecimal.valueOf(commodityNumber)));
		
		orderEntity
			.setOrderPayable(recalcOrderPayable)
			.setOrderTotalAmount(recalcOrderTotalAmount)
			.setOrderCommodityTotalAmount(recalcOrderCommodityTotalAmount);
		
		boolean updRecalc = updateById(orderEntity);
		
		return true;
		// @formatter:on
	}

	/**
	 * 暂只支持修改运费和优惠价格
	 * 
	 * @param orderId
	 * @param logisticsId
	 * @param discountAmount
	 * @param logisticsFreight
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean updCost(Long orderId, Long commodityId, Long skuId, Long logisticsId, BigDecimal discountAmount,
			BigDecimal logisticsFreight) {
		// @formatter:off
		if (orderId == null) {
			log.error("要修改订单费用信息的orderId不能为空。");
			return false;
		}
		if (logisticsId == null) {
			log.error("要修改订单费用信息的logisticsId不能为空。");
			return false;
		}

		// 修改运费
		LogisticsEntity logisticsEntity = logisticsService.getById(logisticsId);
		if (logisticsEntity == null) {
			throw new RuntimeException("logisticsId有误：" + logisticsId);
		}
		
		BigDecimal originLogisticsFreight = logisticsEntity.getLogisticsFreight(); // 查询之前运费
		
		boolean updLogisticsFreight = false;
		logisticsEntity
			.setLogisticsId(logisticsId);
		if (logisticsFreight != null) {
			logisticsEntity.setLogisticsFreight(logisticsFreight);
			updLogisticsFreight = logisticsService.updateById(logisticsEntity); // 修改现在运费
		}

		// 修改优惠价格
		QueryWrapper<OrderCommodityMiddleEntity> queryOCMQW = new QueryWrapper<>();
		queryOCMQW
			.select("discount_amount")
			.eq("order_id", orderId)
			.eq("commodity_id", commodityId)
			.eq("sku_id", skuId);
		Map<String, Object> discountAmountMap = orderCommodityMiddleService.getMap(queryOCMQW);
		if (discountAmountMap == null || discountAmountMap.get("discount_amount") == null) {
			throw new RuntimeException("查询优惠价格有误，order_id=" + orderId + " : commodity_id=" + commodityId + " : sku_id=" + skuId);
		}
		BigDecimal originDiscountAmount = (BigDecimal) discountAmountMap.get("discount_amount"); // 查询之前优惠
		
		UpdateWrapper<OrderCommodityMiddleEntity> updOCMQW = new UpdateWrapper<>();
		updOCMQW.eq("order_id", orderId);
		OrderCommodityMiddleEntity orderCommodityMiddleEntity = new OrderCommodityMiddleEntity();
		boolean updOCMQWFlag = false;
		if (discountAmount != null) {
			orderCommodityMiddleEntity.setDiscountAmount(discountAmount);
			updOCMQWFlag = orderCommodityMiddleService.update(orderCommodityMiddleEntity, updOCMQW); // 修改现在优惠
		}

		// 重新计算订单价格
		if (updLogisticsFreight && updOCMQWFlag) {
			OrderEntity orderEntity = getById(orderId);
			BigDecimal originOrderPayable = orderEntity.getOrderPayable(); // 订单应付款金额（所有商品的数量*单价的总和 + 运费 + ...）
			BigDecimal originOrderTotalAmount = orderEntity.getOrderTotalAmount(); // 订单总金额（实付金额，可能免运费，优惠券）
			BigDecimal currOrderPayable = originOrderPayable
					.subtract(originLogisticsFreight)
					.add(logisticsFreight);
			BigDecimal currOrderTotalAmount = originOrderTotalAmount
					.add(originDiscountAmount)
					.subtract(discountAmount);
			orderEntity
				.setOrderPayable(currOrderPayable)
				.setOrderTotalAmount(currOrderTotalAmount);
			updateById(orderEntity);
		}

		return true;
		// @formatter:on
	}

}
