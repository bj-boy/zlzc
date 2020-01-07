package com.zlzc.modules.commodity.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.zlzc.common.config.swagger.ApiJsonObject;
import com.zlzc.common.config.swagger.ApiJsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zlzc.common.annotation.RespTime;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.commodity.entity.CommodityCategoryEntity;
import com.zlzc.modules.commodity.entity.CommodityDetailEntity;
import com.zlzc.modules.commodity.entity.CommodityParamEntity;
import com.zlzc.modules.commodity.entity.CommodityPicEntity;
import com.zlzc.modules.commodity.entity.CommodityPriceEntity;
import com.zlzc.modules.commodity.entity.CommodityRepoEntity;
import com.zlzc.modules.commodity.service.CommodityService;
import com.zlzc.modules.commodity.vo.CommodityAlbumVo;
import com.zlzc.modules.commodity.vo.CommodityAttrVo;
import com.zlzc.modules.commodity.vo.CommoditySkuVo;
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

	@RespTime("/commodity/queryList")
	@ApiOperation(value = "merchant-3 获取商品列表")
	@GetMapping("/queryList")
	public Result queryList(@RequestParam(required = false) String name) {
		List<CommodityVo> commodityList = commodityService.queryCommodity();
		return Result.ok().put("rs", commodityList);
	}
	
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
	@RespTime("/commodity/save")
	@ApiOperation(value = "merchant-2 添加商品")
	@PostMapping("/save")
	public Result save(@RequestBody CommodityVo comm) {
		//@formatter:off
		CommodityVo commodity = new CommodityVo();
		commodity
			.setMerchantId(7L)
			.setShopId(2L)
			.setCommodityName("商品01")
			.setCommoditySubName("商品01-sub-title")
			.setCommodityNo(12121L)
			.setCommodityOrder(1)
			.setCommodityRemark("商品01remark")
			.setCommodityStatus(1)
			.setCountryCode("中国")
			.setCreateTime(new Date())
			.setUpdateTime(new Date())
			.setOperator("admin");
		
		// 绑定分类
		commodity.setCommodityCategory(new CommodityCategoryEntity()
				.setCategoryName("分类01")
				.setCategoryIcon("分类icon01")
				.setCategoryNo(223311L)
				.setCategoryOrder(1)
				.setCategoryDesc("分类01-desc")
				.setCreateTime(new Date())
				.setUpdateTime(new Date())
				.setOperator("admin"));
		
		// 绑定商品详情
		commodity.setCommodityDetails(new ArrayList<CommodityDetailEntity>(){{
			add(new CommodityDetailEntity()
					.setCountryCode("中国")
					.setDetailType(1)
					.setDetailUrl("www.zlzc.com/commodity_details.html")
					.setCreateTime(new Date())
					.setUpdateTime(new Date())
					.setOperator("admin")
			);
			add(new CommodityDetailEntity()
					.setCountryCode("美国")
					.setDetailType(1)
					.setDetailUrl("www.zlzc.com/commodity_details.html")
					.setCreateTime(new Date())
					.setUpdateTime(new Date())
					.setOperator("admin")
					);
		}});
		
		// 绑定商品库存
		commodity.setCommodityRepo(new CommodityRepoEntity()
					.setRepoStock(1000)
					.setRepoPrewarning(100)
					.setRepoUnit("个")
					.setCreateTime(new Date())
					.setUpdateTime(new Date())
					.setOperator("admin"));
		
		// 绑定商品价格
		commodity.setCommodityPrices(new ArrayList<CommodityPriceEntity>(){{
			add(new CommodityPriceEntity()
					.setCountryCode("中国")
					.setPrice(new BigDecimal(99.99))
					.setPriceUnit("元")
					.setSalesModel(1)
					.setSalesRule("=1")
					.setCreateTime(new Date())
					.setUpdateTime(new Date())
					.setOperator("admin"));
			add(new CommodityPriceEntity()
					.setCountryCode("中国")
					.setPrice(new BigDecimal(88.88))
					.setPriceUnit("元")
					.setSalesModel(2)
					.setSalesRule("≥100")
					.setCreateTime(new Date())
					.setUpdateTime(new Date())
					.setOperator("admin"));
			add(new CommodityPriceEntity()
					.setCountryCode("美国")
					.setPrice(new BigDecimal(22.22))
					.setPriceUnit("美元")
					.setSalesModel(2)
					.setSalesRule("≥100")
					.setCreateTime(new Date())
					.setUpdateTime(new Date())
					.setOperator("admin"));
		}});
		
		// 绑定商品相册
		commodity.setCommodityAlbumVo((CommodityAlbumVo) new CommodityAlbumVo()
				.setCommodityPics(new ArrayList<CommodityPicEntity>(){{
					add(new CommodityPicEntity()
							.setPicName("商品相册图片01")
							.setPicUrl("www.zlzc.com/commodity_album_pic.html")
							.setPicDesc("商品相册图片01-desc")
							.setCreateTime(new Date())
							.setUpdateTime(new Date())
							.setOperator("admin"));
					add(new CommodityPicEntity()
							.setPicName("商品相册图片02")
							.setPicUrl("www.zlzc.com/commodity_album_pic.html")
							.setPicDesc("商品相册图片02-desc")
							.setCreateTime(new Date())
							.setUpdateTime(new Date())
							.setOperator("admin"));
				}})
				.setAlbumName("商品相册01")
				.setAlbumNo(123123L)
				.setAlbumCoverUrl("www.zlzc.com/commodity_album.html")
				.setAlbumDesc("商品相册01-desc")
				.setMerchantId(7L)
				.setShopId(2L)
				.setCreateTime(new Date())
				.setUpdateTime(new Date())
				.setOperator("admin")
		);
		
		// 绑定商品属性
		commodity.setCommodityAttrVo((CommodityAttrVo) new CommodityAttrVo()
				.setCommodityParams(new ArrayList<CommodityParamEntity>(){{
					add(new CommodityParamEntity()
							.setCountryCode("中国")
							.setParamName("商品01-属性01-参数01")
							.setParamVals("val1,val2,val3")
							.setParamOrder(1)
							.setCreateTime(new Date())
							.setUpdateTime(new Date())
							.setOperator("admin"));
					add(new CommodityParamEntity()
							.setCountryCode("美国")
							.setParamName("商品01-属性01-参数02")
							.setParamVals("val1,val2,val3")
							.setParamOrder(2)
							.setCreateTime(new Date())
							.setUpdateTime(new Date())
							.setOperator("admin"));
				}})
				.setCommoditySkuVos(new ArrayList<CommoditySkuVo>(){{
					add((CommoditySkuVo) new CommoditySkuVo()
							.setCommodityRepoSku(
								new CommodityRepoEntity()
									.setRepoStock(200)
									.setRepoPrewarning(20)
									.setRepoUnit("个")
									.setCreateTime(new Date())
									.setUpdateTime(new Date())
									.setOperator("admin")
							)
							.setCommodityAlbumVoSku(
								(CommodityAlbumVo) new CommodityAlbumVo()
									.setCommodityPics(new ArrayList<CommodityPicEntity>(){{
										add(new CommodityPicEntity()
												.setPicName("sku相册01图片01")
												.setPicUrl("www.zlzc.com/commodity_album_sku_pic.html")
												.setPicDesc("sku相册01图片01-desc")
												.setCreateTime(new Date())
												.setUpdateTime(new Date())
												.setOperator("admin"));
										add(new CommodityPicEntity()
												.setPicName("sku相册01图片02")
												.setPicUrl("www.zlzc.com/commodity_album_sku_pic.html")
												.setPicDesc("sku相册01图片02-desc")
												.setCreateTime(new Date())
												.setUpdateTime(new Date())
												.setOperator("admin"));
									}})
									.setAlbumName("sku相册01")
									.setAlbumNo(31313L)
									.setAlbumCoverUrl("www.zlzc.com/commodity_album_sku.html")
									.setAlbumDesc("sku相册01-desc")
									.setMerchantId(7L)
									.setShopId(2L)
									.setCreateTime(new Date())
									.setUpdateTime(new Date())
									.setOperator("admin")
							)
							.setCommodityPricesSku(
								new ArrayList<CommodityPriceEntity>(){{
									add(new CommodityPriceEntity()
											.setCountryCode("中国")
											.setPrice(new BigDecimal(99.99))
											.setPriceUnit("元")
											.setSalesModel(1)
											.setSalesRule("=1")
											.setCreateTime(new Date())
											.setUpdateTime(new Date())
											.setOperator("admin"));
									add(new CommodityPriceEntity()
											.setCountryCode("中国")
											.setPrice(new BigDecimal(88.88))
											.setPriceUnit("元")
											.setSalesModel(2)
											.setSalesRule("≥100")
											.setCreateTime(new Date())
											.setUpdateTime(new Date())
											.setOperator("admin"));
									add(new CommodityPriceEntity()
											.setCountryCode("美国")
											.setPrice(new BigDecimal(22.22))
											.setPriceUnit("美元")
											.setSalesModel(2)
											.setSalesRule("≥100")
											.setCreateTime(new Date())
											.setUpdateTime(new Date())
											.setOperator("admin"));
								}}
							)
							.setCountryCode("中国")
							.setSkuName("商品01-属性01-sku01")
							.setSkuVals("v1,v2,v3")
							.setSkuNo(100001L)
							.setSkuOrder(1)
							.setCreateTime(new Date())
							.setUpdateTime(new Date())
							.setOperator("admin"));
					
					add((CommoditySkuVo) new CommoditySkuVo()
							.setCommodityRepoSku(
								new CommodityRepoEntity()
									.setRepoStock(100)
									.setRepoPrewarning(10)
									.setRepoUnit("个")
									.setCreateTime(new Date())
									.setUpdateTime(new Date())
									.setOperator("admin")
							)
							.setCommodityAlbumVoSku(
								(CommodityAlbumVo) new CommodityAlbumVo()
									.setCommodityPics(new ArrayList<CommodityPicEntity>(){{
										add(new CommodityPicEntity()
												.setPicName("sku相册02图片01")
												.setPicUrl("www.zlzc.com/commodity_album_sku_pic.html")
												.setPicDesc("sku相册02图片01-desc")
												.setCreateTime(new Date())
												.setUpdateTime(new Date())
												.setOperator("admin"));
										add(new CommodityPicEntity()
												.setPicName("sku相册02图片02")
												.setPicUrl("www.zlzc.com/commodity_album_sku_pic.html")
												.setPicDesc("sku相册02图片02-desc")
												.setCreateTime(new Date())
												.setUpdateTime(new Date())
												.setOperator("admin"));
									}})
									.setAlbumName("sku相册02")
									.setAlbumNo(31314L)
									.setAlbumCoverUrl("www.zlzc.com/commodity_album_sku.html")
									.setAlbumDesc("sku相册02-desc")
									.setMerchantId(7L)
									.setShopId(2L)
									.setCreateTime(new Date())
									.setUpdateTime(new Date())
									.setOperator("admin")
							)
							.setCommodityPricesSku(
								new ArrayList<CommodityPriceEntity>(){{
									add(new CommodityPriceEntity()
											.setCountryCode("中国")
											.setPrice(new BigDecimal(99.99))
											.setPriceUnit("元")
											.setSalesModel(1)
											.setSalesRule("=1")
											.setCreateTime(new Date())
											.setUpdateTime(new Date())
											.setOperator("admin"));
									add(new CommodityPriceEntity()
											.setCountryCode("中国")
											.setPrice(new BigDecimal(88.88))
											.setPriceUnit("元")
											.setSalesModel(2)
											.setSalesRule("≥100")
											.setCreateTime(new Date())
											.setUpdateTime(new Date())
											.setOperator("admin"));
									add(new CommodityPriceEntity()
											.setCountryCode("美国")
											.setPrice(new BigDecimal(22.22))
											.setPriceUnit("美元")
											.setSalesModel(2)
											.setSalesRule("≥100")
											.setCreateTime(new Date())
											.setUpdateTime(new Date())
											.setOperator("admin"));
								}}
							)
							.setCountryCode("中国")
							.setSkuName("商品01-属性01-sku02")
							.setSkuVals("v1,v2,v3")
							.setSkuNo(100002L)
							.setSkuOrder(2)
							.setCreateTime(new Date())
							.setUpdateTime(new Date())
							.setOperator("admin"));
				}})
				.setAttrName("商品属性01")
				.setAttrNo(123456L)
				.setMerchantId(7L)
				.setShopId(2L)
				.setCreateTime(new Date())
				.setUpdateTime(new Date())
				.setOperator("admin")
		);
		
		System.out.println(JSON.toJSONString(commodity));
		
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
