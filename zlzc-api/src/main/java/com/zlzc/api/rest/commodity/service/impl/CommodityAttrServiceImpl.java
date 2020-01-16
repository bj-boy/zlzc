package com.zlzc.api.rest.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.commodity.dao.CommodityAttrDao;
import com.zlzc.api.rest.commodity.entity.CommodityAttrEntity;
import com.zlzc.api.rest.commodity.entity.CommodityParamEntity;
import com.zlzc.api.rest.commodity.entity.CommoditySkuEntity;
import com.zlzc.api.rest.commodity.service.CommodityAttrService;
import com.zlzc.api.rest.commodity.service.CommodityParamService;
import com.zlzc.api.rest.commodity.service.CommoditySkuService;
import com.zlzc.api.rest.commodity.vo.CommodityAttrPageVo;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service("commodityAttrService")
public class CommodityAttrServiceImpl extends ServiceImpl<CommodityAttrDao, CommodityAttrEntity>
		implements CommodityAttrService {

	@Autowired
	private CommodityParamService commodityParamService;

	@Autowired
	private CommoditySkuService commoditySkuService;

	/* ##################### 商品属性 ##################### */

	/**
	 * 商品属性列表(支持分页及条件)
	 */
	@Override
	public PageUtils commodityAttrList(Map<String, Object> params, Long merchantId, Long shopId) {
		QueryWrapper<CommodityAttrPageVo> qw = new QueryWrapper<CommodityAttrPageVo>()
				.eq(Objects.nonNull(merchantId), "zca.merchant_id", merchantId)
				.eq(Objects.nonNull(shopId), "zca.shop_id", shopId).groupBy("zca.attr_id");
		IPage<CommodityAttrPageVo> page = baseMapper.queryPage(new Query<CommodityAttrPageVo>().getPage(params), qw);
		return new PageUtils(page);
	}

	/**
	 * 保存商品属性
	 */
	@Transactional
	@Override
	public boolean saveCommodityAttr(CommodityAttrEntity commodityAttr) {
		return save(commodityAttr);
	}

	/**
	 * 修改商品属性
	 */
	@Transactional
	@Override
	public boolean updCommodityAttr(CommodityAttrEntity commodityAttr) {
		return updateById(commodityAttr);
	}

	/**
	 * 删除商品属性
	 */
	@Transactional
	@Override
	public boolean delCommodityAttr(Long[] commodityAttrIds) {
		// 删除商品属性(没有考虑属性参数和属性sku相关记录)
		boolean rmFlag = removeByIds(Arrays.asList(commodityAttrIds));
		return rmFlag;
	}

	/**
	 * 查询指定商品属性id查询属性参数
	 */
	@Override
	public List<CommodityParamEntity> queryAttrParamByAttrId(Long commodityAttrId) {
		LambdaQueryWrapper<CommodityParamEntity> qw = new LambdaQueryWrapper<CommodityParamEntity>()
				.eq(CommodityParamEntity::getAttrId, commodityAttrId);
		List<CommodityParamEntity> commodityParamList = commodityParamService.list(qw);
		return commodityParamList;
	}

	/**
	 * 查询指定商品属性id查询SKU
	 */
	@Override
	public List<CommoditySkuEntity> queryAttrSkuByAttrId(Long commodityAttrId) {
		LambdaQueryWrapper<CommoditySkuEntity> qw = new LambdaQueryWrapper<CommoditySkuEntity>()
				.eq(CommoditySkuEntity::getAttrId, commodityAttrId);
		List<CommoditySkuEntity> commoditySkuList = commoditySkuService.list(qw);
		return commoditySkuList;
	}

	/**
	 * 修改商品属性参数
	 */
	@Override
	public boolean updCommodityAttrParam(CommodityParamEntity commodityParamEntity) {
		return commodityParamService.updateById(commodityParamEntity);
	}

	/**
	 * 修改商品属性SKU
	 */
	@Override
	public boolean updCommodityAttrSku(CommoditySkuEntity commoditySkuEntity) {
		return commoditySkuService.updateById(commoditySkuEntity);
	}

	/**
	 * 新增商品属性参数
	 */
	@Override
	public boolean saveCommodityAttrParam(CommodityParamEntity commodityParamEntity) {
		return commodityParamService.save(commodityParamEntity);
	}

	/**
	 * 新增商品属性SKU
	 */
	@Override
	public boolean saveCommodityAttrSku(CommoditySkuEntity commoditySkuEntity) {
		return commoditySkuService.save(commoditySkuEntity);
	}

	/**
	 * 删除商品属性参数
	 */
	@Override
	public boolean delCommodityAttrParam(Long[] paramIds) {
		return commodityParamService.removeByIds(Arrays.asList(paramIds));
	}

	/**
	 * 删除商品属性SKU
	 */
	@Override
	public boolean delCommodityAttrSku(Long[] skuIds) {
		return commoditySkuService.removeByIds(Arrays.asList(skuIds));
	}

	/* ##################### generator ##################### */
	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CommodityAttrEntity> page = this.page(new Query<CommodityAttrEntity>().getPage(params),
				new QueryWrapper<CommodityAttrEntity>());

		return new PageUtils(page);
	}

}
