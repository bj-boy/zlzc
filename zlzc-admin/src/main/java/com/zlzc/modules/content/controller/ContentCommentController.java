package com.zlzc.modules.content.controller;

import com.zlzc.common.utils.Result;
import com.zlzc.common.validator.ValidatorUtils;
import com.zlzc.modules.content.entity.ContentCommentEntity;
import com.zlzc.modules.content.service.ContentCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


/**
 * 视频资讯评论表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@RestController
@RequestMapping("app/contentcomment")
public class ContentCommentController {
    @Autowired
    private ContentCommentService contentCommentService;


    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody ContentCommentEntity contentComment){
        contentCommentService.save(contentComment);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody ContentCommentEntity contentComment){
        ValidatorUtils.validateEntity(contentComment);
        contentCommentService.updateById(contentComment);
        
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] commentIds){
        contentCommentService.removeByIds(Arrays.asList(commentIds));

        return Result.ok();
    }

}
