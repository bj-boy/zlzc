package com.zlzc.modules.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlzc.common.config.swagger.ApiJsonObject;
import com.zlzc.common.config.swagger.ApiJsonProperty;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.order.entity.vo.OrderDetailsVo;
import com.zlzc.modules.order.entity.vo.saveOrderVo;
import com.zlzc.modules.order.service.OrderDetailsVoService;
import com.zlzc.modules.order.service.OrderService;
import com.zlzc.modules.order.vo.UpdRecipientVo;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Api(value = "后台-订单", tags = { "V1.0 order：后台-订单操作相关接口" })
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private  OrderService orderService;


    @Autowired
    private OrderDetailsVoService ordeAndLogisticsService;

    /**
     * 根据条件查询订单快递表列表详情(分页)
     */
    @ApiResponses(value = {
            @ApiResponse(response = OrderDetailsVo.class, code = 200, message = "根据条件查询订单快递表列表详情（可分页）响应字段说明")
    })
    @ApiOperation(value = "listByOrdeAndLogisticsDetails-2 根据条件查询订单快递表列表详情（可分页）")
    @PostMapping("/listByOrderDetails")
    //@formatter:off
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
                    @ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
            }
    )
    //@formatter:on
    public Result listByOrdeAndLogisticsDetails(
             @ApiJsonObject(name = "paramMap", value = {
                 @ApiJsonProperty(key = "orderNumber",example = "订单编号"),
                 @ApiJsonProperty(key = "logisticsRecipient",example = "收货人"),
                 @ApiJsonProperty(key = "orderSubmissionTime",example = "提交时间"),
                 @ApiJsonProperty(key = "orderStatus",example = "订单状态"),
//                 @ApiJsonProperty(key = "orderOrderType",example = "订单分类"),
                 @ApiJsonProperty(key = "orderSource",example = "订单来源")
             })
             @RequestBody Map<String, Object> paramMap /*@RequestBody OrderDetailsVo ordeAndLogisticsVo*/, String page, String limit) {
		OrderDetailsVo ordeAndLogisticsVo = JSONObject.parseObject(JSONObject.toJSONString(paramMap),
				OrderDetailsVo.class);
		Map<String, Object> param = new HashMap<String, Object>(){{
			put("page", page);
			put("limit", limit);
		}};
		
		PageUtils pageRs = ordeAndLogisticsService.ListGetDetails(param, ordeAndLogisticsVo);
		return Result.ok().put("page", pageRs);
    }


    /**
     * 查询订单信息

    @ApiOperation(value = "orderDetails-1 根据订单编号查询订单")
    @GetMapping("/orderDetails/{number}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "number", value = "订单编号", defaultValue = "1", paramType = "path"),
            }
    )
    public Result orderDetails(@PathVariable("number") String number ) {
        OrderEntity orderDetails = orderService.getDetails(number);
        return Result.ok().put("orderDetails", orderDetails);
    }
     */
    /**
     * 根据条件查询订单审核详情列表(分页)

    @ApiOperation(value = "listByOrderDetails-2 根据筛选条件获取订单详情列表（可分页）")
    @PostMapping("/listByOrderDetails")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
                    @ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
            }
    )
    public Result listByOrderDetails(@ApiParam(hidden = true) @RequestParam Map<String, Object> params,
                                  @RequestBody OrderEntity orderEntity) {
        PageUtils page = orderService.ListGetDetails(params, orderEntity);
        return Result.ok().put("page", page);
    }
     */


    /**
     *保存
    @ApiOperation(value = "order-3 添加订单")
    @PostMapping("/save")
    public Result save(@RequestBody OrderEntity orderEntity){
        orderService.save(orderEntity);
        return Result.ok();
    }
     */
    /**
     *修改
     */
//    @ApiOperation(value = "order-4 根据id修改订单")
//    @PutMapping("/update")
    public Result update(@RequestBody OrderDetailsVo orderDetailsVo){
        ordeAndLogisticsService.updateStatus(orderDetailsVo);
        return Result.ok();
    }


    /**
     *删除
     */
    @ApiOperation(value = "order-5 根据id进行删除订单")
    @DeleteMapping("/delete")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(
                            name = "orderId",
                            value = "订单ID[]; [1,2,3]",
                            paramType = "body",
                            dataTypeClass = String.class,
                            allowMultiple = true
                    )
            }
    )
    public Result delete(@RequestBody String[] orderId){
        ordeAndLogisticsService.removeStatus(Arrays.asList(orderId));
        return Result.ok();
    }

    /**
     * 后台的订单新增只用于测试，订单新增接口应该只存在于app中。
     * @param orderDetailsVo
     * @return
     */
//    @ApiOperation(value = "order-3 新建订单")
//    @PostMapping("/save")
//    public Result saveOrder(@RequestBody OrderDetailsVo orderDetailsVo){
//        //orderService.save(orderEntity);
//    	try {
//    		ordeAndLogisticsService.saveOrder(orderDetailsVo);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return Result.error("订单创建失败，请检查订单相关参数是否正确。");
//		}
//    	return Result.ok("订单创建成功");
//    }
    @ApiOperation(value = "order-3 新建订单")
    @PostMapping("/save")
    public Result addOrder(@RequestBody saveOrderVo saveOrderVo){
        //orderService.save(orderEntity);
    	try {
    		ordeAndLogisticsService.addOrder(saveOrderVo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("订单创建失败，请检查订单相关参数是否正确。");
		}
    	return Result.ok("订单创建成功");
    }
    
    /**
     * 根据订单或者编号查询订单有关的全部数据
     */
//    @ApiResponses(value = {
//            @ApiResponse(response = OrderDetailsVo.class, code = 200, message = "根据订单或者编号查询订单有关的全部数据响应字段说明")
//    })
//    @ApiOperation(value = "orderDetails-1 根据订单或者编号查询订单有关的全部数据")
//    @GetMapping("/orderDetails/{id}")
//    @ApiImplicitParams(
//            value = {
//                    @ApiImplicitParam(name = "id", value = "订单id", defaultValue = "1", paramType = "path"),
//            }
//    )
//    public Result orderDetails(@PathVariable("id") String id ) {
//        OrderDetailsVo ordeAndLogisticsVoDetails = ordeAndLogisticsService.getOrdeAndLogisticsVoDetails(id);
//        return Result.ok().put("ordeAndLogisticsVoDetails", ordeAndLogisticsVoDetails);
//    }
    @ApiResponses(value = {
            @ApiResponse(response = OrderDetailsVo.class, code = 200, message = "根据订单或者编号查询订单有关的全部数据响应字段说明")
    })
    @ApiOperation(value = "orderDetails-1 根据订单或者编号查询订单有关的全部数据")
    @GetMapping("/orderDetails/{id}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "id", value = "订单id", defaultValue = "1", paramType = "path"),
            }
    )
    public Result orderDetails(@PathVariable("id") Long id ) {
    	com.zlzc.modules.order.vo.OrderDetailsVo orderDetails = ordeAndLogisticsService.getOrderDetails(id);
        return Result.ok().put("orderDetails", orderDetails);
    }
    
    /* ==================== 订单详情中修改订单相关信息接口开发 ==================== */
    
    @ApiOperation(value = "updRecipientInfo-6 修改收货人信息")
    @PostMapping("/updRecipientInfo")
    public Result updRecipientInfo(@RequestBody UpdRecipientVo updRecipientVo) {
    	boolean updRecipientInfo = ordeAndLogisticsService.updRecipientInfo(updRecipientVo);
    	return Result.ok("success");
    }
    
    @ApiOperation(value = "closeOrder-7 关闭指定订单")
    @PostMapping("/closeOrder/{id}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "id", value = "订单id", defaultValue = "1", paramType = "path"),
            }
    )
    public Result closeOrder(@PathVariable("id") Long orderId) {
    	boolean closeOrder = ordeAndLogisticsService.closeOrder(orderId);
    	return Result.ok("success");
    }
    
    @ApiOperation(value = "getOrderRemark-8 获取订单备注")
    @GetMapping("/getOrderRemark/{id}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "id", value = "订单id", defaultValue = "1", paramType = "path"),
            }
    )
    public Result getOrderRemark(@PathVariable("id") Long orderId) {
    	String orderRemark = ordeAndLogisticsService.getOrderRemark(orderId);
    	return Result.ok().put("orderRemark", orderRemark);
    }
    
    @ApiOperation(value = "updOrderRemark-9 修改订单备注")
    @PostMapping("/updOrderRemark/{id}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "id", value = "订单id", defaultValue = "1", paramType = "path"),
                    @ApiImplicitParam(name = "orderRemark", value = "订单备注", defaultValue = "备注", paramType = "query"),
            }
    )
	public Result updOrderRemark(@PathVariable("id") Long orderId, @RequestParam("orderRemark") String orderRemark) {
		ordeAndLogisticsService.updOrderRemark(orderId, orderRemark);
		return Result.ok("success");
	}
    
    @ApiOperation(value = "updCommodityInfo-10 修改订单商品信息（暂只支持修改数量）")
    @PostMapping("/updCommodityInfo/{orderId}/{commodityId}/{skuId}/{commodityNumber}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "orderId", value = "订单id", defaultValue = "1", paramType = "path"),
                    @ApiImplicitParam(name = "commodityId", value = "商品id", defaultValue = "1", paramType = "path"),
                    @ApiImplicitParam(name = "skuId", value = "skuId", defaultValue = "1", paramType = "path"),
                    @ApiImplicitParam(name = "commodityNumber", value = "商品数量", defaultValue = "1", paramType = "path"),
            }
    )
	public Result updCommodityInfo(@PathVariable("orderId") Long orderId, @PathVariable("commodityId") Long commodityId,
			@PathVariable("skuId") Long skuId, @PathVariable("commodityNumber") Integer commodityNumber) {
    	ordeAndLogisticsService.updCommodityInfo(orderId, commodityId, skuId, commodityNumber);
		return Result.ok("success");
	}
    
    // @formatter:off
    @ApiOperation(value = "updCostInfo-12 修改订单费用信息")
    @PostMapping("/updCostInfo/{orderId}/{commodityId}/{skuId}/{logisticsId}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "orderId", value = "订单id", defaultValue = "1", paramType = "path"),
                    @ApiImplicitParam(name = "commodityId", value = "商品id", defaultValue = "1", paramType = "path"),
                    @ApiImplicitParam(name = "skuId", value = "skuId", defaultValue = "1", paramType = "path"),
                    @ApiImplicitParam(name = "logisticsId", value = "物流id", defaultValue = "1", paramType = "path"),
                    @ApiImplicitParam(name = "discountAmount", value = "优惠金额", defaultValue = "1", paramType = "query"),
                    @ApiImplicitParam(name = "logisticsFreight", value = "运费", defaultValue = "1", paramType = "query"),
            }
    )
	public Result updCostInfo(
			@PathVariable("orderId") Long orderId, 
			@PathVariable("commodityId") Long commodityId,
			@PathVariable("skuId") Long skuId, 
			@PathVariable("logisticsId") Long logisticsId,
			@RequestParam("discountAmount") BigDecimal discountAmount,
			@RequestParam("logisticsFreight") BigDecimal logisticsFreight
			
	) {
    	ordeAndLogisticsService.updCost(orderId, commodityId, skuId, logisticsId, discountAmount, logisticsFreight);
		return Result.ok("success");
	}
    // @formatter:on
    
    
}

