package com.zlzc.modules.logistics.controller;

import com.zlzc.common.utils.Result;
import com.zlzc.modules.dict.entity.DictEntity;
import com.zlzc.modules.logistics.entity.LogisticsEntity;
import com.zlzc.modules.logistics.service.LogisticsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@Api(value = "后台-快递物流", tags = { "V1.0 logistics：后台-快递物流操作相关接口" })
@RestController
@RequestMapping("/logistics")
public class LogisticsController {


    @Autowired
    private LogisticsService logisticsService;

    /**
     * 根据物流快id查询详细信息
     */
    @ApiResponses(value = {
            @ApiResponse(response = DictEntity.class, code = 200, message = "根据物流快id查询详细信息响应字段说明")
    })
    @ApiOperation(value = "logistics-1 根据物流快id查询详细信息")
    @GetMapping("/info/{number}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "number", value = "快递单号", defaultValue = "number", paramType = "path"),
            }
    )
    public Result info(@PathVariable("number") String number){
        LogisticsEntity logistics = logisticsService.getLogistics(number);
        return Result.ok().put("logistics",logistics);
    }

    /**
     *保存
     */
    @ApiOperation(value = "logistics-2 添加物流快递信息")
    @PostMapping("/save")
    public Result save(@RequestBody LogisticsEntity logisticsEntity){
        logisticsService.save(logisticsEntity);
        return Result.ok();
    }

    /**
     *修改
     */
    @ApiOperation(value = "logistics-3 根据id进行修改快递物流")
    @PutMapping("/update")
    public Result update(@RequestBody LogisticsEntity logisticsEntity){
        logisticsService.updateById(logisticsEntity);
        return Result.ok();
    }


    /**
     *删除
     */
    @ApiOperation(value = "字典 删除指定ID的快递物流信息")
    @DeleteMapping("/delete")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(
                            name = "logisticsId",
                            value = "物流快递ID[]; [1,2,3]",
                            paramType = "body",
                            dataTypeClass = String.class,
                            allowMultiple = true
                    )
            }
    )
    public Result delete(@RequestBody String[] logisticsIds){
        logisticsService.removeByIds(Arrays.asList(logisticsIds));

        return Result.ok();
    }

}
