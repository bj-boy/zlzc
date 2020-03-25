package com.zlzc.modules.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlzc.common.config.swagger.ApiJsonObject;
import com.zlzc.common.config.swagger.ApiJsonProperty;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.order.entity.vo.OrderDetailsVo;
import com.zlzc.modules.order.service.OrderDetailsVoService;
import com.zlzc.modules.order.service.OrderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
                 @ApiJsonProperty(key = "orderOrderType",example = "订单分类"),
                 @ApiJsonProperty(key = "orderSource",example = "订单来源")
             })
             @RequestBody Map<String, Object> paramMap /*@RequestBody OrderDetailsVo ordeAndLogisticsVo*/) {
        OrderDetailsVo ordeAndLogisticsVo = JSONObject.parseObject(JSONObject.toJSONString(paramMap), OrderDetailsVo.class);
        PageUtils page = ordeAndLogisticsService.ListGetDetails(paramMap,ordeAndLogisticsVo);
        return Result.ok().put("page", page);
    }

    /**
     * 根据订单或者编号查询订单有关的全部数据
     */
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
    public Result orderDetails(@PathVariable("id") String id ) {
        OrderDetailsVo ordeAndLogisticsVoDetails = ordeAndLogisticsService.getOrdeAndLogisticsVoDetails(id);
        return Result.ok().put("ordeAndLogisticsVoDetails", ordeAndLogisticsVoDetails);
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

    @ApiOperation(value = "order-3 新建订单")
    @PostMapping("/save")
    public Result saveOrder(@RequestBody OrderDetailsVo orderDetailsVo){
        //orderService.save(orderEntity);
    	try {
    		ordeAndLogisticsService.saveOrder(orderDetailsVo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("订单创建失败，请检查订单相关参数是否正确。");
		}
    	return Result.ok("订单创建成功");
    }


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
    @ApiOperation(value = "order-4 根据id修改订单")
    @PutMapping("/update")
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




}
