package com.zlzc.modules.dict.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.dict.entity.DictEntity;
import com.zlzc.modules.dict.service.DictService;
import com.zlzc.modules.merchant.entity.MerchantEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-11-30 14:01:13
 */
@Api(value = "后台-字典", tags = { "V1.0 dict：后台-字典操作相关接口" })
@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    private DictService dictService;


    /**
     * 根据标签查寻字典值
     */
    @ApiOperation(value = "dict 根据字典标签查询")
    @GetMapping("/info/{dictLabel}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "dictLabel", value = "标签名", defaultValue = "zezl_user_xb", paramType = "path"),
            }
    )
    public Result info(@PathVariable("dictLabel") String dictLabel){
        List<DictEntity> dict = dictService.getDict(dictLabel);
        return Result.ok().put("dict",dict);
    }

    /**
     *保存
     */
    @ApiOperation(value = "dict 添加字典项")
    @PostMapping("/save")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "dictLabel", value = "标签名", defaultValue = "null", paramType = "path"),
            }
    )
    public Result save(@RequestBody DictEntity dictEntity){
        dictService.save(dictEntity);
        return Result.ok();
    }

    /**
     *修改
     */
    @ApiOperation(value = "dict 根据id进行修改字典")
    @PutMapping("/update")
    public Result update(@RequestBody DictEntity dictEntity){
        dictService.updateById(dictEntity);
        return Result.ok();
    }


    /**
     *删除
     */
    @ApiOperation(value = "字典 删除指定ID的字典项")
    @DeleteMapping("/delete")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(
                            name = "dictIds",
                            value = "字典ID[]; [1,2,3]",
                            paramType = "body",
                            dataTypeClass = String.class,
                            allowMultiple = true
                    )
            }
    )
    public Result delete(@RequestBody String[] dictIds){
        dictService.removeByIds(Arrays.asList(dictIds));

        return Result.ok();
    }
}
