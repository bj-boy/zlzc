package com.zlzc.api.rest.shop.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import com.zlzc.api.rest.shop.vo.ShopVo;
import com.zlzc.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: ShopService
 * @author LBB
 * @email biaobiao999@163.com
 * @date 2019-12-02 11:17:30 
 *
 */
public interface ShopService extends IService<ShopEntity> {
	PageUtils queryPage(Map<String, Object> params);    //没有关联商品件数

	Map<String, Object> queryShopDetails(Integer shopId);

	PageUtils queryPageWithCnt(Map<String, Object> params, ShopEntity shop);

	PageUtils queryPageShop(Map<String, Object> params);

	/**
	 * 查询全部商铺
	 */
	public IPage<ShopVo> listShop(Map<String, Object> params, String userName);

	/**
	 * 根据名字返回商户信息
	 */
	List<ShopEntity> ShopByName(String byName);
	/**
	 * 根据名称查询店铺内部商品
	 */
	List<ShopVo> shopCommodityByName(String commodityName);
	/**
	 * 首页商品查询
	 */
	IPage<ShopVo> shopCommodityList(Map<String, Object> params);

	/**
	 * 店铺品牌列表
	 * @param params
	 * @return
	 */
	IPage<ShopVo> shopBrandList(Map<String, Object> params,Long shopId);

	/**
	 * 店铺品牌下的商品列表
	 */
	IPage<ShopVo> brandCommodityList(Map<String, Object> params,Long brandId);
	/**
	 * 店铺商品分类
	 */
	List<ShopVo>shopCommodityFL(Long shopId);
	/**
	 * 店铺简介
	 */
	ShopVo shopMerchantIntroduction(Long shopId);
}
