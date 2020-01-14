package com.zlzc.api.rest.brand.controller;

import java.util.Arrays;
import java.util.Map;

import com.zlzc.api.rest.brand.entity.BrandMiddleShopEntity;
import com.zlzc.api.rest.brand.service.BrandMiddleShopService;
import com.zlzc.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;


/**
 * 品牌店铺关联表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@RestController
@RequestMapping("rest/brandmiddleshop")
public class BrandMiddleShopController {
    @Autowired
    private BrandMiddleShopService brandMiddleShopService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = brandMiddleShopService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{ brandMiddleShopId}")
    public Result info(@PathVariable(" brandMiddleShopId") Long  brandMiddleShopId){
        BrandMiddleShopEntity brandMiddleShop = brandMiddleShopService.getById( brandMiddleShopId);

        return Result.ok().put("brandMiddleShop", brandMiddleShop);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody BrandMiddleShopEntity brandMiddleShop){
        brandMiddleShopService.save(brandMiddleShop);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody BrandMiddleShopEntity brandMiddleShop){
        ValidatorUtils.validateEntity(brandMiddleShop);
        brandMiddleShopService.updateById(brandMiddleShop);
        
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long[]  brandMiddleShopIds){
        brandMiddleShopService.removeByIds(Arrays.asList( brandMiddleShopIds));

        return Result.ok();
    }

}
