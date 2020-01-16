package com.zlzc.api.rest.shop.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import com.zlzc.api.rest.shop.service.ShopService;
import com.zlzc.api.rest.shop.vo.ShopVo;
import com.zlzc.common.utils.Result;
import com.zlzc.common.validator.ValidatorUtils;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
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

	/**
	 * 店铺列表
	 */
	@ApiOperation(value = "listShop-1 根据userName 查询所对应店铺列表（可分页）")
	@ApiResponses(value = {
			@ApiResponse(response = ShopVo.class, code = 200, message = "根据userName 查询所对应店铺列表（可分页）")
	})
	@PostMapping("/listShop")
	//@formatter:off
	@ApiImplicitParams(
			value = {
					@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
					@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query"),
					@ApiImplicitParam(name = "userName", value = "用户名", defaultValue = "10", paramType = "query")
			}
	)
	public Result listShop(@ApiParam(hidden = true) @RequestParam Map<String, Object> params,
						   @RequestParam String userName){
		IPage<ShopVo> shopVoIPage = shopService.listShop(params, userName);
		return Result.ok().put("shopVoIPage", shopVoIPage);
	}

	/**
	 *根据id查询店铺信息
	 */
	@ApiResponses(value = {
			@ApiResponse(response = ShopEntity.class, code = 200, message = "根据id查询店铺信息")
	})
	@ApiOperation(value = "ShopById-2  根据id查询当前店铺信息")
	@GetMapping("/ShopById/{shopId}")
	public Result ShopById(@PathVariable("shopId") Long shopId ){
		ShopEntity byId = shopService.getById(shopId);
		return Result.ok().put("byId", byId);
	}

	/**
	 *店铺搜索
	 */
	@ApiResponses(value = {
			@ApiResponse(response = ShopEntity.class, code = 200, message = "根据店铺名称搜索店铺信息")
	})
	@ApiOperation(value = "ShopByName-3  根据店铺名称搜索店铺信息")
	@GetMapping("/ShopByName/{byName}")
	public Result ShopByName(@PathVariable("byName") String byName){
		List<ShopEntity> shopEntity = shopService.ShopByName(byName);
		return Result.ok().put("shopEntity", shopEntity);
	}


	/**
	 *店铺内部商品搜索
	 */
	@ApiResponses(value = {
			@ApiResponse(response = ShopVo.class, code = 200, message = "店铺内部商品搜索")
	})
	@ApiOperation(value = "shopCommodityByName-4  店铺内部商品搜索")
	@GetMapping("/shopCommodityByName/{commodityName}")
	public Result shopCommodityByName(@PathVariable("commodityName") String commodityName){
		List<ShopVo> shopVos = shopService.shopCommodityByName(commodityName);
		return Result.ok().put("shopVos", shopVos);
	}

	/**
	 *首页商品
	 */
	@ApiImplicitParams(
			value = {
					@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
					@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
			}
	)
	@ApiResponses(value = {
			@ApiResponse(response = ShopVo.class, code = 200, message = "首页商品列表")
	})
	@ApiOperation(value = "shopCommodityByName-5  首页商品列表")
	@GetMapping("/shopCommodityList")
	public Result shopCommodityList(@ApiParam(hidden = true) @RequestParam Map<String, Object> params){
		IPage<ShopVo> shopVoIPage = shopService.shopCommodityList(params);
		return Result.ok().put("shopVoIPage", shopVoIPage);
	}

	/**
	 *店铺品牌列表
	 */
	@ApiImplicitParams(
			value = {
					@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
					@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query"),
					@ApiImplicitParam(name = "shopId", value = "店铺id", defaultValue = "10", paramType = "query")
			}
	)
	@ApiResponses(value = {
			@ApiResponse(response = ShopVo.class, code = 200, message = "店铺品牌列表")
	})
	@ApiOperation(value = "shopBrandList-6  店铺品牌列表")
	@GetMapping("/shopBrandList")
	public Result shopBrandList(@ApiParam(hidden = true) @RequestParam Map<String, Object> params,
								@RequestParam Long shopId){
		IPage<ShopVo> shopVoIPage = shopService.shopBrandList(params,shopId);
		return Result.ok().put("shopVoIPage", shopVoIPage);
	}

	/**
	 *店铺品牌下的商品
	 */
	@ApiImplicitParams(
			value = {
					@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
					@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query"),
					@ApiImplicitParam(name = "brandId", value = "品牌id", defaultValue = "10", paramType = "query")
			}
	)
	@ApiResponses(value = {
			@ApiResponse(response = ShopVo.class, code = 200, message = "店铺品牌下的商品列表")
	})
	@ApiOperation(value = "brandCommodityList-7  店铺品牌下的商品列表")
	@GetMapping("/brandCommodityList")
	public Result brandCommodityList(@ApiParam(hidden = true) @RequestParam Map<String, Object> params,
									 @RequestParam Long brandId){
		IPage<ShopVo> shopVoIPage = shopService.brandCommodityList(params, brandId);
		return Result.ok().put("shopVoIPage", shopVoIPage);
	}

	/**
	 * 查询店铺商品的分类
	 */
	@ApiImplicitParams(
			value = {
					@ApiImplicitParam(name = "shopId", value = "店铺id", defaultValue = "10", paramType = "query")
			}
	)
	@ApiResponses(value = {
			@ApiResponse(response = ShopVo.class, code = 200, message = "查询店铺商品的分类")
	})
	@ApiOperation(value = "shopCommodityFL-8  查询店铺商品的分类")
	@GetMapping("/shopCommodityFL")
	public Result shopCommodityFL(@ApiParam(hidden = true) @RequestParam Long shopId){
		List<ShopVo> shopVos = shopService.shopCommodityFL(shopId);
		return Result.ok().put("shopVos", shopVos);
	}

	/**
	 *查询店铺简介
	 */
	@ApiImplicitParams(
			value = {
					@ApiImplicitParam(name = "shopId", value = "查询店铺简介", defaultValue = "10", paramType = "query")
			}
	)
	@ApiResponses(value = {
			@ApiResponse(response = ShopVo.class, code = 200, message = "查询店铺简介")
	})
	@ApiOperation(value = "shopMerchantIntroduction-9  查询店铺简介")
	@GetMapping("/shopMerchantIntroduction")
	public Result  shopMerchantIntroduction(@ApiParam(hidden = true) @RequestParam Long shopId){
		ShopVo shopVo = shopService.shopMerchantIntroduction(shopId);
		return Result.ok().put("shopVo", shopVo);
	}


    /*@ApiOperation(value = "shop-6 根据筛选条件获取店铺列表（可分页）")
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
    }*/



	/*@ApiOperation(value = "shop-5 删除指定ID的店铺")
ate:  2019/12/5 23:07
	@DeleteMapping("/delete")

	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "shopIds", value = "店铺ID[]; [1,2,3]", paramType = "body", dataTypeClass = String.class, allowMultiple = true) })
	*/
	public Result delete(@RequestBody String[] shopIds) {
		shopService.removeByIds(Arrays.asList(shopIds));

		return Result.ok();
	}

	//@ApiOperation(value = "shop-4 修改店铺信息")
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
	//@PutMapping("/update")
	public Result update(@RequestBody ShopEntity shop) {
		ValidatorUtils.validateEntity(shop);

		shopService.updateById(shop);

		return Result.ok();
	}

	//@ApiOperation(value = "shop-3 添加店铺")
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
	//@PostMapping("/save")
	public Result save(@RequestBody ShopEntity shop) {
		shopService.save(shop);

		return Result.ok();
	}

	//@ApiOperation(value = "shop-2 根据店铺ID获取商户信息")
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
	/*@ApiResponses(value = {
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
	}*/


	//@ApiOperation(value = "shop-1 获取店铺列表(可分页)")
     /**
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
	/*@ApiResponses(value = {
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
	}*/
	/*
	@ApiOperation(value = "shop-0 获取店铺列表(可分页)")
	@ApiResponses(value = {
			@ApiResponse(response = ShopEntity.class, code = 200, message = "获取店铺列表(可分页)响应字段说明")
	})
	@GetMapping("/queryPageShop")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query") })
	public Result queryPageShop(@ApiParam(hidden = true) @RequestParam Map<String, Object> params) {
		PageUtils page = shopService.queryPage(params);

		return Result.ok().put("page", page);
	}*/

}
