package com.zlzc.modules.commodity.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.exception.ZException;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.commodity.dao.CommodityDao;
import com.zlzc.modules.commodity.entity.CommodityCategoryEntity;
import com.zlzc.modules.commodity.entity.CommodityDetailEntity;
import com.zlzc.modules.commodity.entity.CommodityEntity;
import com.zlzc.modules.commodity.entity.CommodityParamEntity;
import com.zlzc.modules.commodity.entity.CommodityPicEntity;
import com.zlzc.modules.commodity.entity.CommodityPriceEntity;
import com.zlzc.modules.commodity.entity.CommodityRepoEntity;
import com.zlzc.modules.commodity.service.CommodityAlbumService;
import com.zlzc.modules.commodity.service.CommodityAttrService;
import com.zlzc.modules.commodity.service.CommodityCategoryService;
import com.zlzc.modules.commodity.service.CommodityDetailService;
import com.zlzc.modules.commodity.service.CommodityParamService;
import com.zlzc.modules.commodity.service.CommodityPicService;
import com.zlzc.modules.commodity.service.CommodityPriceService;
import com.zlzc.modules.commodity.service.CommodityRepoService;
import com.zlzc.modules.commodity.service.CommodityService;
import com.zlzc.modules.commodity.service.CommoditySkuService;
import com.zlzc.modules.commodity.vo.CommodityAlbumVo;
import com.zlzc.modules.commodity.vo.CommoditySkuVo;
import com.zlzc.modules.commodity.vo.CommodityVo;

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

	@Override
	public List<CommodityVo> queryCommodity() {
		return baseMapper.queryCommodity();
	}

	@SuppressWarnings("unused")
	@Transactional
	@Override
	public boolean saveCommodity(CommodityVo commodity) {
		boolean commodityCategoryFlag = false;
		boolean commodityAttrFlag = false;
		boolean commodityParamFlag = false;
		boolean commodityRepoFlag = false;
		boolean commodityAlbumFlag = false;
		boolean commoditySkuAlbumFlag = false;
		boolean commoditySkuRepoFlag = false;
		boolean commoditySkuPriceFlag = false;
		boolean commoditySkuFlag = false;
		boolean commodityFlag = false;
		boolean commodityPriceFlag = false;
		boolean commodityDetailsFlag = false;

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

		/* 判断当前商品是否关联已有属性（eg：关联了已有属性会有属性id） */
		if (commodity.getCommodityAttrId() == null && Objects.isNull(commodity.getCommodityAttrVo())) {
			throw new ZException("请选择或添加商品属性。");
		} else if (commodity.getCommodityAttrId() == null) {
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
				// 如果当前SKU没有相册ID或没有新增相册实体类则使用商品相册为默认值。
				if (sku.getAlbumId() == null && Objects.nonNull(sku.getCommodityAlbumVoSku())) {
					// 保存SKU对应的相册
					CommodityAlbumVo commoditySkuAlbumVo = sku.getCommodityAlbumVoSku();
					commoditySkuAlbumFlag = commodityAlbumService.save(commoditySkuAlbumVo);
					sku.setAlbumId(commoditySkuAlbumVo.getAlbumId());
					// 为相册中图片设置相册ID
					commoditySkuAlbumVo.getCommodityPics()
							.forEach(pic -> pic.setAlbumId(commoditySkuAlbumVo.getAlbumId()));
					// 将图片赋给外部list统一批量插入
					/*---------------------*/
					commodityPicService.saveBatch(commoditySkuAlbumVo.getCommodityPics());
				}
				// 如果当前SKU没有库存ID或没有新增库存实体类则使用商品库存为默认。
				if (sku.getRepoId() == null && Objects.nonNull(sku.getCommodityRepoSku())) {
					// 保存SKU对应的库存
					CommodityRepoEntity commoditySkuRepo = sku.getCommodityRepoSku();
					commoditySkuRepoFlag = commodityRepoService.save(commoditySkuRepo);
					sku.setRepoId(commoditySkuRepo.getRepoId());
				}

				// 保存当前SKU
				commoditySkuFlag = commoditySkuService.save(sku);

				// SKU价格列表如果有价格相关实体则新增绑定，没有则使用默认
				if (sku.getCommodityPricesSku().size() > 0) {
					List<CommodityPriceEntity> commoditySkuPrices = sku.getCommodityPricesSku();
					commoditySkuPrices.forEach(price -> price.setSkuId(sku.getSkuId()));
					commoditySkuPriceFlag = commodityPriceService.saveBatch(commoditySkuPrices);
				}
			}

		} else if (commodity.getCommodityAttrId() != null) {
			commodityAttrFlag = true;
			commodityParamFlag = true;
			commoditySkuAlbumFlag = true;
			commoditySkuRepoFlag = true;
			commoditySkuPriceFlag = true;
			commoditySkuFlag = true;
		}

		/* 判断当前商品是否关联已有库存信息（eg：关联了已有库存会有库存id） */
		if (commodity.getCommodityRepoId() == null && Objects.isNull(commodity.getCommodityRepo())) {
			throw new ZException("请添加商品库存相关信息。");
		} else if (commodity.getCommodityRepoId() == null) {
			// 插入库存记录
			commodityRepoFlag = commodityRepoService.save(commodity.getCommodityRepo());
			// 插入成功后将生成属性ID分配给商品
			commodity.setCommodityRepoId(commodity.getCommodityRepo().getRepoId());
		} else if (commodity.getCommodityRepoId() != null) {
			commodityRepoFlag = true;
		}

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
			// 执行图片批量插入
			commodityPicService.saveBatch(commodityPics);
		} else if (commodity.getComodityAlbumId() != null) {
			commodityAlbumFlag = true;
		}

		/* 插入商品信息 */
		commodityFlag = save(commodity);

		/* 商品详情和价格是在自己表中维护了商品ID,所以先插入商品后拿到ID再插入价格和详情 */
		// 判断是否有商品详情,有则添加
		if (commodity.getCommodityDetails().size() > 0) {
			List<CommodityDetailEntity> commodityDetails = commodity.getCommodityDetails();
			commodityDetails.forEach(detail -> detail.setCommodityId(commodity.getCommodityId()));
			commodityDetailsFlag = commodityDetailService.saveBatch(commodityDetails);
		} else {
			commodityDetailsFlag = true;
		}
		// 判断是否有价格,有则添加
		if (commodity.getCommodityPrices().size() > 0) {
			List<CommodityPriceEntity> commodityPrices = commodity.getCommodityPrices();
			commodityPrices.forEach(price -> price.setCommodityId(commodity.getCommodityId()));
			commodityPriceFlag = commodityPriceService.saveBatch(commodityPrices);
		} else {
			commodityPriceFlag = true;
		}

		return false;
	}

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

	private Result tryInsertCommodityRepo(CommodityVo commodity) {
		boolean commodityRepoFlag = false;
		/* 判断当前商品是否关联已有库存信息（eg：关联了已有库存会有库存id） */
		if (commodity.getCommodityRepoId() == null && Objects.isNull(commodity.getCommodityRepo())) {
			throw new ZException("请添加商品库存相关信息。");
		} else if (commodity.getCommodityRepoId() == null) {
			// 插入库存记录
			commodityRepoFlag = commodityRepoService.save(commodity.getCommodityRepo());
			// 插入成功后将生成属性ID分配给商品
			commodity.setCommodityRepoId(commodity.getCommodityRepo().getRepoId());
		} else if (commodity.getCommodityRepoId() != null) {
			commodityRepoFlag = true;
		}
		return Result.ok().put("rs", commodityRepoFlag);
	}

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
			// 执行图片批量插入
			// commodityPicService.saveBatch(commodityPics);
		} else if (commodity.getComodityAlbumId() != null) {
			commodityAlbumFlag = true;
		}
		//@formatter:off
		return Result.ok()
				.put("rs", commodityAlbumFlag)
				.put("extract", commodity.getCommodityAlbumVo().getCommodityPics());
		//@formatter:on
	}

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

	private Result tryInsertCommodityPrices(CommodityVo commodity) {
		boolean commodityPriceFlag = false;
		// 判断是否有价格,有则添加
		if (commodity.getCommodityPrices().size() > 0) {
			List<CommodityPriceEntity> commodityPrices = commodity.getCommodityPrices();
			commodityPrices.forEach(price -> price.setCommodityId(commodity.getCommodityId()));
			commodityPriceFlag = commodityPriceService.saveBatch(commodityPrices);
		} else {
			commodityPriceFlag = true;
		}
		return Result.ok().put("rs", commodityPriceFlag);
	}

	private Result tryInsertCommodityAttr(CommodityVo commodity) {

		return null;
	}

	/* ######################################### */

	@Transactional
	// @Override
	public boolean saveCommodityOld(CommodityVo commodity) {
		// 插入商品表
		boolean commodityFlag = save(commodity);
		// 插入商品详情表
		// boolean commodityDetailFlag =
		// commodityDetailService.save(commodity.getCommodityDetail());
		// 插入商品分类表
		boolean commodityCategoryFlag = commodityCategoryService.save(commodity.getCommodityCategory());
		// 插入商品属性表
		boolean commodityAttrFlag = commodityAttrService.save(commodity.getCommodityAttrVo());
		// 批量插入商品参数
		boolean commodityParamFlag = commodityParamService
				.saveBatch(commodity.getCommodityAttrVo().getCommodityParams());
		// 批量插入SKU
		boolean commoditySKUFlag = commoditySkuService.saveBatchSub(commodity.getCommodityAttrVo().getCommoditySkuVos(),
				1000);
		// 批量插入库存
		List<CommodityRepoEntity> repoList = new ArrayList<>();
		repoList.add(commodity.getCommodityRepo());
		commodity.getCommodityAttrVo().getCommoditySkuVos().forEach((sku) -> {
			repoList.add(sku.getCommodityRepoSku());
		});
		boolean commodityRepoFlag = commodityRepoService.saveBatch(repoList);
		// 批量插入价格
		List<CommodityPriceEntity> commodityPricesList = commodity.getCommodityPrices();
		commodity.getCommodityAttrVo().getCommoditySkuVos()
				.forEach(sku -> commodityPricesList.addAll(sku.getCommodityPricesSku()));
		boolean commodityPriceFlag = commodityPriceService.saveBatch(commodityPricesList);
		// 批量插入相册
		List<CommodityAlbumVo> albumVoList = new ArrayList<>();
		albumVoList.add(commodity.getCommodityAlbumVo());
		commodity.getCommodityAttrVo().getCommoditySkuVos()
				.forEach(sku -> albumVoList.add(sku.getCommodityAlbumVoSku()));
		boolean commodityAlbumFlag = commodityAlbumService.saveBatchSub(albumVoList, 1000);
		// 批量插入图片
		List<CommodityPicEntity> picList = new ArrayList<>();
		albumVoList.forEach(album -> picList.addAll(album.getCommodityPics()));
		boolean commodityPicFlag = commodityPicService.saveBatch(picList);

		//@formatter:off
		return commodityFlag 
//			&& commodityDetailFlag 
			&& commodityCategoryFlag 
			&& commodityAttrFlag 
			&& commodityParamFlag
			&& commoditySKUFlag 
			&& commodityRepoFlag 
			&& commodityPriceFlag 
			&& commodityAlbumFlag
			&& commodityPicFlag;
		//@formatter:on
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CommodityEntity> page = this.page(new Query<CommodityEntity>().getPage(params),
				new QueryWrapper<CommodityEntity>());

		return new PageUtils(page);
	}

}
