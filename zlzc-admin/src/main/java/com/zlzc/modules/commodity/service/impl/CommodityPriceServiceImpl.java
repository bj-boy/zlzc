package com.zlzc.modules.commodity.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import com.zlzc.modules.commodity.dao.CommodityPriceDao;
import com.zlzc.modules.commodity.entity.CommodityPriceEntity;
import com.zlzc.modules.commodity.service.CommodityPriceService;


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
