package com.zlzc.api.rest.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.commodity.entity.CommodityRecommendEntity;
import com.zlzc.api.rest.commodity.vo.CommodityRecommendVo;

import java.util.List;

public interface CommodityRecommendService extends IService<CommodityRecommendVo> {
    /**
     * 商品状态返回指定商品
     */
    public List<CommodityRecommendVo> getByStatus(Integer status);
}
