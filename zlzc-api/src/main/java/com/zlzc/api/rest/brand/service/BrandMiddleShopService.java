package com.zlzc.api.rest.brand.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.brand.entity.BrandMiddleShopEntity;
import com.zlzc.common.utils.PageUtils;

import java.util.Map;

/**
 * 品牌店铺关联表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
public interface BrandMiddleShopService extends IService<BrandMiddleShopEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

