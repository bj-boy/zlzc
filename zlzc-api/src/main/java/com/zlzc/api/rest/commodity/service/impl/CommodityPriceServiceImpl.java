package com.zlzc.api.rest.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.commodity.dao.CommodityPriceDao;
import com.zlzc.api.rest.commodity.entity.CommodityPriceEntity;
import com.zlzc.api.rest.commodity.service.CommodityPriceService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("commodityPriceService")
public class CommodityPriceServiceImpl extends ServiceImpl<CommodityPriceDao, CommodityPriceEntity> implements CommodityPriceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommodityPriceEntity> page = this.page(
                new Query<CommodityPriceEntity>().getPage(params),
                new QueryWrapper<CommodityPriceEntity>()
        );

        return new PageUtils(page);
    }

}
