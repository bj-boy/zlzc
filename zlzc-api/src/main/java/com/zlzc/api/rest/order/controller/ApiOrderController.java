package com.zlzc.api.rest.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlzc.api.rest.order.entity.vo.OrderDetailsVo;
import com.zlzc.api.rest.order.service.OrderDetailsVoService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 根据订单或者编号查询订单有关的全部数据(多条)
     */
    @ApiResponses(value = {
            @ApiResponse(response = OrderDetailsVo.class, code = 200, message = "根据订单或者编号查询订单有关的全部数据响应字段说明（多条）")
    })
    @ApiOperation(value = "orderDouDetails-1 根据订单或者编号查询订单有关的数据(多条)")
    @GetMapping("/orderDouDetails/{id}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "id", value = "订单id", defaultValue = "1", paramType = "path"),
            }
    )
    public Result orderDouDetails(@PathVariable("id") String id ) {
        OrderDetailsVo ordeAndLogisticsVoDetails = ordeAndLogisticsService.getOrdeAndLogisticsVoDetails(id);
        return Result.ok().put("ordeAndLogisticsVoDetails", ordeAndLogisticsVoDetails);
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





}
