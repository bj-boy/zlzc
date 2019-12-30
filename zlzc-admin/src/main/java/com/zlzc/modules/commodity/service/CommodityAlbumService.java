package com.zlzc.modules.commodity.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.commodity.entity.CommodityAlbumEntity;

/**
 * 
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
public interface CommodityAlbumService extends IService<CommodityAlbumEntity> {

	PageUtils queryPage(Map<String, Object> params);

	PageUtils queryList(Map<String, Object> params, Long merchantId, Long shopId, String albumName);

	boolean saveAlbum(CommodityAlbumEntity album);

	boolean updAlbum(CommodityAlbumEntity album);

	PageUtils queryPicList(Map<String, Object> params, Long albumId);

	boolean transferPic(Long picId, Long fromAlbumId, Long toAlbumId);

	boolean delAlbum(Long[] commodityAlbumIds);

	boolean delPics(Long[] commodityPicIds);

}
