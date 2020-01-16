package com.zlzc.api.rest.brand.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.brand.entity.BrandCategoryEntity;
import com.zlzc.api.rest.brand.entity.BrandEntity;
import com.zlzc.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 品牌分类
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
public interface BrandCategoryService extends IService<BrandCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 品牌分类查询
     */
    List<BrandCategoryEntity> getCommendCategory();
}

