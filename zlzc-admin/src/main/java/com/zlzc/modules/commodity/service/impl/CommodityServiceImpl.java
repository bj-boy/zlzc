package com.zlzc.modules.commodity.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.commodity.dao.CommodityDao;
import com.zlzc.modules.commodity.entity.CommodityEntity;
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

	@Transactional
	@Override
	public boolean saveCommodity(CommodityVo commodity) {
		// 判断当前商品是否关联已有分类（eg：关联了已有分类会有分类id）
		if (commodity.getCommodityCategoryId() == null) {
			
		}

		return false;
	}

	@Transactional
	// @Override
	public boolean saveCommodityOld(CommodityVo commodity) {
		// 插入商品表
		boolean commodityFlag = save(commodity);
		// 插入商品详情表
		boolean commodityDetailFlag = commodityDetailService.save(commodity.getCommodityDetail());
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
			&& commodityDetailFlag 
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
