package com.zlzc.api.rest.brand.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zlzc.api.rest.brand.entity.BrandCategoryEntity;
import com.zlzc.api.rest.brand.entity.BrandEntity;
import com.zlzc.api.rest.brand.service.BrandCategoryService;
import com.zlzc.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;


/**
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
//@Api(value = "App-品牌-分类", tags = { "V1.0 appBrandCategory：App-品牌-分类操作相关接口" })
@RestController
@RequestMapping("App/brandCategory")
public class BrandCategoryController {
    @Autowired
    private BrandCategoryService brandCategoryService;

    /**
     * 保存
     */
    //@ApiOperation(value = "save-2 添加一个品牌分类")
    @PostMapping("/save")
    public Result save(@RequestBody BrandCategoryEntity brandCategory){
        brandCategoryService.save(brandCategory);

        return Result.ok();
    }

    /**
     * 修改
     */
    //@ApiOperation(value = "update-3 修改一个品牌分类")
    @PutMapping("/update")
    public Result update(@RequestBody BrandCategoryEntity brandCategory){
        ValidatorUtils.validateEntity(brandCategory);
        brandCategoryService.updateById(brandCategory);
        
        return Result.ok();
    }

    /**
     * 删除
     */
   // @ApiOperation(value = "update-4 删除一个品牌分类")
    @DeleteMapping("/delete")
    public Result delete(@RequestBody Integer[] brandCategoryIds){
        brandCategoryService.removeByIds(Arrays.asList(brandCategoryIds));

        return Result.ok();
    }

}
