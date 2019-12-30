package com.zlzc.modules.commodity.service.impl;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.commodity.dao.CommodityAlbumDao;
import com.zlzc.modules.commodity.entity.CommodityAlbumEntity;
import com.zlzc.modules.commodity.entity.CommodityPicEntity;
import com.zlzc.modules.commodity.service.CommodityAlbumService;
import com.zlzc.modules.commodity.service.CommodityPicService;

@Service("commodityAlbumService")
public class CommodityAlbumServiceImpl extends ServiceImpl<CommodityAlbumDao, CommodityAlbumEntity>
		implements CommodityAlbumService {

	@Autowired
	private CommodityPicService commodityPicService;

	/**
	 * 删除图片（可批量）
	 */
	@Transactional
	@Override
	public boolean delPics(Long[] commodityPicIds) {
		return commodityPicService.removeByIds(Arrays.asList(commodityPicIds));
	}

	/**
	 * 将指定图片从一个相册转移到另外一个相册中。
	 */
	@Transactional
	@Override
	public boolean transferPic(Long picId, Long fromAlbumId, Long toAlbumId) {
		//@formatter:off
		CommodityPicEntity commodityPic = new CommodityPicEntity()
				.setPicId(picId)
				.setAlbumId(toAlbumId);
		//@formatter:on
		return commodityPicService.updateById(commodityPic);
	}

	/**
	 * 获取指定相册的图片列表(可分页)
	 */
	@Override
	public PageUtils queryPicList(Map<String, Object> params, Long albumId) {
		LambdaQueryWrapper<CommodityPicEntity> qw = new LambdaQueryWrapper<CommodityPicEntity>()
				.eq(Objects.nonNull(albumId), CommodityPicEntity::getAlbumId, albumId);
		IPage<CommodityPicEntity> page = commodityPicService.page(new Query<CommodityPicEntity>().getPage(params), qw);
		return new PageUtils(page);
	}

	/**
	 * 修改相册
	 */
	@Override
	public boolean updAlbum(CommodityAlbumEntity album) {
		return updateById(album);
	}

	/**
	 * 新增相册
	 */
	@Transactional
	@Override
	public boolean saveAlbum(CommodityAlbumEntity album) {
		return save(album);
	}

	/**
	 * 删除相册(可批量)
	 */
	@Transactional
	@Override
	public boolean delAlbum(Long[] commodityAlbumIds) {
		return removeByIds(Arrays.asList(commodityAlbumIds));
	}

	/**
	 * 商户或店铺相册列表(可分页 + 根据相册名称进行条件查询)
	 */
	@Override
	public PageUtils queryList(Map<String, Object> params, Long merchantId, Long shopId, String albumName) {
		QueryWrapper<CommodityAlbumEntity> qw = new QueryWrapper<CommodityAlbumEntity>()
				.eq(Objects.nonNull(merchantId), "merchant_id", merchantId)
				.eq(Objects.nonNull(shopId), "shop_id", shopId)
				.eq(StringUtils.isNotBlank(albumName), "album_name", albumName);
		IPage<CommodityAlbumEntity> page = this.page(new Query<CommodityAlbumEntity>().getPage(params), qw);
		return new PageUtils(page);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CommodityAlbumEntity> page = this.page(new Query<CommodityAlbumEntity>().getPage(params),
				new QueryWrapper<CommodityAlbumEntity>());

		return new PageUtils(page);
	}

}
