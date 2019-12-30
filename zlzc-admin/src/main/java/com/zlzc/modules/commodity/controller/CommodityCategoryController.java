package com.zlzc.modules.commodity.controller;

import com.zlzc.common.annotation.RespTime;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.commodity.entity.CommodityCategoryEntity;
import com.zlzc.modules.commodity.service.CommodityCategoryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Api(value = "后台-商品-分类", tags = { "V1.0 commodityCategory：后台-商品分类操作相关接口" })
@RestController
@RequestMapping("commodityCategory")
public class CommodityCategoryController {
	@Autowired
	private CommodityCategoryService commodityCategoryService;

	/**
	 * 商品分类列表
	 */
	@ApiResponses(value = {
			@ApiResponse(response = CommodityCategoryEntity.class, code = 200, message = "商品分类列表响应字段说明")
	})
	@RespTime("/queryList")
	@ApiOperation(value = "commodityCategory-1 获取商品分类列表(一级分类)")
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
	@RespTime("/querySubList")
	@ApiOperation(value = "commodityCategory-2 获取指定分类的下级商品分类列表")
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

	/**
	 * 新增商品分类
	 */
	@RespTime("/saveCommodityCategory")
	@ApiOperation(value = "commodityCategory-3 新增商品分类")
	@PostMapping("/saveCommodityCategory")
	public Result saveCommodityCategory(@RequestBody CommodityCategoryEntity commodityCategory) {
		return Result.ok().put("rs", commodityCategoryService.saveCommodityCategory(commodityCategory));
	}

	/**
	 * 修改商品分类
	 */
	@RespTime("/updCommodityCategory")
	@ApiOperation(value = "commodityCategory-4 修改商品分类")
	@PutMapping("/updCommodityCategory")
	public Result updCommodityCategory(@RequestBody CommodityCategoryEntity commodityCategory) {
		return Result.ok().put("rs", commodityCategoryService.updCommodityCategory(commodityCategory));
	}

	/**
	 * 删除商品分类
	 */
	@RespTime("/delCommodityCategory")
	@ApiOperation(value = "commodityCategory-5  删除商品分类")
	@DeleteMapping("/delCommodityCategory")
	//@formatter:off
		@ApiImplicitParams(
			value = {
				@ApiImplicitParam(
					name = "commodityCategoryIds", 
					value = "商品分类ID[]; [1,2,3]", 
					paramType = "body", 
					dataTypeClass = String.class, 
					allowMultiple = true
				)
			}
		)
		//@formatter:on
	public Result delCommodityCategory(@RequestBody Long[] commodityCategoryIds) {
		return Result.ok().put("rs", commodityCategoryService.delCommodityCategory(commodityCategoryIds));
	}

}
