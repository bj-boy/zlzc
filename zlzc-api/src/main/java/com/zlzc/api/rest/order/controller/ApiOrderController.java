package com.zlzc.api.rest.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlzc.api.config.swagger.ApiJsonObject;
import com.zlzc.api.config.swagger.ApiJsonProperty;
import com.zlzc.api.rest.order.entity.vo.OrderDetailsVo;
import com.zlzc.api.rest.order.service.OrderDetailsVoService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


@Api(value = "APP-订单", tags = { "V1.0 order：APP-订单操作相关接口" })
@RestController
@RequestMapping("/App/Order")
public class ApiOrderController {

    @Autowired
    private OrderDetailsVoService ordeAndLogisticsService;

    /**
     * 根据订单或者编号查询订单有关的全部数据(单条)
     */
    @ApiResponses(value = {
            @ApiResponse(response = OrderDetailsVo.class, code = 200, message = "根据订单或者编号查询订单有关的全部数据响应字段说明（单条）")
    })
    @ApiOperation(value = "orderOneDetails-1 根据订单或者编号查询订单有关的数据(单条)")
    @GetMapping("/orderOneDetails/{id}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "id", value = "订单id", defaultValue = "1", paramType = "path"),
            }
    )
    public Result orderOneDetails(@PathVariable("id") String id ) {
        OrderDetailsVo ordeAndLogisticsVoDetails = ordeAndLogisticsService.getOrdeAndLogisticsVoDetails(id);
        return Result.ok().put("ordeAndLogisticsVoDetails", ordeAndLogisticsVoDetails);
    }

    /**
     * 根据条件查询订单快递表列表详情(分页)
     */
    @ApiResponses(value = {
            @ApiResponse(response = OrderDetailsVo.class, code = 200, message = "根据条件查询订单（可分页）响应字段说明")
    })
    @ApiOperation(value = "listByOrdeAndLogisticsDetails-2 根据条件查询订单（可分页）")
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
                    @ApiJsonProperty(key = "orderStatus",example = "订单状态")
            })
            @RequestBody Map<String, Object> paramMap /*@RequestBody OrderDetailsVo ordeAndLogisticsVo*/) {
        OrderDetailsVo ordeAndLogisticsVo = JSONObject.parseObject(JSONObject.toJSONString(paramMap), OrderDetailsVo.class);
        PageUtils page = ordeAndLogisticsService.ListGetDetails(paramMap,ordeAndLogisticsVo);
        return Result.ok().put("page", page);
    }


    /**
     * 创建一个新的订单
     */
    @ApiOperation(value = "order-3 新建订单")
    @PostMapping("/save")
    public Result saveOrder(@RequestBody OrderDetailsVo orderDetailsVo){
        //orderService.save(orderEntity);
        ordeAndLogisticsService.saveOrder(orderDetailsVo);
        return Result.ok();
    }

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
