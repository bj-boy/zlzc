package com.zlzc.api.rest.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.commodity.dao.CommodityRepoDao;
import com.zlzc.api.rest.commodity.entity.CommodityRepoEntity;
import com.zlzc.api.rest.commodity.service.CommodityRepoService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("commodityRepoService")
public class CommodityRepoServiceImpl extends ServiceImpl<CommodityRepoDao, CommodityRepoEntity> implements CommodityRepoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommodityRepoEntity> page = this.page(
                new Query<CommodityRepoEntity>().getPage(params),
                new QueryWrapper<CommodityRepoEntity>()
        );

        return new PageUtils(page);
    }

}
