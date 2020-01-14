package com.zlzc.api.rest.commodity.controller;

import com.zlzc.api.rest.commodity.entity.CommodityCategoryEntity;
import com.zlzc.api.rest.commodity.service.CommodityCategoryService;
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
@Api(value = "App-商品-分类", tags = { "V1.0 appCommodityCategory：app-商品分类操作相关接口" })
@RestController
@RequestMapping("App/commodityCategory")
public class CommodityCategoryController {
	@Autowired
	private CommodityCategoryService commodityCategoryService;

	/**
	 * 商品分类列表
	 */
	@ApiResponses(value = {
			@ApiResponse(response = CommodityCategoryEntity.class, code = 200, message = "商品分类列表响应字段说明")
	})
	//@RespTime("/queryList")
	@ApiOperation(value = "appCommodityCategory-1 获取商品分类列表(一级分类)")
	@PostMapping("/queryList")
	//@formatter:off
		@ApiImplicitParams(
			value = {
				@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
				@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
			}
		)
	//@formatter:on
	public Result commodityCategoryList(@ApiParam(hidden = true) @RequestParam Map<String, Object> params,
			@RequestBody CommodityCategoryEntity commodityCategory) {
		PageUtils page = commodityCategoryService.commodityCategoryList(params, commodityCategory);
		return Result.ok().put("page", page);
	}

	/**
	 * 查询指定分类的子集列表
	 */
	@ApiResponses(value = {
			@ApiResponse(response = CommodityCategoryEntity.class, code = 200, message = "指定分类的下级商品分类列表响应字段说明")
	})
	//@RespTime("/querySubList")
	@ApiOperation(value = "appCommodityCategory-2 获取指定分类的下级商品分类列表")
	@GetMapping("/querySubList")
	//@formatter:off
		@ApiImplicitParams(
			value = {
				@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
				@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query"),
				@ApiImplicitParam(name = "commodityCategoryId", value = "商品分类ID", defaultValue = "1", paramType = "query")
			}
		)
	//@formatter:on
	public Result querySubCommodityCategory(@ApiParam(hidden = true) @RequestParam Map<String, Object> params,
			@ApiParam(hidden = true) @RequestParam Long commodityCategoryId) {
		PageUtils page = commodityCategoryService.querySubCommodityCategory(params, commodityCategoryId);
		return Result.ok().put("page", page);
	}
}
