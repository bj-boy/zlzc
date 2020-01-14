package com.zlzc.api.rest.logistics.controller;


import com.zlzc.api.rest.dict.entity.DictEntity;
import com.zlzc.api.rest.logistics.entity.LogisticsEntity;
import com.zlzc.api.rest.logistics.entity.UserAddressEntity;
import com.zlzc.api.rest.logistics.service.UserAddressService;
import com.zlzc.common.utils.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Api(value = "App-地址管理", tags = { "V1.0 UserAddress：App-地址管理操作相关接口" })
@RestController
@RequestMapping("/App/UserAddress")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    /**
     * 根据地址id查询详细信息
     */
    @ApiOperation(value = "UserAddress-1 根据地址id查询地址")
    @GetMapping("/info/{id}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "id", value = "地址id", defaultValue = "001", paramType = "path"),
            }
    )
    public Result info(@PathVariable("id") String id){
        UserAddressEntity userAddress = userAddressService.getById(id);
        return Result.ok().put("userAddress",userAddress);
    }

    /**
     * 根据地址用户id查询全部地址
     */
    @ApiOperation(value = "UserAddress-2 根据地址用户id查询全部地址")
    @GetMapping("/userInfo/{id}")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "001", paramType = "path"),
            }
    )
    public Result userInfo(@PathVariable("id") String id){
        List<UserAddressEntity> userAddress = userAddressService.getListUserByID(id);
        return Result.ok().put("userAddress",userAddress);
    }


    /**
     *保存
     */
    @ApiOperation(value = "logistics-2 添加地址信息")
    @PostMapping("/save")
    public Result save(@RequestBody UserAddressEntity userAddressEntity){
        userAddressService.save(userAddressEntity);
        return Result.ok();
    }

    /**
     *修改
     */
    @ApiOperation(value = "logistics-3 根据id修改地址信息")
    @PutMapping("/update")
    public Result update(@RequestBody UserAddressEntity userAddressEntity){
        userAddressService.updateById(userAddressEntity);
        return Result.ok();
    }


    /**
     *删除
     */
    @ApiOperation(value = "删除指定ID的地址信息")
    @DeleteMapping("/delete")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(
                            name = "addressID",
                            value = "地址信息ID[]; [1,2,3]",
                            paramType = "body",
                            dataTypeClass = String.class,
                            allowMultiple = true
                    )
            }
    )
    public Result delete(@RequestBody String[] addressID){
        userAddressService.removeByIds(Arrays.asList(addressID));
        return Result.ok();
    }

}
