package com.zlzc.api.rest.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.commodity.dao.CommodityDetailDao;
import com.zlzc.api.rest.commodity.entity.CommodityDetailEntity;
import com.zlzc.api.rest.commodity.service.CommodityDetailService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import org.springframework.stereotype.Service;

import java.util.Map;


@Service("commodityDetailService")
public class CommodityDetailServiceImpl extends ServiceImpl<CommodityDetailDao, CommodityDetailEntity> implements CommodityDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommodityDetailEntity> page = this.page(
                new Query<CommodityDetailEntity>().getPage(params),
                new QueryWrapper<CommodityDetailEntity>()
        );

        return new PageUtils(page);
    }

}
