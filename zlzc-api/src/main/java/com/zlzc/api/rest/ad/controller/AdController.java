package com.zlzc.api.rest.ad.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zlzc.api.rest.ad.entity.AdEntity;
import com.zlzc.api.rest.ad.service.AdService;
import com.zlzc.api.rest.brand.entity.BrandCategoryEntity;
import com.zlzc.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;


/**
 * 广告表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Api(value = "App-广告位", tags = { "V1.0 appA：App-广告位相关接口" })
@RestController
@RequestMapping("app/ad")
public class AdController {
    @Autowired
    private AdService adService;

    /**
     * 查询轮播广告位
     */
    @ApiOperation(value = "appGetAdCarousel-1 查询轮播广告位 （1 轮播 2其他）")
    @GetMapping("/getAdCarousel/{position}")
    @ApiResponses(value ={
            @ApiResponse(response=AdEntity.class,code = 200, message = "appGetAdCarousel-1 查询轮播广告位 （1 轮播 2其他）")})
    public Result getAdCarousel(@PathVariable("position")Integer position){
        List<AdEntity> adCarouselService = adService.getAdCarouselService(position);
        return Result.ok().put("adCarouselService", adCarouselService);
    }

    /**
     * 保存
     */
    //@RequestMapping("/save")
    public Result save(@RequestBody AdEntity ad){
        adService.save(ad);

        return Result.ok();
    }

    /**
     * 修改
     */
   // @RequestMapping("/update")
    public Result update(@RequestBody AdEntity ad){
        ValidatorUtils.validateEntity(ad);
        adService.updateById(ad);
        
        return Result.ok();
    }

    /**
     * 删除
     */
    //@RequestMapping("/delete")
    public Result delete(@RequestBody Long[] adIds){
        adService.removeByIds(Arrays.asList(adIds));

        return Result.ok();
    }

}
