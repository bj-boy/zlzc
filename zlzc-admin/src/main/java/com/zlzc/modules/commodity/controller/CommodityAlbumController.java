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
import com.zlzc.modules.commodity.entity.CommodityAlbumEntity;
import com.zlzc.modules.commodity.service.CommodityAlbumService;

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
@Api(value = "后台-商品-相册", tags = { "V1.0 commodityAlbum：后台-商品属性相册操作相关接口" })
@RestController
@RequestMapping("commodityAlbum")
public class CommodityAlbumController {

	// 上传图片到指定相册(可批量)

	// 纯上传图片(可批量)

	/* ################# method ################# */

	@Autowired
	private CommodityAlbumService commodityAlbumService;

	/**
	 * 删除图片
	 */
	@RespTime("/commodityAlbum/delCommodityPic")
	@ApiOperation(value = "commodityAttr-7  删除图片(可批量)")
	@DeleteMapping("/delCommodityPic")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(
				name = "commodityPicIds", 
				value = "图片ID[]; [1,2,3]", 
				paramType = "body", 
				dataTypeClass = String.class, 
				allowMultiple = true
			)
		}
	)
	//@formatter:on
	public Result delCommodityPic(@RequestBody Long[] commodityPicIds) {
		return Result.ok().put("rs", commodityAlbumService.delPics(commodityPicIds));
	}
	
	/**
	 * 转移指定图片到指定相册
	 */
	@RespTime("/commodityAlbum/transferPic")
	@ApiOperation(value = "transferPic-6 转移图片到指定相册")
	@PostMapping("/transferPic/{picId}/{fromAlbumId}/{toAlbumId}")
	//@formatter:off
	public Result transferPic(
			@ApiParam(value = "图片id", defaultValue = "1") @PathVariable(required = true) Long picId, 
			@ApiParam(value = "当前相册id", defaultValue = "1") @PathVariable(required = true) Long fromAlbumId, 
			@ApiParam(value = "目标相册id", defaultValue = "2") @PathVariable(required = true)Long toAlbumId) {
	//@formatter:on
		return Result.ok().put("rs", commodityAlbumService.transferPic(picId, fromAlbumId, toAlbumId));
	}

	/**
	 * 获取指定相册的图片列表(可分页)
	 */
	@RespTime("/commodityAlbum/queryPicList")
	@ApiOperation(value = "commodityAlbum-5  获取指定相册的图片列表(可分页)")
	@GetMapping("/queryPicList")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query"),
			@ApiImplicitParam(name = "albumName", value = "相册ID", defaultValue = "1", paramType = "query")
		} 
	)
	//@formatter:on
	public Result queryPicList(@ApiParam(hidden = true) @RequestParam Map<String, Object> params,
			@ApiParam(hidden = true) @RequestParam(required = true) Long albumId) {
		PageUtils page = commodityAlbumService.queryPicList(params, albumId);
		return Result.ok().put("page", page);
	}

	/**
	 * 删除相册
	 */
	@RespTime("/commodityAlbum/delCommodityAlbum")
	@ApiOperation(value = "commodityAttr-4  删除相册(可批量)")
	@DeleteMapping("/delCommodityAlbum")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(
				name = "commodityAlbumIds", 
				value = "相册ID[]; [1,2,3]", 
				paramType = "body", 
				dataTypeClass = String.class, 
				allowMultiple = true
			)
		}
	)
	//@formatter:on
	public Result delCommodityAlbum(@RequestBody Long[] commodityAlbumIds) {
		return Result.ok().put("rs", commodityAlbumService.delAlbum(commodityAlbumIds));
	}
	
	/**
	 * 修改相册
	 */
	@RespTime("/commodityAlbum/updCommodityAlbum")
	@ApiOperation(value = "commodityAlbum-3 修改相册")
	@PutMapping("/updCommodityAlbum")
	public Result updCommodityAlbum(@RequestBody CommodityAlbumEntity album) {
		return Result.ok().put("rs", commodityAlbumService.updAlbum(album));
	}

	/**
	 * 新建相册
	 */
	@RespTime("/commodityAlbum/saveCommodityAlbum")
	@ApiOperation(value = "commodityAlbum-2 添加相册")
	@PostMapping("/saveCommodityAlbum")
	public Result saveCommodityAlbum(@RequestBody CommodityAlbumEntity album) {
		return Result.ok().put("rs", commodityAlbumService.saveAlbum(album));
	}

	/**
	 * 商户或店铺相册列表(可分页 + 根据相册名称进行条件查询)
	 */
	@RespTime("/commodityAlbum/queryList")
	@ApiOperation(value = "commodityAlbum-1  获取商品相册列表(分页 + 条件查询)")
	@GetMapping("/queryList")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query"),
			@ApiImplicitParam(name = "merchantId", value = "商户ID", defaultValue = "7", paramType = "query"),
			@ApiImplicitParam(name = "shopId", value = "店铺ID", defaultValue = "2", paramType = "query"),
			@ApiImplicitParam(name = "albumName", value = "相册名称", defaultValue = "相册1", paramType = "query")
		}
	)
	//@formatter:on
	public Result queryList(@ApiParam(hidden = true) @RequestParam Map<String, Object> params,
			@ApiParam(hidden = true) @RequestParam(required = false) Long merchantId,
			@ApiParam(hidden = true) @RequestParam(required = false) Long shopId,
			@ApiParam(hidden = true) @RequestParam(required = false) String albumName) {
		PageUtils page = commodityAlbumService.queryList(params, merchantId, shopId, albumName);
		return Result.ok().put("page", page);
	}

}
