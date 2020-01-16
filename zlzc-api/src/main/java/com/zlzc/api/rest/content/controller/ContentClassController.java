package com.zlzc.api.rest.content.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.extension.api.R;
import com.zlzc.api.rest.content.entity.ContentClassEntity;
import com.zlzc.api.rest.content.service.ContentClassService;
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
 * 视频资讯分类表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@RestController
@RequestMapping("rest/contentclass")
public class ContentClassController {
    @Autowired
    private ContentClassService contentClassService;
    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody ContentClassEntity contentClass){
        contentClassService.save(contentClass);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody ContentClassEntity contentClass){
        ValidatorUtils.validateEntity(contentClass);
        contentClassService.updateById(contentClass);
        
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] informationClassIds){
        contentClassService.removeByIds(Arrays.asList(informationClassIds));

        return Result.ok();
    }

}
