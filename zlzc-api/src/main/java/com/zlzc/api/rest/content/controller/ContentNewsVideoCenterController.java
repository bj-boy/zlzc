package com.zlzc.api.rest.content.controller;

import java.util.Arrays;
import java.util.Map;

import com.zlzc.api.rest.content.entity.ContentNewsVideoCenterEntity;
import com.zlzc.api.rest.content.service.ContentNewsVideoCenterService;
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
 * 
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@RestController
@RequestMapping("rest/contentnewsvideocenter")
public class ContentNewsVideoCenterController {
    @Autowired
    private ContentNewsVideoCenterService contentNewsVideoCenterService;




    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody ContentNewsVideoCenterEntity contentNewsVideoCenter){
        contentNewsVideoCenterService.save(contentNewsVideoCenter);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody ContentNewsVideoCenterEntity contentNewsVideoCenter){
        ValidatorUtils.validateEntity(contentNewsVideoCenter);
        contentNewsVideoCenterService.updateById(contentNewsVideoCenter);
        
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long[] newsVideoCenterIds){
        contentNewsVideoCenterService.removeByIds(Arrays.asList(newsVideoCenterIds));

        return Result.ok();
    }

}
