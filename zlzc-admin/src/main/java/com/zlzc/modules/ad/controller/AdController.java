package com.zlzc.modules.ad.controller;

import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.common.validator.ValidatorUtils;
import com.zlzc.modules.ad.entity.AdEntity;
import com.zlzc.modules.ad.service.AdService;
import com.zlzc.modules.merchant.entity.MerchantEntity;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 广告表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Api(value = "admin-广告位", tags = { "V1.0 ad:后台-广告位相关接口" })
@RestController
@RequestMapping("admin/ad")
public class AdController {
    @Autowired
    private AdService adService;

    /**
     * 查询轮播广告位
     */
    @ApiOperation(value = "getAdCarousel-1 查询轮播广告位 （1 轮播 2其他）")
    @GetMapping("/getAdCarousel/{position}")
    @ApiResponses(value ={
            @ApiResponse(response=AdEntity.class,code = 200, message = "查询轮播广告位 （1 轮播 2其他）响应字段说明")})
    public Result getAdCarousel(@PathVariable("position")Integer position){
        List<AdEntity> adCarouselService = adService.getAdCarouselService(position);
        return Result.ok().put("adCarouselService", adCarouselService);
    }


    /**
     * 广告列表
     */
    @ApiResponses(value = {
            @ApiResponse(response = MerchantEntity.class, code = 200, message = "广告列表响应字段说明")
    })
    @ApiOperation(value = "ad-2 广告列表（可分页）")
    @GetMapping("/list")
    //@formatter:off
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
                    @ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
            }
    )
    //@formatter:on
    public Result list(@ApiParam(hidden = true) @RequestParam Map<String, Object> params) {
        PageUtils page = adService.queryPageShAd(params);

        return Result.ok().put("page", page);
    }
    /**
     * 保存
     */
    @ApiOperation(value = "save-3 添加轮播广告位 （1 轮播 2其他）")
    @PutMapping("/save")
    public Result save(@RequestBody AdEntity ad){
        adService.save(ad);

        return Result.ok();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "update-4 修改轮播广告位 （1 轮播 2其他）")
    @PutMapping("/update")
    public Result update(@RequestBody AdEntity ad){
        ValidatorUtils.validateEntity(ad);
        adService.updateById(ad);
        
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "delete-4 删除轮播广告位 （1 轮播 2其他）")
    public Result delete(@RequestBody Long[] adIds){
        adService.removeByIds(Arrays.asList(adIds));

        return Result.ok();
    }

}
