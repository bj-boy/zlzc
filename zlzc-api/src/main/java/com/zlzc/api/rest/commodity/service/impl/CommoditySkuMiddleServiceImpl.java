package com.zlzc.api.rest.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.commodity.dao.CommoditySkuMiddleDao;
import com.zlzc.api.rest.commodity.entity.CommoditySkuMiddleEntity;
import com.zlzc.api.rest.commodity.service.CommoditySkuMiddleService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("commoditySkuMiddleService")
public class CommoditySkuMiddleServiceImpl extends ServiceImpl<CommoditySkuMiddleDao, CommoditySkuMiddleEntity> implements CommoditySkuMiddleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommoditySkuMiddleEntity> page = this.page(
                new Query<CommoditySkuMiddleEntity>().getPage(params),
                new QueryWrapper<CommoditySkuMiddleEntity>()
        );

        return new PageUtils(page);
    }

}
