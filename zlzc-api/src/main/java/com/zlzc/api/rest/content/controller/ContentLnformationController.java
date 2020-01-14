package com.zlzc.api.rest.content.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.api.R;
import com.zlzc.api.rest.content.entity.ContentCommentEntity;
import com.zlzc.api.rest.content.entity.ContentLnformationEntity;
import com.zlzc.api.rest.content.service.ContentLnformationService;
import com.zlzc.api.rest.content.vo.ContentLnformationVo;
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
 * 资讯
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@RestController
@RequestMapping("app/contentlnformation")
@Api(value = "App-资讯", tags = { "V1.0 appA：App-资讯相关接口" })
public class ContentLnformationController {
    @Autowired
    private ContentLnformationService contentLnformationService;


    /**
     * 查询所有资讯
     */
    @ApiOperation(value = "getInformation-1 查询所有资讯")
    @GetMapping("/getInformation")
    @ApiResponses(value ={
            @ApiResponse(response=ContentLnformationEntity.class,code = 200, message = "getInformation-1 查询所有资讯")})
    public Result getInformation(){
        List<ContentLnformationEntity> informationService = contentLnformationService.getInformationService();

        return Result.ok().put("informationService", informationService);
    }
    /**
     * 根据id查询资讯
     */
    @ApiOperation(value = "getInformation-2 根据id查询资讯")
    @GetMapping("/getInformationById/{informationId}")
    @ApiResponses(value ={
            @ApiResponse(response=ContentLnformationEntity.class,code = 200, message = "getInformation-1 查询所有资讯")})
    public Result getInformationById(@PathVariable("informationId") Long informationId){
        ContentLnformationEntity byId = contentLnformationService.getById(informationId);
        return Result.ok().put("byId", byId);
    }

    /**
     * 根据id查询资讯相关商品
     */
    @ApiOperation(value = "getInformationCommodityById-3 根据id查询相关商品")
    @GetMapping("/getInformationCommodityById/{informationId}")
    @ApiResponses(value ={
            @ApiResponse(response=ContentLnformationVo.class,code = 200, message = "getInformationCommodityById-3 根据id查询相关商品")})
    public Result getInformationCommodityById(@PathVariable("informationId") Long informationId){
        List<ContentLnformationVo> informationCommodityByIdService = contentLnformationService.getInformationCommodityByIdService(informationId);
        return Result.ok().put("informationCommodityByIdService", informationCommodityByIdService);
    }

    /**
     * 根据id查询资讯相关评论
     */
    @ApiOperation(value = "getInformationContentById-4 根据id查询关评论")
    @GetMapping("/getInformationContentById/{informationId}")
    @ApiResponses(value ={
            @ApiResponse(response=ContentLnformationEntity.class,code = 200, message = "getInformationContentById-4 根据id查询关评论")})
    public Result getInformationContentById(@PathVariable("informationId") Long informationId){
        List<ContentLnformationVo> informationContentById = contentLnformationService.getInformationContentById(informationId);
        return Result.ok().put("informationContentById", informationContentById);
    }

    /**
     * 资讯快捷搜索
     * @param
     * @return
     */
    @ApiOperation(value = "getInformationSearchFor-5  资讯快捷搜索")
    @GetMapping("/getInformationSearchFor/{InformationTitle}")
    @ApiResponses(value ={
            @ApiResponse(response=ContentLnformationEntity.class,code = 200, message = "getInformationSearchFor-4 资讯快捷搜索")})
    public Result getInformationSearchFor(@PathVariable("InformationTitle") String InformationTitle){
        List<ContentLnformationEntity> informationSearchFor = contentLnformationService.getInformationSearchFor(InformationTitle);
        return Result.ok().put("informationSearchFor", informationSearchFor);
    }





    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody ContentLnformationEntity contentLnformation){
        contentLnformationService.save(contentLnformation);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody ContentLnformationEntity contentLnformation){
        ValidatorUtils.validateEntity(contentLnformation);
        contentLnformationService.updateById(contentLnformation);
        
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long[] informationIds){
        contentLnformationService.removeByIds(Arrays.asList(informationIds));

        return Result.ok();
    }

}
