package com.zlzc.api.rest.commodity.controller;


import com.zlzc.api.rest.commodity.entity.CommodityRecommendEntity;
import com.zlzc.api.rest.commodity.service.CommodityRecommendService;
import com.zlzc.api.rest.commodity.vo.CommodityRecommendVo;
import com.zlzc.api.rest.commodity.vo.CommodityVo;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import com.zlzc.common.utils.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "App-商品-推荐", tags = { "V1.0 AppCommodity：App-商品操作相关接口-推荐" })
@RestController
@RequestMapping("App/AppCommodityRecommend")
public class CommodityRecommendController {

    @Autowired
    private CommodityRecommendService commodityRecommendService;
    /**
     * 根据推荐状态查询
     */
    @ApiOperation(value = "AppCommodity-1 根据商品状态返回指定的数据")
    @ApiResponses(value = {
            @ApiResponse(response = CommodityRecommendVo.class, code = 200, message = "根据商品状态返回指定的数据")
    })
    @GetMapping("/queryShopDetails/{status}")
    public Result listInfo(@PathVariable("status") Integer status) {
        List<CommodityRecommendVo> CommodityList = commodityRecommendService.getByStatus(status);
        return Result.ok().put("CommodityList", CommodityList);
    }
}
