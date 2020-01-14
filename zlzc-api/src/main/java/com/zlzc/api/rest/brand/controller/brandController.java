package com.zlzc.api.rest.brand.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.zlzc.api.rest.brand.entity.BrandCategoryEntity;
import com.zlzc.api.rest.brand.entity.BrandEntity;
import com.zlzc.api.rest.brand.service.BrandCategoryService;
import com.zlzc.api.rest.brand.service.BrandService;
import com.zlzc.api.rest.brand.vo.BrandVo;
import com.zlzc.api.rest.commodity.entity.CommodityParamEntity;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 品牌表
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Api(value = "App-品牌", tags = { "V1.0 appBrand：App-品牌操作相关接口" })
@RestController
@RequestMapping("App/brand")
public class brandController {

    @Autowired
    private BrandService brandService;
    @Autowired
    private BrandCategoryService brandCategoryService;
    /**
     * 品牌推荐查询
     */
    @ApiOperation(value = "getCommendListController-1 查询品牌推荐（1.推荐 其他:不推荐）")
    @GetMapping("/commendList/{commend}")
    @ApiResponses(value = {
            @ApiResponse(response = BrandEntity.class, code = 200, message = "查询品牌推荐（1.推荐 其他:不推荐）")
    })
    public Result getCommendListController(@PathVariable("commend") int commend){
        List<BrandEntity> brandEntities = brandService.getreCommendList(commend);
        return Result.ok().put("brandEntities", brandEntities);
    }

    /**
     * 品牌分类下的商品
     */
    @ApiOperation(value = "getBrandCategories-2  根据品牌分类查询品牌")
    @GetMapping("/brandCategories/{categoriesName}")
    @ApiResponses(value = {
            @ApiResponse(response = BrandVo.class, code = 200, message = "根据品牌分类查询品牌")
    })
    public Result getBrandCategories(@PathVariable("categoriesName")String  categoriesName){
        List<BrandVo> brandCategories = brandService.getBrandCategoriesService(categoriesName);
        return Result.ok().put("brandCategories", brandCategories);
    }

    /**
     * 品牌详情
     */
    @ApiOperation(value = "getBrandDetails-3  根据id查询品牌详情")
    @GetMapping("/getBrandDetails/{brandId}")
    @ApiResponses(value = {
            @ApiResponse(response = BrandVo.class, code = 200, message = "根据id查询品牌详情")
    })
    public Result getBrandDetails(@PathVariable("brandId")  Long brandId){
        BrandEntity Brand = brandService.getById(brandId);
        return Result.ok().put("Brand", Brand);
    }

    /**
     * 品牌相关商品
     */
    @ApiOperation(value = "getBrandCommodity-4  根据id查询品牌  相关商品")
    @GetMapping("/getBrandCommodity/{brandId}")
    @ApiResponses(value = {
            @ApiResponse(response = BrandVo.class, code = 200, message = "根据id查询品牌  相关商品")
    })
    public Result getBrandCommodity(@PathVariable("brandId")  Long brandId){
        List<BrandVo> brandCommodityList = brandService.getBrandCommodityService(brandId);
        return Result.ok().put("brandCommodityList", brandCommodityList);
    }
    /**
     * 品牌相关商品
     */
    @ApiOperation(value = "getBrandShop-5  根据id查询品牌  相关店铺")
    @GetMapping("/getBrandShop/{brandId}")
    @ApiResponses(value = {
            @ApiResponse(response = BrandVo.class, code = 200, message = "根据id查询品牌  相关店铺")
    })
    public Result getBrandShop(@PathVariable("brandId")  Long brandId){
        List<BrandVo> brandCommodityList = brandService.getBrandShopService(brandId);
        return Result.ok().put("brandCommodityList", brandCommodityList);
    }

    /**
     * 品牌分类
     */
    @ApiOperation(value = "appBrandCategory-6 获取所有品牌分类")
    @GetMapping("/getCommendCategory")
    @ApiResponses(value = {
            @ApiResponse(response = BrandCategoryEntity.class, code = 200, message = "根据id查询品牌  相关店铺")
    })
    public Result getCommendCategory(){
        List<BrandCategoryEntity> brandEntities = brandCategoryService.getCommendCategory();
        return Result.ok().put("brandEntities", brandEntities);
    }


    /**
     * 品牌相关评论(等待权限用户表)
     */
    @ApiOperation(value = "getBrandComment-7  根据id查询品牌  相关评论")
    @GetMapping("/getBrandComment/{brandId}")
    @ApiResponses(value = {
            @ApiResponse(response = BrandVo.class, code = 200, message = "根据id查询品牌  相关评论")
    })
    public Result getBrandComment(@PathVariable("brandId")  Long brandId){

        return null;
    }
    /**
     * 品牌快捷搜索
      */
    @ApiOperation(value = "getBrandSearchFor-8  品牌快捷搜索")
    @GetMapping("/getBrandSearchFor/{brandName}")
    @ApiResponses(value = {
            @ApiResponse(response = BrandVo.class, code = 200, message = "品牌快捷搜索")
    })
    public Result getBrandSearchFor(@PathVariable("brandName")  String brandName){
        List<BrandVo> brandSearchFor = brandService.getBrandSearchFor(brandName);
        return Result.ok().put("brandSearchFor", brandSearchFor);
    }




    /**
     * 保存
     */
   // @ApiOperation(value = "save-2 添加一个品牌")
   // @PostMapping("/save")
    public Result save(@RequestBody BrandEntity brand){
        brandService.save(brand);

        return Result.ok();
    }

    /**
     * 修改
     */
    //@PutMapping("/update")
    //@ApiOperation(value = "update-3 修改品牌")
    public Result update(@RequestBody BrandEntity brand){
        ValidatorUtils.validateEntity(brand);
        brandService.updateById(brand);

        return Result.ok();
    }

    /**
     * 删除
     */
    //@DeleteMapping("/delete")
    //@ApiOperation(value = "delete-4   删除品牌")
    public Result delete(@RequestBody Long[] brandIds){
        brandService.removeByIds(Arrays.asList(brandIds));

        return Result.ok();
    }


}
