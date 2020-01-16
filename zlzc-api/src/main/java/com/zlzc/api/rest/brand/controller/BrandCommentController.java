package com.zlzc.api.rest.brand.controller;

import java.util.Arrays;
import java.util.Map;

import com.zlzc.api.rest.brand.entity.BrandCommentEntity;
import com.zlzc.api.rest.brand.service.BrandCommentService;
import com.zlzc.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;


/**
 * 
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:44
 */
@RestController
@RequestMapping("rest/brandcomment")
public class BrandCommentController {
    @Autowired
    private BrandCommentService brandCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = brandCommentService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandCommentId}")
    public Result info(@PathVariable("brandCommentId") Long brandCommentId){
        BrandCommentEntity brandComment = brandCommentService.getById(brandCommentId);

        return Result.ok().put("brandComment", brandComment);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody BrandCommentEntity brandComment){
        brandCommentService.save(brandComment);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result update(@RequestBody BrandCommentEntity brandComment){
        ValidatorUtils.validateEntity(brandComment);
        brandCommentService.updateById(brandComment);
        
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public Result delete(@RequestBody Long[] brandCommentIds){
        brandCommentService.removeByIds(Arrays.asList(brandCommentIds));

        return Result.ok();
    }

}
