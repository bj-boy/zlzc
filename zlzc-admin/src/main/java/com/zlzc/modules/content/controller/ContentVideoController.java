package com.zlzc.modules.content.controller;

import com.zlzc.common.utils.Result;
import com.zlzc.common.validator.ValidatorUtils;
import com.zlzc.modules.content.entity.ContentVideoEntity;
import com.zlzc.modules.content.service.ContentVideoService;
import com.zlzc.modules.content.vo.VideoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 视频表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@RestController
@RequestMapping("rest/contentvideo")
@Api(value = "后台-视频", tags = { "V1.0 视频咨询：后台-视频相关接口" })
public class ContentVideoController {
    @Autowired
    private ContentVideoService contentVideoService;

    /**
     * 获取视频列表
     */
    @ApiOperation(value = "getVideoList-1 查询所有视频")
    @GetMapping("/getVideoList")
    @ApiResponses(value ={
            @ApiResponse(response=ContentVideoEntity.class,code = 200, message = "getInformation-1 查询所有视频")})
    public Result getVideoList(){
        List<ContentVideoEntity> videoList = contentVideoService.getVideoList();
        return Result.ok().put("videoList", videoList);
    }
    /**
     * 根据id获取视频详情
     */
    @ApiOperation(value = "getVideoById-2 根据id获取视频详情")
    @GetMapping("/getVideoById/{videoId}")
    @ApiResponses(value ={
            @ApiResponse(response=ContentVideoEntity.class,code = 200, message = "getVideoById-1 根据id获取视频详情")})
    public Result getVideoById(@PathVariable("videoId") Long videoId){
        ContentVideoEntity byId = contentVideoService.getById(videoId);
        return Result.ok().put("byId", byId);
    }


    /**
     * 根据id获取视频相关联的商品
     */
    @ApiOperation(value = "getVideoCommodityById-3 根据id获取视频相关联的商品")
    @GetMapping("/getVideoCommodityById/{videoId}")
    @ApiResponses(value ={
            @ApiResponse(response= VideoVo.class,code = 200, message = "getVideoCommodityById-3 根据id获取视频相关联的商品")})
    public Result getVideoCommodityById(@PathVariable("videoId") Long videoId){
        List<VideoVo> videoCommodityById = contentVideoService.getVideoCommodityById(videoId);

        return Result.ok().put("videoCommodityById", videoCommodityById);
    }

    /**
     * 根据id获取视频相关评论
     */

    @ApiOperation(value = "getVideoContentById-4 根据id 获取视频相关评论")
    @GetMapping("/getVideoContentById/{videoId}")
    @ApiResponses(value ={
            @ApiResponse(response=VideoVo.class,code = 200, message = "getVideoContentById-4 根据id 获取视频相关评论")})
    public Result getVideoContentById(@PathVariable("videoId") Long videoId){
        List<VideoVo> videoContentById = contentVideoService.getVideoContentById(videoId);
        return Result.ok().put("videoContentById", videoContentById);
    }

    /**
     * 视频快捷搜索
     * @param
     * @return
     */
    @ApiOperation(value = "getVideoSearchFor-5  视频快捷搜索")
    @GetMapping("/getVideoSearchFor/{videoTitle}")
    @ApiResponses(value ={
            @ApiResponse(response=ContentVideoEntity.class,code = 200, message = "getVideoSearchFor-5 资讯快捷搜索")})
    public Result getVideoSearchFor(@PathVariable("videoTitle") String videoTitle){

        List<ContentVideoEntity> videoSearchFor = contentVideoService.getVideoSearchFor(videoTitle);
        return Result.ok().put("videoSearchFor", videoSearchFor);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody ContentVideoEntity contentVideo){
        contentVideoService.save(contentVideo);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody ContentVideoEntity contentVideo){
        ValidatorUtils.validateEntity(contentVideo);
        contentVideoService.updateById(contentVideo);
        
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long[] videoIds){
        contentVideoService.removeByIds(Arrays.asList(videoIds));

        return Result.ok();
    }

}
