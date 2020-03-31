package com.zlzc.modules.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zlzc.common.utils.Result;
import com.zlzc.modules.dict.entity.DictEntity;
import com.zlzc.modules.dict.service.DictService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 应该有用户的概念在里面（暂时不加）
 * 
 * @author AA
 *
 */
@Api(value = "后台-订单设置", tags = { "V1.0 order：后台-订单设置操作相关接口" })
@RestController
@RequestMapping("/order")
public class OrderSetUpController {

	@Autowired
	private DictService dictService;

	@ApiOperation(value = "orderSettingsOrderAttrs-1 设置订单相关属性默认值")
	@GetMapping("/settingsOrderAttrs")
	public Result orderSettingsOrderAttrs(@RequestParam(required = false) String orderTimeOut,
			@RequestParam(required = false) String shipmentTimeout,
			@RequestParam(required = false) String successTimeout) {
		// 3 60 zezl_order_default 1 正常订单超过时间 2019-12-19 14:06:15
		// 4 30 zezl_order_default 2 发货才超过 自动完成 2019-12-19 14:09:31
		// 5 7 zezl_order_default 3 订单超过时间 2019-12-19 14:11:59
		// 6 7 zezl_order_default 4 订单完成自动好评 2019-12-19 14:12:03

		DictEntity orderTimeOutEntity = new DictEntity();
		DictEntity shipmentTimeoutEntity = new DictEntity();
		DictEntity successTimeoutEntity = new DictEntity();

		ArrayList<DictEntity> addList = new ArrayList<DictEntity>();
		
		if (StringUtils.isNotBlank(orderTimeOut)) {
			orderTimeOutEntity.setDictLabel("zlzc_order_attr").setDictType("1").setDictValue(orderTimeOut);
			addList.add(orderTimeOutEntity);
		}

		if (StringUtils.isNotBlank(shipmentTimeout)) {
			shipmentTimeoutEntity.setDictLabel("zlzc_order_attr").setDictType("2").setDictValue(shipmentTimeout);
			addList.add(shipmentTimeoutEntity);
		}

		if (StringUtils.isNotBlank(shipmentTimeout)) {
			successTimeoutEntity.setDictLabel("zlzc_order_attr").setDictType("3").setDictValue(successTimeout);
			addList.add(successTimeoutEntity);
		}

		dictService.updDict(addList);

		return Result.ok("success");
	}

	@ApiOperation(value = "getOrderAttrs-2 获取订单相关属性值")
	@GetMapping("/getOrderAttrs")
	public Result getOrderAttrs() {
		List<DictEntity> dicties = dictService.getDictByDictLabel("zlzc_order_attr");

		Map<String, Object> rsMap = new HashMap<>();

		dicties.forEach(dict -> {
			if (dict.getDictType().equalsIgnoreCase("1")) {
				rsMap.put("订单超时时间", dict.getDictValue());
			} else if (dict.getDictType().equalsIgnoreCase("2")) {
				rsMap.put("发货超时时间", dict.getDictValue());
			} else if (dict.getDictType().equalsIgnoreCase("3")) {
				rsMap.put("订单完成后有效售后时限", dict.getDictValue());
			}
		});

		return Result.ok().put("rs", rsMap);
	}

}