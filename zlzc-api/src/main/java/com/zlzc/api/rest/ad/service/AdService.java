package com.zlzc.api.rest.ad.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.ad.entity.AdEntity;
import com.zlzc.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 广告表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
public interface AdService extends IService<AdEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询轮播广告位置
     */
    List<AdEntity> getAdCarouselService(Integer position);
}

