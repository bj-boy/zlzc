package com.zlzc.modules.commodity.service.impl;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.commodity.dao.CommodityCategoryDao;
import com.zlzc.modules.commodity.entity.CommodityCategoryEntity;
import com.zlzc.modules.commodity.service.CommodityCategoryService;

@Service("commodityCategoryService")
public class CommodityCategoryServiceImpl extends ServiceImpl<CommodityCategoryDao, CommodityCategoryEntity>
		implements CommodityCategoryService {

	/* ##################### 商品分类 ##################### */

	/**
	 * 商品分类列表(支持分页及条件，仅查询一级分类)
	 */
	@Override
	public PageUtils commodityCategoryList(Map<String, Object> params, CommodityCategoryEntity commodityCategory) {
		QueryWrapper<CommodityCategoryEntity> qw = new QueryWrapper<CommodityCategoryEntity>()
				.isNull("parent_category_id");
		IPage<CommodityCategoryEntity> page = this.page(new Query<CommodityCategoryEntity>().getPage(params), qw);
		return new PageUtils(page);
	}

	/**
	 * 查询指定分类的子集列表
	 */
	@Override
	public PageUtils querySubCommodityCategory(Map<String, Object> params, Long commodityCategoryId) {
		QueryWrapper<CommodityCategoryEntity> qw = new QueryWrapper<CommodityCategoryEntity>().eq("parent_category_id",
				commodityCategoryId);
		IPage<CommodityCategoryEntity> page = this.page(new Query<CommodityCategoryEntity>().getPage(params), qw);
		return new PageUtils(page);
	}

	/**
	 * 新增商品分类
	 */
	@Override
	public boolean saveCommodityCategory(CommodityCategoryEntity commodityCategory) {
		boolean saveFlag = save(commodityCategory);
		return saveFlag;
	}

	/**
	 * 修改商品分类
	 */
	@Override
	public boolean updCommodityCategory(CommodityCategoryEntity commodityCategory) {
		boolean updFlag = updateById(commodityCategory);
		return updFlag;
	}

	/**
	 * 删除商品分类(支持批量)
	 */
	@Override
	public boolean delCommodityCategory(Long[] commodityCategoryIds) {
		boolean rmFlag = removeByIds(Arrays.asList(commodityCategoryIds));
		return rmFlag;
	}

	/* ##################### generator ##################### */

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CommodityCategoryEntity> page = this.page(new Query<CommodityCategoryEntity>().getPage(params),
				new QueryWrapper<CommodityCategoryEntity>());

		return new PageUtils(page);
	}

}
