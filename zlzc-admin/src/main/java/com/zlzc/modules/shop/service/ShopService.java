package com.zlzc.modules.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.shop.entity.ShopEntity;

import java.util.Map;

/**
 * 
 * @ClassName: ShopService
 * @author LBB
 * @email biaobiao999@163.com
 * @date 2019-12-02 11:17:30 
 *
 */
public interface ShopService extends IService<ShopEntity>{


	Map<String, Object> queryShopDetails(Integer shopId);

	PageUtils queryPageWithCnt(Map<String, Object> params, ShopEntity shop);

	PageUtils queryPageShop(Map<String, Object> params);


}
