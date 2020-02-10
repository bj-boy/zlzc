package com.zlzc.modules.content.controller;

import com.zlzc.common.utils.Result;
import com.zlzc.common.validator.ValidatorUtils;
import com.zlzc.modules.content.entity.ContentNewsVideoCenterEntity;
import com.zlzc.modules.content.service.ContentNewsVideoCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


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
