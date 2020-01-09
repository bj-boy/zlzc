package com.zlzc.api.rest.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.commodity.dao.CommodityDao;
import com.zlzc.api.rest.commodity.entity.*;
import com.zlzc.api.rest.commodity.service.*;
import com.zlzc.api.rest.commodity.vo.CommodityAlbumVo;
import com.zlzc.api.rest.commodity.vo.CommodityAttrVo;
import com.zlzc.api.rest.commodity.vo.CommoditySkuVo;
import com.zlzc.api.rest.commodity.vo.CommodityVo;
import com.zlzc.common.exception.ZException;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service("commodityService")
public class CommodityServiceImpl extends ServiceImpl<CommodityDao, CommodityEntity> implements CommodityService {

	@Autowired
	private CommodityAttrService commodityAttrService;

	@Autowired
	private CommodityParamService commodityParamService;

	@Autowired
	private CommodityDetailService commodityDetailService;

	@Autowired
	private CommodityCategoryService commodityCategoryService;

	@Autowired
	private CommodityAlbumService commodityAlbumService;

	@Autowired
	private CommodityPriceService commodityPriceService;

	@Autowired
	private CommodityRepoService commodityRepoService;

	@Autowired
	private CommoditySkuService commoditySkuService;

	@Autowired
	private CommodityPicService commodityPicService;

	@Autowired
	private CommoditySkuMiddleService commoditySkuMiddleService;

	@Autowired
	private CommodityPriceMiddleService commodityPriceMiddleService;

	/**
	 * 商品审核
	 */

	public void commodityApproval() {

	}

	/**
	 * 商品审核列表(支持分页及条件)
	 */
	public void queryCommodityApprovalDetails() {

	}

	/* ##################### 商品相册及图片 ##################### */

	/**
	 * 相册列表(支持分页和查询)
	 */
	public void albumList() {

	}

	/**
	 * 新增相册
	 */
	public void saveAlbum(CommodityAlbumVo commodityAlbum) {

	}

	/**
	 * 修改相册
	 */
	public void updAlbum(CommodityAlbumVo commodityAlbum) {

	}

	/**
	 * 删除相册(支持批量)
	 */
	public void delAlbum(Long[] albumIds) {

	}

	/**
	 * 查询指定相册
	 */
	public void queryAlbumById(Long albumId) {

	}

	/**
	 * 上传图片(支持批量)
	 */
	public void uploadPics(List<CommodityPicEntity> pics) {

	}

	/**
	 * 删除图片(支持批量)
	 */
	public void delPics(Long[] picIds) {

	}

	/**
	 * 将图片转移到指定相册
	 */
	public void transferPic(Long fromAlbumId, Long toAlbumId) {

	}

	/* ##################### 商品 ##################### */

	/**
	 * 将商品的分类转移至指定商品分类
	 */
	@Transactional
	@Override
	public boolean transferCommodityByCommodityCategory(Long merchantId, Long fromCommodityCategoryId,
			Long toCommodityCategoryId) {
		UpdateWrapper<CommodityEntity> updateWrapper = new UpdateWrapper<CommodityEntity>()
				.set("commodity_category_id", toCommodityCategoryId)
				.eq("commodity_category_id", fromCommodityCategoryId).eq("merchant_id", merchantId);
		boolean updFlag = update(updateWrapper);
		return updFlag;
	}

	/**
	 * 商品各状态数量统计
	 */
	@Override
	public List<Map<String, Object>> commodityStatusStatistics(Long merchantId, Long shopId) {
		//@formatter:off
		QueryWrapper<CommodityEntity> qw = new QueryWrapper<CommodityEntity>()
				.select("commodity_status status", "count(commodity_id) cnt")
				.eq(Objects.nonNull(merchantId), "merchant_id", merchantId)
				.eq(Objects.nonNull(merchantId) && Objects.nonNull(shopId), "shop_id", shopId)
				.groupBy("commodity_status");
		//@formatter:on
		List<Map<String, Object>> rsList = listMaps(qw);
		System.out.println(rsList);

		return rsList;

	}

	/**
	 * 修改商品状态(上架/下架)
	 */
	@Transactional
	@Override
	public boolean updCommodityStatus(CommodityEntity commodity) {
		return this.updateById(new CommodityEntity().setCommodityId(commodity.getCommodityId())
				.setCommodityStatus(commodity.getCommodityStatus()));
	}

	/**
	 * 更新商品
	 */
	@Transactional
	@Override
	public boolean updCommodity(CommodityVo commodity) {
		// 判断传入需修改商品ID是否为null
		if (Objects.isNull(commodity.getCommodityId())) {
			throw new ZException("要修改的商品的商品ID不能为空");
		}
		// 更新商品表
		boolean commodityUpdFlag = updateById(commodity);
		// 更新商品详情表
		List<CommodityDetailEntity> commodityDetails = commodity.getCommodityDetails();
		boolean commodityDetailUpdFlag = true;
		for (CommodityDetailEntity detail : commodityDetails) {
			if (Objects.nonNull(detail.getDetailId())) {
				detail.setCommodityId(commodity.getCommodityId());
				commodityDetailUpdFlag = commodityDetailService.updateById(detail) && commodityDetailUpdFlag;
			}
		}
		// 更新商品库存表
		CommodityRepoEntity commodityRepo = commodity.getCommodityRepo();
		boolean commodityRepoUpdFlag = true;
		if (Objects.nonNull(commodityRepo) && Objects.nonNull(commodityRepo.getRepoId())) {
			commodityRepoUpdFlag = commodityRepoService.updateById(commodityRepo);
		}
		// 更新商品相册及图片表
		CommodityAlbumVo commodityAlbumVo = commodity.getCommodityAlbumVo();
		boolean commodityAlbumUpdFlag = true;
		boolean commodityPicUpdFlag = true;
		if (Objects.nonNull(commodityAlbumVo) && Objects.nonNull(commodityAlbumVo.getAlbumId())) {
			commodityAlbumUpdFlag = commodityAlbumService.updateById(commodityAlbumVo);
			List<CommodityPicEntity> commodityPics = commodityAlbumVo.getCommodityPics();
			if (commodityPics.size() > 0) {
				for (CommodityPicEntity commodityPic : commodityPics) {
					if (Objects.nonNull(commodityPic.getPicId())) {
						commodityPic.setAlbumId(commodityAlbumVo.getAlbumId());
						commodityPicUpdFlag = commodityPicService.updateById(commodityPic) && commodityPicUpdFlag;
					}
				}
			}
		}
		// 更新商品价格表（不涉及中间表）
		List<CommodityPriceEntity> commodityPrices = commodity.getCommodityPrices();
		boolean commodityPriceUpdFlag = true;
		for (CommodityPriceEntity commodityPrice : commodityPrices) {
			if (Objects.nonNull(commodityPrice.getPriceId())) {
				commodityPriceUpdFlag = commodityPriceService.updateById(commodityPrice) && commodityPriceUpdFlag;
			}
		}
		// 更新商品属性表
		CommodityAttrVo commodityAttrVo = commodity.getCommodityAttrVo();
		boolean commodityAttrUpdFlag = true;
		boolean commodityAttrParamUpdFlag = true;
		boolean commodityAttrSkuUpdFlag = true;
		boolean commodityRepoSkuUpdFlag = true;
		boolean commodityAlbumSkuUpdFlag = true;
		boolean commodityPicSkuUpdFlag = true;
		boolean commodityPriceSkuUpdFlag = true;
		if (Objects.nonNull(commodityAttrVo) && Objects.nonNull(commodityAttrVo.getAttrId())) {
			commodityAttrUpdFlag = commodityAttrService.updateById(commodityAttrVo);
			// 更新属性参数
			List<CommodityParamEntity> commodityParams = commodityAttrVo.getCommodityParams();
			for (CommodityParamEntity commodityParam : commodityParams) {
				if (Objects.nonNull(commodityParam) && Objects.nonNull(commodityParam.getParamId())) {
					commodityParam.setAttrId(commodityAttrVo.getAttrId());
					commodityAttrParamUpdFlag = commodityParamService.updateById(commodityParam)
							&& commodityAttrParamUpdFlag;
				}
			}
			// 更新是属性SKU
			List<CommoditySkuVo> commoditySkuVos = commodityAttrVo.getCommoditySkuVos();
			for (CommoditySkuVo commoditySkuVo : commoditySkuVos) {
				if (Objects.nonNull(commoditySkuVo) && Objects.nonNull(commoditySkuVo.getSkuId())) {
					commoditySkuVo.setAttrId(commodityAttrVo.getAttrId());
					commodityAttrSkuUpdFlag = commoditySkuService.updateById(commoditySkuVo) && commodityAttrSkuUpdFlag;
					// 更新sku库存
					CommodityRepoEntity commodityRepoSku = commoditySkuVo.getCommodityRepoSku();
					if (Objects.nonNull(commodityRepoSku) && Objects.nonNull(commodityRepoSku.getRepoId())) {
						commodityRepoSkuUpdFlag = commodityRepoService.updateById(commodityRepo);
					}
					// 更新sku相册
					CommodityAlbumVo commodityAlbumVoSku = commoditySkuVo.getCommodityAlbumVoSku();
					if (Objects.nonNull(commodityAlbumVoSku) && Objects.nonNull(commodityAlbumVoSku.getAlbumId())) {
						commodityAlbumSkuUpdFlag = commodityAlbumService.updateById(commodityAlbumVoSku);
						// 更新sku相册图片
						List<CommodityPicEntity> commodityPicsSku = commodityAlbumVoSku.getCommodityPics();
						for (CommodityPicEntity commodityPic : commodityPicsSku) {
							if (Objects.nonNull(commodityPic) && Objects.nonNull(commodityPic.getPicId())) {
								commodityPic.setAlbumId(commodityAlbumVoSku.getAlbumId());
								commodityPicSkuUpdFlag = commodityPicService.updateById(commodityPic)
										&& commodityPicSkuUpdFlag;
							}
						}
					}
					// 更新SKU价格
					List<CommodityPriceEntity> commodityPricesSku = commoditySkuVo.getCommodityPricesSku();
					for (CommodityPriceEntity commodityPrice : commodityPricesSku) {
						if (Objects.nonNull(commodityPrice) && Objects.nonNull(commodityPrice.getPriceId())) {
							commodityPriceSkuUpdFlag = commodityPriceService.updateById(commodityPrice)
									&& commodityPriceSkuUpdFlag;
						}
					}
				}
			}
		}
		//@formatter:off
		return commodityUpdFlag 
				&& commodityDetailUpdFlag 
				&& commodityRepoUpdFlag 
				&& commodityAlbumUpdFlag 
				&& commodityPicUpdFlag 
				&& commodityPriceUpdFlag 
				&& commodityAttrUpdFlag 
				&& commodityAttrParamUpdFlag 
				&& commodityAttrSkuUpdFlag 
				&& commodityRepoSkuUpdFlag 
				&& commodityAlbumSkuUpdFlag 
				&& commodityPicSkuUpdFlag 
				&& commodityPriceSkuUpdFlag;
		//@formatter:on
	}

	/**
	 * 删除商品(支持批量) 暂做逻辑删除
	 */
	@Transactional
	@Override
	public boolean delCommodities(Long[] commodityIds) {
		// 删除商品(逻辑删除)
		List<CommodityEntity> commodityList = new ArrayList<>();
		//@formatter:off
		Arrays.asList(commodityIds).forEach(commodityId -> 
			commodityList.add(new CommodityEntity()
					.setCommodityId(commodityId)
					.setDel(0))
			);
			
		return updateBatchById(commodityList);
	}

	/**
	 * 查询商品(支持分页及条件)
	 */
	@Override
	public List<CommodityVo> queryCommodity() {
		return baseMapper.queryCommodity();
	}

	/**
	 * 添加商品
	 */
	@SuppressWarnings({ "unused", "static-access", "unchecked" })
	@Transactional
	@Override
	public boolean saveCommodity(CommodityVo commodity) {
		// 商品插入(首次插入获取自增ID)
		boolean commodityFlag = save(commodity.setDel(1));
		// 分类插入
		Result categoryRs = tryInsertCommodityCategory(commodity);
		// 库存插入
		Result repoRs = tryInsertCommodityRepo(commodity);
		// 相册插入
		Result albumRs = tryInsertCommodityAlbum(commodity);
		// 属性插入
		Result attrRs = tryInsertCommodityAttr(commodity);
		// 商品详情插入
		Result detailsRs = tryInsertCommodityDetails(commodity);
		// 商品价格插入
		Result priceRs = tryInsertCommodityPrices(commodity);
		// 图片插入
		Result picsRs = new Result().ok().put("rs", false);
		List<CommodityPicEntity> picsCommodityAlbum = (List<CommodityPicEntity>) albumRs.get("extract");
		List<CommodityPicEntity> picsCommoditySkuAlbum = (List<CommodityPicEntity>) attrRs.get("extract");
		if (picsCommodityAlbum.size() > 0 || picsCommoditySkuAlbum.size() > 0) {
			picsCommodityAlbum.addAll(picsCommoditySkuAlbum);
			picsRs = tryInsertCommodityPic(picsCommodityAlbum);
		}
		// 更新商品信息
		commodityFlag = saveOrUpdate(commodity);
		// 获取插入结果
		boolean categoryRsFlag = (boolean) categoryRs.get("rs");
		boolean repoRsFlag = (boolean) repoRs.get("rs");
		boolean albumRsFlag = (boolean) albumRs.get("rs");
		boolean attrRsFlag = (boolean) attrRs.get("rs");
		boolean detailsRsFlag = (boolean) detailsRs.get("rs");
		boolean priceRsFlag = (boolean) priceRs.get("rs");
		boolean picsRsFlag = (boolean) picsRs.get("rs");
		if (!categoryRsFlag) {
			log.error("===========> 商品分类插入失败：" + commodity);
			throw new ZException("商品分类插入失败");
		}
		if (!repoRsFlag) {
			log.error("===========> 商品库存插入失败：" + commodity);
			throw new ZException("商品库存插入失败");
		}
		if (!albumRsFlag) {
			log.error("===========> 商品相册插入失败：" + commodity);
			throw new ZException("商品相册插入失败");
		}
		if (!attrRsFlag) {
			log.error("===========> 商品属性插入失败：" + commodity);
			throw new ZException("商品属性插入失败");
		}
		if (!detailsRsFlag) {
			log.error("===========> 商品详情插入失败：" + commodity);
			throw new ZException("商品详情插入失败");
		}
		if (!priceRsFlag) {
			log.error("===========> 商品价格插入失败：" + commodity);
			throw new ZException("商品价格插入失败");
		}
		if (!picsRsFlag) {
			log.error("===========> 商品图片插入失败：" + commodity);
			throw new ZException("商品图片插入失败");
		}
		//@formatter:off
		return categoryRsFlag 
			&& repoRsFlag 
			&& albumRsFlag 
			&& attrRsFlag 
			&& detailsRsFlag 
			&& priceRsFlag 
			&& picsRsFlag;
		//@formatter:on
	}

	/**
	 * 商品分类插入
	 */
	private Result tryInsertCommodityCategory(CommodityVo commodity) {
		boolean commodityCategoryFlag = false;
		/* 判断当前商品是否关联已有分类（eg：关联了已有分类会有分类id） */
		if (commodity.getCommodityCategoryId() == null && Objects.isNull(commodity.getCommodityCategory())) {
			throw new ZException("请选择或添加商品分类。");
		} else if (commodity.getCommodityCategoryId() == null) {
			// 插入商品分类
			commodityCategoryFlag = commodityCategoryService.save(commodity.getCommodityCategory());
			// 插入成功后将生成分类ID分配给商品
			commodity.setCommodityCategoryId(commodity.getCommodityCategory().getCategoryId());
		} else if (commodity.getCommodityCategoryId() != null) {
			commodityCategoryFlag = true;
		}
		return Result.ok().put("rs", commodityCategoryFlag);
	}

	/**
	 * 商品库存插入
	 */
	private Result tryInsertCommodityRepo(CommodityVo commodity) {
		boolean commodityRepoFlag = false;
		/* 判断当前商品是否填写库存信息（eg：库存不可选择，只能填写） */
		if (Objects.isNull(commodity.getCommodityRepo())) {
			throw new ZException("请添加商品库存相关信息。");
		} else {
			// 插入库存记录
			commodityRepoFlag = commodityRepoService.save(commodity.getCommodityRepo());
			// 插入成功后将生成属性ID分配给商品
			commodity.setCommodityRepoId(commodity.getCommodityRepo().getRepoId());
		}
		return Result.ok().put("rs", commodityRepoFlag);
	}

	/**
	 * 商品相册插入
	 */
	private Result tryInsertCommodityAlbum(CommodityVo commodity) {
		boolean commodityAlbumFlag = false;
		/* 判断当前商品是否关联已有相册信息（eg：关联了已有相册会有相册id） */
		if (commodity.getComodityAlbumId() == null && Objects.isNull(commodity.getCommodityAlbumVo())) {
			throw new ZException("请添加或选择商品相册。");
		} else if (commodity.getComodityAlbumId() == null) {
			// 插入相册记录
			commodityAlbumFlag = commodityAlbumService.save(commodity.getCommodityAlbumVo());
			// 插入成功后将生成相册ID分配给商品
			Long albumId = commodity.getCommodityAlbumVo().getAlbumId();
			commodity.setComodityAlbumId(albumId);
			// 插入相册中图片
			List<CommodityPicEntity> commodityPics = commodity.getCommodityAlbumVo().getCommodityPics();
			// 将相册ID分配给图片
			commodityPics.forEach(pic -> pic.setAlbumId(albumId));
			commodity.getCommodityAlbumVo().setCommodityPics(commodityPics);
		} else if (commodity.getComodityAlbumId() != null) {
			commodityAlbumFlag = true;
		}
		//@formatter:off
		return commodityAlbumFlag ?
				Result.ok()
					.put("rs", commodityAlbumFlag)
					.put("extract", commodity.getCommodityAlbumVo().getCommodityPics())
				:
				Result.ok()
					.put("rs", commodityAlbumFlag)
					.put("extract", null);
		//@formatter:on
	}

	/**
	 * 商品详情插入
	 */
	private Result tryInsertCommodityDetails(CommodityVo commodity) {
		boolean commodityDetailsFlag = false;
		// 判断是否有商品详情,有则添加
		if (commodity.getCommodityDetails().size() > 0) {
			List<CommodityDetailEntity> commodityDetails = commodity.getCommodityDetails();
			commodityDetails.forEach(detail -> detail.setCommodityId(commodity.getCommodityId()));
			commodityDetailsFlag = commodityDetailService.saveBatch(commodityDetails);
		} else {
			commodityDetailsFlag = true;
		}
		return Result.ok().put("rs", commodityDetailsFlag);
	}

	/**
	 * 商品价格插入
	 */
	private Result tryInsertCommodityPrices(CommodityVo commodity) {
		boolean commodityPriceFlag = false;
		boolean commodityPriceMiddleFlag = false;
		// 判断是否有价格,有则添加
		if (commodity.getCommodityPrices().size() > 0) {
			List<CommodityPriceEntity> commodityPrices = commodity.getCommodityPrices();
			List<CommodityPriceMiddleEntity> commodityPriceMiddleList = new ArrayList<>();
			// 插入价格表
			for (CommodityPriceEntity commodityPrice : commodityPrices) {
				if (!commodityPriceService.save(commodityPrice)) {
					throw new ZException("商品价格插入失败：" + commodityPrice);
				}
				//@formatter:off
				commodityPriceMiddleList.add(new CommodityPriceMiddleEntity()
						.setPriceId(commodityPrice.getPriceId())
						.setCommodityId(commodity.getCommodityId()));
				//@formatter:on
			}
			// 插入中间表
			commodityPriceMiddleFlag = commodityPriceMiddleService.saveBatch(commodityPriceMiddleList);
			commodityPriceFlag = commodityPriceMiddleFlag;
		}
		return Result.ok().put("rs", commodityPriceFlag && commodityPriceMiddleFlag);
	}

	/**
	 * 商品属性插入
	 */
	private Result tryInsertCommodityAttr(CommodityVo commodity) {
		boolean commodityAttrFlag = false;
		boolean commodityParamFlag = false;
		boolean commoditySkuAlbumFlag = false;
		boolean commoditySkuRepoFlag = false;
		boolean commoditySkuFlag = true;
		boolean commoditySkuPriceFlag = true;
		List<CommodityPicEntity> picsList = new ArrayList<>();
		/* 判断当前商品是否关联已有属性（eg：关联了已有属性会有属性id） */
		if (commodity.getCommodityAttrId() == null && Objects.isNull(commodity.getCommodityAttrVo())) {
			throw new ZException("请选择或添加商品属性。");
		} else if (commodity.getCommodityAttrId() == null && Objects.nonNull(commodity.getCommodityAttrVo())) {
			// 插入商品属性
			commodityAttrFlag = commodityAttrService.save(commodity.getCommodityAttrVo());
			// 插入成功后将生成属性ID分配给商品
			Long attrId = commodity.getCommodityAttrVo().getAttrId();
			commodity.setCommodityAttrId(attrId);
			/* 插入属性相关的SKU和参数 */
			// 插入属性相关参数
			List<CommodityParamEntity> commodityParams = commodity.getCommodityAttrVo().getCommodityParams();
			commodityParams.forEach(param -> param.setAttrId(attrId));
			commodityParamFlag = commodityParamService.saveBatch(commodityParams);

			// 插入SKU
			List<CommoditySkuVo> commoditySkuVos = commodity.getCommodityAttrVo().getCommoditySkuVos();
			for (CommoditySkuVo sku : commoditySkuVos) {
				// 将属性ID设置给SKU
				sku.setAttrId(attrId);
				// 保存当前SKU
				commoditySkuFlag = commoditySkuService.save(sku) && commoditySkuFlag;
				// 新增商品-SKU中间表对象并设置相关属性
				CommoditySkuMiddleEntity commoditySkuMiddle = new CommoditySkuMiddleEntity();
				//@formatter:off
				commoditySkuMiddle
					.setSkuId(sku.getSkuId())
					.setCommodityId(commodity.getCommodityId());
				//@formatter:on

				// 如果当前SKU没有相册ID或没有新增相册实体类则使用商品相册为默认值。
				if (sku.getAlbumId() == null && Objects.nonNull(sku.getCommodityAlbumVoSku())) {
					// 保存SKU对应的相册
					CommodityAlbumVo commoditySkuAlbumVo = sku.getCommodityAlbumVoSku();
					commoditySkuAlbumFlag = commodityAlbumService.save(commoditySkuAlbumVo);
					// 设置中间表相册ID
					commoditySkuMiddle.setAlbumId(commoditySkuAlbumVo.getAlbumId());
					// 为相册中图片设置相册ID
					commoditySkuAlbumVo.getCommodityPics()
							.forEach(pic -> pic.setAlbumId(commoditySkuAlbumVo.getAlbumId()));
					// 将图片赋给外部list统一批量插入
					picsList.addAll(commoditySkuAlbumVo.getCommodityPics());
				} else if (sku.getAlbumId() != null) {
					// 设置中间表相册ID
					commoditySkuMiddle.setAlbumId(sku.getAlbumId());
				}

				// 如果当前SKU没有新增库存实体类则使用商品库存为默认。(库存是填入，无法选择)
				if (Objects.nonNull(sku.getCommodityRepoSku())) {
					// 保存SKU对应的库存
					CommodityRepoEntity commoditySkuRepo = sku.getCommodityRepoSku();
					commoditySkuRepoFlag = commodityRepoService.save(commoditySkuRepo);
					// 设置中间表库存ID
					commoditySkuMiddle.setRepoId(commoditySkuRepo.getRepoId());
				}

				// SKU价格列表如果有价格相关实体则新增绑定，没有则使用默认
				if (sku.getCommodityPricesSku().size() > 0) {
					List<CommodityPriceEntity> commoditySkuPrices = sku.getCommodityPricesSku();
					for (CommodityPriceEntity price : commoditySkuPrices) {
						commoditySkuPriceFlag = commodityPriceService.save(price) && commoditySkuPriceFlag;
						// 设置中间表价格ID，并执行中间表插入，由于价格可能是多个，所以中间表可能是多条记录
						commoditySkuMiddle.setMiddleId(null);
						commoditySkuMiddle.setPriceId(price.getPriceId());
						commoditySkuMiddleService.save(commoditySkuMiddle);
					}
				}

			}
		} else if (commodity.getCommodityAttrId() != null) {
			// 有商品属性id的情况下需要维护商品和SKU的中间表关系
			if (Objects.isNull(commodity.getCommodityAttrVo())) {
				throw new ZException("需要传入商品属性【" + commodity.getCommodityAttrId() + "】 相关的属性信息。");
			}
			// 保存SKU的相册，库存，价格和商品之间的关系
			List<CommoditySkuVo> commoditySkuVos = commodity.getCommodityAttrVo().getCommoditySkuVos();
			for (CommoditySkuVo sku : commoditySkuVos) {
				// 新增商品-SKU中间表对象并设置相关属性
				CommoditySkuMiddleEntity commoditySkuMiddle = new CommoditySkuMiddleEntity();
				//@formatter:off
				commoditySkuMiddle
					.setSkuId(sku.getSkuId())
					.setCommodityId(commodity.getCommodityId());
				//@formatter:on
				// 如果当前SKU没有相册ID或没有新增相册实体类则使用商品相册为默认值。
				if (sku.getAlbumId() == null && Objects.nonNull(sku.getCommodityAlbumVoSku())) {
					// 保存SKU对应的相册
					CommodityAlbumVo commoditySkuAlbumVo = sku.getCommodityAlbumVoSku();
					commoditySkuAlbumFlag = commodityAlbumService.save(commoditySkuAlbumVo);
					// 设置中间表相册ID
					commoditySkuMiddle.setAlbumId(commoditySkuAlbumVo.getAlbumId());
					// 为相册中图片设置相册ID
					commoditySkuAlbumVo.getCommodityPics()
							.forEach(pic -> pic.setAlbumId(commoditySkuAlbumVo.getAlbumId()));
					// 将图片赋给外部list统一批量插入
					picsList.addAll(commoditySkuAlbumVo.getCommodityPics());
				} else if (sku.getAlbumId() != null) {
					// 设置中间表相册ID
					commoditySkuMiddle.setAlbumId(sku.getAlbumId());
				}
				// 如果当前SKU没有新增库存实体类则使用商品库存为默认。(库存是填入，无法选择)
				if (Objects.nonNull(sku.getCommodityRepoSku())) {
					// 保存SKU对应的库存
					CommodityRepoEntity commoditySkuRepo = sku.getCommodityRepoSku();
					commoditySkuRepoFlag = commodityRepoService.save(commoditySkuRepo);
					// 设置中间表库存ID
					commoditySkuMiddle.setRepoId(commoditySkuRepo.getRepoId());
				}
				// SKU价格列表如果有价格相关实体则新增绑定，没有则使用默认
				if (sku.getCommodityPricesSku().size() > 0) {
					List<CommodityPriceEntity> commoditySkuPrices = sku.getCommodityPricesSku();
					for (CommodityPriceEntity price : commoditySkuPrices) {
						commoditySkuPriceFlag = commodityPriceService.save(price) && commoditySkuPriceFlag;
						// 设置中间表价格ID，并执行中间表插入，由于价格可能是多个，所以中间表可能是多条记录
						commoditySkuMiddle.setMiddleId(null);
						commoditySkuMiddle.setPriceId(price.getPriceId());
						commoditySkuMiddleService.save(commoditySkuMiddle);
					}
				}
			}
		}
		//@formatter:off
		return (commodityAttrFlag 
				&& commodityParamFlag 
				&& commoditySkuAlbumFlag 
				&& commoditySkuRepoFlag 
				&& commoditySkuPriceFlag 
				&& commoditySkuFlag) 
				? 
				Result.ok().put("rs", true).put("extract", picsList) 
				: 
				Result.ok().put("rs", false).put("extract", null);
		//@formatter:on
	}

	/**
	 * 相册图片插入
	 */
	private Result tryInsertCommodityPic(List<CommodityPicEntity> pics) {
		return Result.ok().put("rs", commodityPicService.saveBatch(pics));
	}

	/* ##################### generator ##################### */

	/**
	 * 
	 */
	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CommodityEntity> page = this.page(new Query<CommodityEntity>().getPage(params),
				new QueryWrapper<CommodityEntity>());

		return new PageUtils(page);
	}

}
