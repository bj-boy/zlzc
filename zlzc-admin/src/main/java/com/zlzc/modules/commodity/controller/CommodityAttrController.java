package com.zlzc.modules.commodity.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zlzc.common.annotation.RespTime;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.commodity.entity.CommodityAttrEntity;
import com.zlzc.modules.commodity.entity.CommodityParamEntity;
import com.zlzc.modules.commodity.entity.CommoditySkuEntity;
import com.zlzc.modules.commodity.service.CommodityAttrService;

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
@Api(value = "后台-商品-属性", tags = { "V1.0 commodityAttribute：后台-商品属性操作相关接口" })
@RestController
@RequestMapping("commodityAttr")
public class CommodityAttrController {

	@Autowired
	private CommodityAttrService commodityAttrService;

	/**
	 * 商品属性列表
	 */
	@RespTime("/commodityAttr/queryList")
	@ApiOperation(value = "commodityAttr-1 获取商品属性列表")
	@PostMapping("/queryList")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query"),
			@ApiImplicitParam(name = "merchantId", value = "商户ID", defaultValue = "7", paramType = "query"),
			@ApiImplicitParam(name = "shopId", value = "店铺ID", defaultValue = "2", paramType = "query")
		}
	)
	//@formatter:on
	public Result commodityAttrList(@ApiParam(hidden = true) @RequestParam Map<String, Object> params,
			@ApiParam(hidden = true) @RequestParam(required = false) Long merchantId,
			@ApiParam(hidden = true) @RequestParam(required = false) Long shopId) {
		PageUtils page = commodityAttrService.commodityAttrList(params, merchantId, shopId);
		return Result.ok().put("page", page);
	}

	/**
	 * 修改商品属性
	 */
	@RespTime("/commodityAttr/updCommodityAttr")
	@ApiOperation(value = "commodityAttr-2  修改商品属性")
	@PutMapping("/updCommodityAttr")
	public Result updCommodityAttr(@RequestBody CommodityAttrEntity commodityAttr) {
		return Result.ok().put("rs", commodityAttrService.updCommodityAttr(commodityAttr));
	}

	/**
	 * 新增商品属性
	 */
	@RespTime("/commodityAttr/saveCommodityAttr")
	@ApiOperation(value = "commodityAttr-3 新增商品属性")
	@PostMapping("/saveCommodityAttr")
	public Result saveCommodityAttr(@RequestBody CommodityAttrEntity commodityAttr) {
		return Result.ok().put("rs", commodityAttrService.saveCommodityAttr(commodityAttr));
	}

	/**
	 * 删除商品属性
	 */
	@RespTime("/commodityAttr/delCommodityAttr")
	@ApiOperation(value = "commodityAttr-4  删除商品属性(可批量)")
	@DeleteMapping("/delCommodityAttr")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(
				name = "commodityAttrIds", 
				value = "商品属性ID[]; [1,2,3]", 
				paramType = "body", 
				dataTypeClass = String.class, 
				allowMultiple = true
			)
		}
	)
	//@formatter:on
	public Result delCommodityAttr(@RequestBody Long[] commodityAttrIds) {
		return Result.ok().put("rs", commodityAttrService.delCommodityAttr(commodityAttrIds));
	}

	/* ##################### 商品属性相关参数，sku ##################### */

	/**
	 * 查询指定商品属性id查询属性参数
	 */
	@RespTime("/commodityAttr/queryAttrParam")
	@ApiOperation(value = "commodityAttr-5 查询指定商品属性id查询属性参数")
	@GetMapping("/queryAttrParam/{attrId}")
	public Result queryAttrParamByAttrId(@PathVariable(name = "attrId") Long attrId) {
		return Result.ok().put("rs", commodityAttrService.queryAttrParamByAttrId(attrId));
	}

	/**
	 * 查询指定商品属性id查询SKU
	 */
	@RespTime("/commodityAttr/queryAttrSku")
	@ApiOperation(value = "commodityAttr-6 查询指定商品属性id查询SKU")
	@GetMapping("/queryAttrSku/{attrId}")
	public Result queryAttrSkuByAttrId(@PathVariable(name = "attrId") Long attrId) {
		return Result.ok().put("rs", commodityAttrService.queryAttrSkuByAttrId(attrId));
	}

	/**
	 * 修改商品属性参数
	 */
	@RespTime("/commodityAttr/updCommodityAttrParam")
	@ApiOperation(value = "commodityAttr-7  修改商品属性参数")
	@PutMapping("/updCommodityAttrParam")
	public Result updCommodityAttrParam(@RequestBody CommodityParamEntity commodityAttrParam) {
		return Result.ok().put("rs", commodityAttrService.updCommodityAttrParam(commodityAttrParam));
	}

	/**
	 * 修改商品属性SKU
	 */
	@RespTime("/commodityAttr/updCommodityAttrSku")
	@ApiOperation(value = "commodityAttr-8  修改商品属性Sku")
	@PutMapping("/updCommodityAttrSku")
	public Result updCommodityAttrSku(@RequestBody CommoditySkuEntity commodityAttrSku) {
		return Result.ok().put("rs", commodityAttrService.updCommodityAttrSku(commodityAttrSku));
	}

	/**
	 * 新增商品属性参数
	 */
	@RespTime("/commodityAttr/saveCommodityAttrParam")
	@ApiOperation(value = "commodityAttr-9 新增商品属性参数")
	@PostMapping("/saveCommodityAttrParam")
	public Result saveCommodityAttrParam(@RequestBody CommodityParamEntity commodityAttrParam) {
		return Result.ok().put("rs", commodityAttrService.saveCommodityAttrParam(commodityAttrParam));
	}

	/**
	 * 新增商品属性sku
	 */
	@RespTime("/commodityAttr/saveCommodityAttrSku")
	@ApiOperation(value = "commodityAttr-10 新增商品属性SKU")
	@PostMapping("/saveCommodityAttrSku")
	public Result saveCommodityAttrSku(@RequestBody CommoditySkuEntity commodityAttrSku) {
		return Result.ok().put("rs", commodityAttrService.saveCommodityAttrSku(commodityAttrSku));
	}

	/**
	 * 删除商品属性参数
	 */
	@RespTime("/commodityAttr/delCommodityAttrParam")
	@ApiOperation(value = "commodityAttr-11  删除商品属性参数(可批量)")
	@DeleteMapping("/delCommodityAttrParam")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(
				name = "paramIds", 
				value = "商品属性参数ID[]; [1,2,3]", 
				paramType = "body", 
				dataTypeClass = String.class, 
				allowMultiple = true
			)
		}
	)
	//@formatter:on
	public Result delCommodityAttrParam(@RequestBody Long[] paramIds) {
		return Result.ok().put("rs", commodityAttrService.delCommodityAttrParam(paramIds));
	}

	/**
	 * 删除商品属性SKU
	 */
	@RespTime("/commodityAttr/delCommodityAttrSku")
	@ApiOperation(value = "commodityAttr-12  删除商品属性SKU(可批量)")
	@DeleteMapping("/delCommodityAttrSku")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(
				name = "skuIds", 
				value = "商品属性参数ID[]; [1,2,3]", 
				paramType = "body", 
				dataTypeClass = String.class, 
				allowMultiple = true
			)
		}
	)
	//@formatter:on
	public Result delCommodityAttrSku(@RequestBody Long[] skuIds) {
		return Result.ok().put("rs", commodityAttrService.delCommodityAttrSku(skuIds));
	}

}
