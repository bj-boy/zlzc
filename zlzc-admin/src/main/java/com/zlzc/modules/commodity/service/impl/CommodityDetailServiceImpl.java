package com.zlzc.modules.commodity.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import com.zlzc.modules.commodity.dao.CommodityDetailDao;
import com.zlzc.modules.commodity.entity.CommodityDetailEntity;
import com.zlzc.modules.commodity.service.CommodityDetailService;


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
