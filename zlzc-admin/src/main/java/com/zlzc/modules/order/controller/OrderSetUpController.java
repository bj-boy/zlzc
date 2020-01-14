package com.zlzc.modules.order.controller;

import com.zlzc.common.utils.Result;
import com.zlzc.modules.dict.entity.DictEntity;
import com.zlzc.modules.dict.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "后台-订单设置", tags = { "V1.0 order：后台-订单设置操作相关接口" })
@RestController
@RequestMapping("/order")
public class OrderSetUpController {

    @Autowired
    private DictService dictService;

    @ApiOperation(value = "orderDetails-1 订单订单默认值")
    @GetMapping("/orderSettingsDetails")
    public Result orderSettingsDetails() {
        List<DictEntity> zezl_order_default = dictService.getDict("zezl_order_default");
        //dictService
        // OrderDetailsVo ordeAndLogisticsVoDetails = ordeAndLogisticsService.getOrdeAndLogisticsVoDetails(id);
        return Result.ok().put("orderSettingsDetails", zezl_order_default);
    }
}