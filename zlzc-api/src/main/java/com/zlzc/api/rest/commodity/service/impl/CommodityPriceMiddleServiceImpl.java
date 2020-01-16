package com.zlzc.api.rest.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.commodity.dao.CommodityPriceMiddleDao;
import com.zlzc.api.rest.commodity.entity.CommodityPriceMiddleEntity;
import com.zlzc.api.rest.commodity.service.CommodityPriceMiddleService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import org.springframework.stereotype.Service;

import java.util.Map;


@Service("commodityPriceMiddleService")
public class CommodityPriceMiddleServiceImpl extends ServiceImpl<CommodityPriceMiddleDao, CommodityPriceMiddleEntity> implements CommodityPriceMiddleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommodityPriceMiddleEntity> page = this.page(
                new Query<CommodityPriceMiddleEntity>().getPage(params),
                new QueryWrapper<CommodityPriceMiddleEntity>()
        );

        return new PageUtils(page);
    }

}
