package com.zlzc.modules.commodity.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import com.zlzc.modules.commodity.dao.CommoditySkuMiddleDao;
import com.zlzc.modules.commodity.entity.CommoditySkuMiddleEntity;
import com.zlzc.modules.commodity.service.CommoditySkuMiddleService;


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
