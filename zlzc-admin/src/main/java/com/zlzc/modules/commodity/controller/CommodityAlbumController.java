package com.zlzc.modules.commodity.controller;

import com.zlzc.common.annotation.RespTime;
import com.zlzc.common.utils.FileUpload;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.commodity.entity.CommodityAlbumEntity;
import com.zlzc.modules.commodity.entity.CommodityPicEntity;
import com.zlzc.modules.commodity.service.CommodityAlbumService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Api(value = "后台-商品-相册", tags = { "V1.0 commodityAlbum：后台-商品属性相册操作相关接口" })
@RestController
@RequestMapping("commodityAlbum")
public class CommodityAlbumController {
	/* ################# method ################# */

	@Autowired
	private CommodityAlbumService commodityAlbumService;

	/**
	 * 上传图片到指定相册(可批量)
	 * 
	 * 注：（商品模块缺少图片上传功能）
	 */
	//@formatter:off
	@SuppressWarnings("serial")
	@RespTime("/commodityAlbum/uploadPic")
	@ApiOperation(value = "commodityAlbum-8 上传图片到指定相册(可批量)")
	@PostMapping("/uploadPic")
	public Result uploadPic(
		@ApiParam(value = "文件") @RequestParam(value = "files") MultipartFile[] files,
		@ApiParam(value = "相册id", defaultValue = "1") @RequestParam(value = "albumId") Long albumId, 
		@ApiParam(value = "商户id", defaultValue = "7") @RequestParam(value = "merchantId") Long merchantId,
		Model model, 
		HttpServletRequest request) {
	//@formatter:off
		// 上传图片
		Pair<List<File>, List<MultipartFile>> rs = FileUpload.webFileUploader(files, FileUpload.UP_PATH + merchantId + "/" + albumId);
		if(rs == null) {
			return Result.ok().put("rs", false);
		}
		// 保存图片到相册
		Pair<List<String>, List<String>> saveRs = commodityAlbumService.savePics(albumId, merchantId, rs);
		return Result.ok().put("rs", new HashMap<String, List<String>>() {{
			put("success", saveRs.getFirst());
			put("failure", saveRs.getSecond());
		}});
	}

	/**
	 * 删除图片
	 */
	@RespTime("/commodityAlbum/delCommodityPic")
	@ApiOperation(value = "commodityAlbum-7  删除图片(可批量)")
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
	@ApiOperation(value = "commodityAlbum-6 转移图片到指定相册")
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
	@ApiResponses(value = {
			@ApiResponse(response = CommodityPicEntity.class, code = 200, message = "获取指定相册的图片列表(可分页)响应字段说明")
	})
	@GetMapping("/queryPicList")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query"),
			@ApiImplicitParam(name = "albumId", value = "相册ID", defaultValue = "1", paramType = "query")
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
	@ApiOperation(value = "commodityAlbum-4  删除相册(可批量)")
	@DeleteMapping("/delCommodity  Album")
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
	@ApiResponses(value = {
			@ApiResponse(response = CommodityAlbumEntity.class, code = 200, message = "获取商品相册列表(分页 + 条件查询)响应字段说明")
	})
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
