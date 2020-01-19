package com.zlzc.modules.dictArea.controller;

import com.zlzc.common.annotation.RespTime;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.commodity.entity.CommodityCategoryEntity;
import com.zlzc.modules.dictArea.entity.DictAreaEntity;
import com.zlzc.modules.dictArea.service.DictAreaService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 地区字典表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-14 19:04:15
 */
@Api(value = "后台-地区字典", tags = { "V1.0 commodityCategory：后台-地区字典操作相关接口" })
@RestController
@RequestMapping("rest/dictarea")
public class DictAreaController {
    @Autowired
    private DictAreaService dictAreaService;

    /**
     * 获取地区列表(根据父id)列表
     */
    @ApiResponses(value = {
            @ApiResponse(response = CommodityCategoryEntity.class, code = 200, message = "获取地区列表(根据父id)列表响应字段说明")
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "parentId", value = "父ID", defaultValue = "1", paramType = "path"),})
    @RespTime("/dictAreaByParentId")
    @ApiOperation(value = "dictArea-2 获取地区列表(根据parentId)")
    @GetMapping("/dictAreaByParentId/{parentId}")
    //@formatter:off
    //@formatter:on
    public Result dictAreaByParentId(@PathVariable("parentId") long parentId) {
        List<DictAreaEntity> list = dictAreaService.dictAreaByParentId(parentId);

        return Result.ok().put("list", list);

    }

    /**
     * 获取地区列表(一级)列表(可以不传参)
     */
    @ApiResponses(value = {
            @ApiResponse(response = CommodityCategoryEntity.class, code = 200, message = "获取地区列表(一级)字段说明")
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "parentId", value = "父ID", defaultValue = "1", paramType = "path", required = false),})
    @RespTime("/commodityCategoryList")
    @ApiOperation(value = "dictArea-1 获取地区列表(一级)列表(可以不传参,默认1)")
    @GetMapping("/commodityCategoryList/{parentId}")
    //@formatter:off
    //@formatter:on
    public Result dictAreaList() {
        List<DictAreaEntity> list = dictAreaService.dictAreaList(null);

        return Result.ok().put("list", list);

    }

    /**
     * 信息
     */
    @RequestMapping("/info/{zreaId}")
    public Result info(@PathVariable("zreaId") Long zreaId){
        DictAreaEntity dictArea = dictAreaService.getById(zreaId);

        return Result.ok().put("dictArea", dictArea);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody DictAreaEntity dictArea){
        dictAreaService.save(dictArea);

        return Result.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long[] zreaIds){
        dictAreaService.removeByIds(Arrays.asList(zreaIds));

        return Result.ok();
    }

}
