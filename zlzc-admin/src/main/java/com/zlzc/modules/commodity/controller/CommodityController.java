package com.zlzc.modules.commodity.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.commodity.service.CommodityService;
import com.zlzc.modules.commodity.vo.CommodityVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Api(value = "后台-商品", tags = { "V1.0 commodity：后台-商品操作相关接口" })
@RestController
@RequestMapping("commodity")
public class CommodityController {
	@Autowired
	private CommodityService commodityService;

	/**
	 * 列表
	 */
	@ApiOperation(value = "merchant-1 获取商品列表（可分页）")
	@GetMapping("/list")
	//@formatter:off
  	@ApiImplicitParams(
  		value = {
  			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
  			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
  		}
  	)
  	//@formatter:on
	public Result list(@ApiParam(hidden = true) @RequestParam Map<String, Object> params) {
		PageUtils page = commodityService.queryPage(params);

		return Result.ok().put("page", page);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "merchant-2 添加商品")
	@PostMapping("/save")
	public Result save(@RequestBody CommodityVo comm) {
		
		CommodityVo commodity = new CommodityVo();
		commodity.setMerchantId(7L);
		commodity.setShopId(2L);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		boolean isSave = commodityService.saveCommodity(commodity);
		
		
		
		return Result.ok().put("rs", isSave);
	}

	/* ################ generator ################ */

	/**
	 * 列表
	 */
	// @RequestMapping("/list")
	// public Result list(@RequestParam Map<String, Object> params){
	// PageUtils page = commodityService.queryPage(params);
	//
	// return Result.ok().put("page", page);
	// }

	/**
	 * 信息
	 */
	// @RequestMapping("/info/{commodityId}")
	// public Result info(@PathVariable("commodityId") Long commodityId){
	// CommodityEntity commodity = commodityService.getById(commodityId);
	//
	// return Result.ok().put("commodity", commodity);
	// }

	/**
	 * 保存
	 */
	// @RequestMapping("/save")
	// public Result save(@RequestBody CommodityEntity commodity){
	// commodityService.save(commodity);
	//
	// return Result.ok();
	// }

	/**
	 * 修改
	 */
	// @RequestMapping("/update")
	// public Result update(@RequestBody CommodityEntity commodity){
	// ValidatorUtils.validateEntity(commodity);
	// commodityService.updateById(commodity);
	//
	// return Result.ok();
	// }

	/**
	 * 删除
	 */
	// @RequestMapping("/delete")
	// public Result delete(@RequestBody Long[] commodityIds){
	// commodityService.removeByIds(Arrays.asList(commodityIds));
	//
	// return Result.ok();
	// }

}
