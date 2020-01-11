package com.zlzc.api.rest.shop.controller;


import com.zlzc.api.rest.shop.entity.ShopEntity;
import com.zlzc.api.rest.shop.service.ShopService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.common.validator.ValidatorUtils;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 功能描述:
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.merchant.controller
 * @ClassName: MerchantController
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2019/12/5 23:01
 * @Version: 1.0
 */
@Api(value = "api-店铺", tags = { "V1.0 shop：api-店铺操作相关接口" })
@RestController
@RequestMapping("shop")
public class ShopController {
	@Autowired
	private ShopService shopService;


    @ApiOperation(value = "shop-6 根据筛选条件获取店铺列表（可分页）")
     /**
       * @描述:merchant-6 根据筛选条件获取商户列表（可分页）
       * @Method: listByCondition
       * @Author: LBB
       * @E-mail: biaobiao999@163.com
       * @Version: 1.0
       * @param params
      * @param merchant
       * @return: com.zlzc.common.utils.Result
       * @Exception
       * @Date:  2019/12/5 23:46
       */
	@ApiResponses(value = {
			@ApiResponse(response = ShopEntity.class, code = 200, message = "根据筛选条件获取商户列表（可分页）响应字段说明")
	})
    @PostMapping("/listByCondition")
    //@formatter:off
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
                    @ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
            }
    )
    //@formatter:on
    public Result listByCondition(@ApiParam(hidden = true) @RequestParam Map<String, Object> params,
                                  @RequestBody ShopEntity shop) {
		PageUtils page=shopService.queryPageWithCnt(params, shop);
       // PageUtils page = shopService.queryPageByCondition(params, shop);
        return Result.ok().put("page", page);
    }

	@ApiOperation(value = "shop-5 删除指定ID的店铺")
     /**
       * @描述:shop-5 删除指定ID的店铺
       * @Method: delete
       * @Author: LBB
       * @E-mail: biaobiao999@163.com
       * @Version: 1.0
       * @param shopIds
       * @return: com.zlzc.common.utils.Result
       * @Exception
       * @Date:  2019/12/5 23:07
       */
	@DeleteMapping("/delete")
	// @formatter:off
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "shopIds", value = "店铺ID[]; [1,2,3]", paramType = "body", dataTypeClass = String.class, allowMultiple = true) })
	// @formatter:on
	public Result delete(@RequestBody String[] shopIds) {
		shopService.removeByIds(Arrays.asList(shopIds));

		return Result.ok();
	}

	@ApiOperation(value = "shop-4 修改店铺信息")
      /**
        * @描述:shop-4 修改店铺信息
        * @Method: update
        * @Author: LBB
        * @E-mail: biaobiao999@163.com
        * @Version: 1.0
        * @param shop
        * @return: com.zlzc.common.utils.Result
        * @Exception
        * @Date:  2019/12/5 23:06
        */
	@PutMapping("/update")
	public Result update(@RequestBody ShopEntity shop) {
		ValidatorUtils.validateEntity(shop);

		shopService.updateById(shop);

		return Result.ok();
	}

	@ApiOperation(value = "shop-3 添加店铺")
     /**
       * @描述:shop-3 添加店铺
       * @Method: save
       * @Author: LBB
       * @E-mail: biaobiao999@163.com
       * @Version: 1.0
       * @param shop
       * @return: com.zlzc.common.utils.Result
       * @Exception
       * @Date:  2019/12/5 23:08
       */
	@PostMapping("/save")
	public Result save(@RequestBody ShopEntity shop) {
		shopService.save(shop);

		return Result.ok();
	}

	@ApiOperation(value = "shop-2 根据店铺ID获取商户信息")
     /**
       * @描述:shop-2 根据店铺ID获取商户信息
       * @Method: info
       * @Author: LBB
       * @E-mail: biaobiao999@163.com
       * @Version: 1.0
       * @param shopId
       * @return: com.zlzc.common.utils.Result
       * @Exception
       * @Date:  2019/12/5 23:10
       */
	@ApiResponses(value = {
			@ApiResponse(response = ShopEntity.class, code = 200, message = "根据店铺ID获取商户信息响应字段说明")
	})
	@GetMapping("/queryShopDetails/{shopId}")
	// @formatter:off
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "shopId", value = "店铺ID", defaultValue = "1", paramType = "path"), })
	// @formatter:on
	public Result queryShopDetails(@PathVariable("shopId") Integer shopId) {
		Map<String, Object> rsMap =shopService.queryShopDetails(shopId);
		return Result.ok().put("rs", rsMap);
	}


	@ApiOperation(value = "shop-1 获取店铺列表(可分页)")
     /**
      *
      *
      *
       * @描述:shop-1 获取店铺列表(可分页)
       * @Method: list
       * @Author: LBB
       * @E-mail: biaobiao999@163.com
       * @Version: 1.0
       * @param params
       * @return: com.zlzc.common.utils.Result
       * @Exception
       * @Date:  2019/12/5 23:10
       */
	@ApiResponses(value = {
			@ApiResponse(response = ShopEntity.class, code = 200, message = "获取店铺列表(可分页)响应字段说明")
	})
	@GetMapping("/list")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query") })
	// @formatter:on
	public Result list(@ApiParam(hidden = true) @RequestParam Map<String, Object> params) {
		PageUtils page = shopService.queryPage(params);

		return Result.ok().put("page", page);
	}
	@ApiOperation(value = "shop-0 获取店铺列表(可分页)")
	/**
	 *
	 *
	 *
	 * @描述:shop-1 获取店铺列表(可分页)
	 * @Method: list
	 * @Author: LBB
	 * @E-mail: biaobiao999@163.com
	 * @Version: 1.0
	 * @param params
	 * @return: com.zlzc.common.utils.Result
	 * @Exception
	 * @Date:  2019/12/5 23:10
	 */
	@ApiResponses(value = {
			@ApiResponse(response = ShopEntity.class, code = 200, message = "获取店铺列表(可分页)响应字段说明")
	})
	@GetMapping("/queryPageShop")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query") })
	// @formatter:on
	public Result queryPageShop(@ApiParam(hidden = true) @RequestParam Map<String, Object> params) {
		PageUtils page = shopService.queryPage(params);

		return Result.ok().put("page", page);
	}

}
