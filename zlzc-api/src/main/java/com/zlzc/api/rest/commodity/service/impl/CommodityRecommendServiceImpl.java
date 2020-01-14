package com.zlzc.api.rest.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.commodity.dao.CommodityPriceDao;
import com.zlzc.api.rest.commodity.dao.CommodityRecommendDao;
import com.zlzc.api.rest.commodity.entity.CommodityPriceEntity;
import com.zlzc.api.rest.commodity.entity.CommodityRecommendEntity;
import com.zlzc.api.rest.commodity.service.CommodityPriceService;
import com.zlzc.api.rest.commodity.service.CommodityRecommendService;
import com.zlzc.api.rest.commodity.vo.CommodityRecommendVo;
import com.zlzc.api.rest.shop.entity.ShopEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CommodityRecommendService")
public class CommodityRecommendServiceImpl
        extends ServiceImpl<CommodityRecommendDao,CommodityRecommendVo> implements CommodityRecommendService {

    @Override
    public List<CommodityRecommendVo> getByStatus(Integer status) {

        QueryWrapper<CommodityRecommendVo> wq = new QueryWrapper<CommodityRecommendVo>()
                .eq("r.recommend_status",status);

        List<CommodityRecommendVo> byStatus = baseMapper.getByStatus(wq);

        return byStatus;
    }
}
