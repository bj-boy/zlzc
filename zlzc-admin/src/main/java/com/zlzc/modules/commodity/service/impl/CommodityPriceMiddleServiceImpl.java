package com.zlzc.modules.commodity.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import com.zlzc.modules.commodity.dao.CommodityPriceMiddleDao;
import com.zlzc.modules.commodity.entity.CommodityPriceMiddleEntity;
import com.zlzc.modules.commodity.service.CommodityPriceMiddleService;


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
