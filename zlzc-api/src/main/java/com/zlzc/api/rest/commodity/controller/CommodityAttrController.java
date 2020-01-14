package com.zlzc.api.rest.commodity.controller;

import com.zlzc.api.rest.commodity.entity.CommodityAttrEntity;
import com.zlzc.api.rest.commodity.entity.CommodityParamEntity;
import com.zlzc.api.rest.commodity.entity.CommoditySkuEntity;
import com.zlzc.api.rest.commodity.service.CommodityAttrService;
import com.zlzc.api.rest.commodity.vo.CommodityAttrPageVo;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Api(value = "App-商品-属性", tags = { "V1.0 appCommodityAttribute：App-商品属性操作相关接口" })
@RestController
@RequestMapping("App/commodityAttr")
public class CommodityAttrController {

	@Autowired
	private CommodityAttrService commodityAttrService;

	/**
	 * 商品属性列表
	 */
	@ApiResponses(value = {
			@ApiResponse(response = CommodityAttrPageVo.class, code = 200, message = "商品属性列表响应字段说明")
	})
	//@RespTime("/commodityAttr/queryList")
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

	//@formatter:on
	public Result delCommodityAttr(@RequestBody Long[] commodityAttrIds) {
		return Result.ok().put("rs", commodityAttrService.delCommodityAttr(commodityAttrIds));
	}

	/* ##################### 商品属性相关参数，sku ##################### */

	/**
	 * 查询指定商品属性id查询属性参数
	 */
	@ApiResponses(value = {
			@ApiResponse(response = CommodityParamEntity.class, code = 200, message = "指定商品属性id查询属性参数响应字段说明")
	})
	//@RespTime("/commodityAttr/queryAttrParam")
	@ApiOperation(value = "commodityAttr-5 查询指定商品属性id查询属性参数")
	@GetMapping("/queryAttrParam/{attrId}")
	public Result queryAttrParamByAttrId(@PathVariable(name = "attrId") Long attrId) {
		return Result.ok().put("rs", commodityAttrService.queryAttrParamByAttrId(attrId));
	}
	/**
	 * 查询指定商品属性id查询SKU
	 */
	@ApiResponses(value = {
			@ApiResponse(response = CommoditySkuEntity.class, code = 200, message = "指定商品属性id查询SKU响应字段说明")
	})
	//@RespTime("/commodityAttr/queryAttrSku")
	@ApiOperation(value = "commodityAttr-6 查询指定商品属性id查询SKU")
	@GetMapping("/queryAttrSku/{attrId}")
	public Result queryAttrSkuByAttrId(@PathVariable(name = "attrId") Long attrId) {
		return Result.ok().put("rs", commodityAttrService.queryAttrSkuByAttrId(attrId));
	}
}
