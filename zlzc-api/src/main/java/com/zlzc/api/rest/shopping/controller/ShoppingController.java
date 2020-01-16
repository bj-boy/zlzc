package com.zlzc.api.rest.shopping.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zlzc.api.config.swagger.ApiJsonObject;
import com.zlzc.api.config.swagger.ApiJsonProperty;
import com.zlzc.api.rest.order.entity.vo.OrderDetailsVo;
import com.zlzc.api.rest.shopping.entity.ShoppingEntity;
import com.zlzc.api.rest.shopping.service.ShoppingService;
import com.zlzc.api.rest.shopping.vo.ShoppingVo;
import com.zlzc.common.validator.ValidatorUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;


/**
 * 
 *购物车
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-15 11:03:02
 */
@RestController
@RequestMapping("app/shopping")
@Api(value = "api-购物车", tags = { "V1.0 Shopping：api-购物车操作相关接口" })
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;


    /**
     * 查询购物车所有商品
     */
    @ApiResponses(value = {
            @ApiResponse(response = ShoppingEntity.class, code = 200, message = "查询购物车所有商品（可分页）")
    })
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
                    @ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
            }
    )
    @ApiOperation(value = "listByShopping-1 查询购物车所有商品（可分页）")
    @PostMapping("/listByShopping")
    public Result listByShopping(@ApiParam(hidden = true)
              @RequestParam Map<String, Object> params
            ,@RequestBody ShoppingEntity shoppingEntity){
        PageUtils page = shoppingService.queryPage(params,shoppingEntity);
        return Result.ok().put("page", page);
    }

    /**
     * 根据商品id  的商品数量确定价格 以及商品的最大库存
     */
    @ApiOperation(value = "ByPriceShopping-2  根据商品id  的商品数量确定价格 以及商品的最大库存")
    @GetMapping("/ByPriceShopping/{commodityId}")
    public Result ByPriceShopping(@PathVariable("commodityId") Long commodityId){
        List<ShoppingVo> shoppingVo = shoppingService.ByPriceShopping(commodityId);
        return Result.ok().put("shoppingVo", shoppingVo);
    }


    /**
     * 添加购物车
     */
    @RequestMapping("/save")
    public Result save(@RequestBody ShoppingEntity shopping){
        shoppingService.save(shopping);

        return Result.ok();
    }

    /**
     * 修改购物车
     */
    @RequestMapping("/update")
    public Result update(@RequestBody ShoppingEntity shopping){
        ValidatorUtils.validateEntity(shopping);
        shoppingService.updateById(shopping);
        
        return Result.ok();
    }

    /**
     * 删除购物车商品
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long[] shoppingIds){
        shoppingService.removeByIds(Arrays.asList(shoppingIds));

        return Result.ok();
    }

}
