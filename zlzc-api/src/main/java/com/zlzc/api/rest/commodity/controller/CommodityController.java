package com.zlzc.api.rest.commodity.controller;

import com.alibaba.fastjson.JSON;
import com.zlzc.api.rest.commodity.entity.*;
import com.zlzc.api.rest.commodity.service.CommodityService;
import com.zlzc.api.rest.commodity.vo.CommodityAlbumVo;
import com.zlzc.api.rest.commodity.vo.CommodityAttrVo;
import com.zlzc.api.rest.commodity.vo.CommoditySkuVo;
import com.zlzc.api.rest.commodity.vo.CommodityVo;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Api(value = "App-商品", tags = { "V1.0 appCommodity：App-商品操作相关接口" })
@RestController
@RequestMapping("App/commodity")
public class CommodityController {
	@Autowired
	private CommodityService commodityService;
	
	/**
	 * 将商品的分类转移至指定商品分类
	 */
	@ApiOperation(value = "appCommodity-6 将商品的分类转移至指定商品分类")
	//@RespTime("/commodity/transferCommodityByCommodityCategory")
	@PutMapping("/transferCommodityByCommodityCategory/{merchantId}/{fromCommodityCategoryId}/{fromCommodityCategoryId}")
	//@formatter:off
	public Result transferCommodityByCommodityCategory(
			@RequestParam(name = "merchantId", required = true) Long merchantId,
			@RequestParam(name = "fromCommodityCategoryId", required = true) Long fromCommodityCategoryId,
			@RequestParam(name = "toCommodityCategoryId", required = true) Long toCommodityCategoryId) {
	//@formatter:on
		boolean transferFlag = commodityService.transferCommodityByCommodityCategory(merchantId,
				fromCommodityCategoryId, toCommodityCategoryId);
		return Result.ok().put("rs", transferFlag);
	}

	/**
	 * 商品各状态数量统计
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "商品各状态数量统计响应字段说明") })
	@ApiOperation(value = "appCommodity-5 商品各状态数量统计")
	//@RespTime("/commodity/statisticsByStatus")
	@GetMapping("/statisticsByStatus")
	public Result commodityStatusStatistics(@RequestParam(name = "merchantId", required = false) Long merchantId,
			@RequestParam(name = "shopId", required = false) Long shopId) {
		return Result.ok().put("rs", commodityService.commodityStatusStatistics(merchantId, shopId));
	}
	/**
	 * 商品列表
	 */
	//@formatter:off
	@ApiResponses(value = {
		@ApiResponse(response = CommodityVo.class, code = 200, message = "商品列表响应字段说明")
	})
	//@formatter:on
	//@RespTime("/commodity/queryList")
	@ApiOperation(value = "appCommodity-3 获取商品列表")
	@GetMapping("/queryList")
	public Result queryList(@RequestParam(required = false) String name) {
		List<CommodityVo> commodityList = commodityService.queryCommodity();
		return Result.ok().put("rs", commodityList);
	}

	/**
	 * 获取商品列表（可分页）
	 */
	//@formatter:off
	@ApiResponses(value = {
		@ApiResponse(response =CommodityEntity.class, code = 200, message = "获取商品列表（可分页）响应字段说明")
	})
	//@formatter:on
	@ApiOperation(value = "appCommodity-1 获取商品列表（可分页）")
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
}
