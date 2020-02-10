package com.zlzc.modules.content.controller;

import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.common.validator.ValidatorUtils;
import com.zlzc.modules.content.entity.ContentLnformationEntity;
import com.zlzc.modules.content.service.ContentLnformationService;
import com.zlzc.modules.content.vo.ContentLnformationVo;
import com.zlzc.modules.content.vo.ContentlnSaveVo;
import com.zlzc.modules.shop.respType.queryPageShopRT;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 资讯
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@RestController
@RequestMapping("app/contentlnformation")
@Api(value = "后台-资讯", tags = { "V1.0 文字咨询：后台-资讯相关接口" })
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
     * 查询所有资讯(文字,可分页)
     */
    @ApiOperation(value = "queryPageText-6 查询所有资讯(文字,可分页)")
    @ApiResponses(value = {
            @ApiResponse(response = queryPageShopRT.class, code = 200, message = "查询所有资讯(文字,可分页)响应字段说明")
    })
    @GetMapping("/queryPageText")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query") })
    // @formatter:on
    public Result queryPageText(@ApiParam(hidden = true) @RequestParam Map<String, Object> params) {
        PageUtils page = contentLnformationService.queryPageText(params);

        return Result.ok().put("page", page);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "saveText  添加资讯")
    @PutMapping("/saveText")
    public Result save(@RequestBody ContentlnSaveVo contentlnSaveVo){
        boolean b = contentLnformationService.saveText(contentlnSaveVo);
        return Result.ok().put("b",b);
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
