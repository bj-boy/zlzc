package com.zlzc.api.rest.brand.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.brand.entity.BrandEntity;
import com.zlzc.api.rest.brand.vo.BrandVo;
import com.zlzc.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 品牌管理表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
public interface BrandService extends IService<BrandEntity> {
    /**
     * 列表查询
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);
    /**
     * 品牌推荐查询
     * 1.推荐
     * 0.不推荐
     */
    List<BrandEntity> getreCommendList(int commend);

    /**
     * 根据品牌分类查询品牌
     */
    List<BrandVo>  getBrandCategoriesService(String  categoriesName);
    /**
     * 根据品牌id查询相关商品
     */
    List<BrandVo>  getBrandCommodityService(Long brandId);
    /**
     * 根据品牌id查询相关商户
     */
    List<BrandVo>  getBrandShopService(Long brandId);
    /**
     * 根据品牌id查询相关评论
     */
    List<BrandVo> getBrandCommentService(Long brandId);

    /**
     * 品牌搜素
     * @param brandName
     * @return
     */
    List<BrandVo> getBrandSearchFor(String brandName);
}

