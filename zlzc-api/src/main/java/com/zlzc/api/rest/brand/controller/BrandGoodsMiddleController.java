package com.zlzc.api.rest.brand.controller;

import java.util.Arrays;
import java.util.Map;

import com.zlzc.api.rest.brand.entity.BrandGoodsMiddleEntity;
import com.zlzc.api.rest.brand.service.BrandGoodsMiddleService;
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
 * 品牌商品关联表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@RestController
@RequestMapping("rest/brandgoodsmiddle")
public class BrandGoodsMiddleController {
    @Autowired
    private BrandGoodsMiddleService brandGoodsMiddleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = brandGoodsMiddleService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandGoodsMiddleId}")
    public Result info(@PathVariable("brandGoodsMiddleId") Long brandGoodsMiddleId){
        BrandGoodsMiddleEntity brandGoodsMiddle = brandGoodsMiddleService.getById(brandGoodsMiddleId);

        return Result.ok().put("brandGoodsMiddle", brandGoodsMiddle);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody BrandGoodsMiddleEntity brandGoodsMiddle){
        brandGoodsMiddleService.save(brandGoodsMiddle);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody BrandGoodsMiddleEntity brandGoodsMiddle){
        ValidatorUtils.validateEntity(brandGoodsMiddle);
        brandGoodsMiddleService.updateById(brandGoodsMiddle);
        
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long[] brandGoodsMiddleIds){
        brandGoodsMiddleService.removeByIds(Arrays.asList(brandGoodsMiddleIds));

        return Result.ok();
    }

}
