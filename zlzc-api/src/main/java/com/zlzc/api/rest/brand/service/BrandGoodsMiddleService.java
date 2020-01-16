package com.zlzc.api.rest.brand.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.brand.entity.BrandGoodsMiddleEntity;
import com.zlzc.common.utils.PageUtils;
import java.util.Map;

/**
 * 品牌商品关联表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
public interface BrandGoodsMiddleService extends IService<BrandGoodsMiddleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

