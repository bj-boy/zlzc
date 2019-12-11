package com.zlzc.modules.commodity.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import com.zlzc.modules.commodity.dao.CommodityRepoDao;
import com.zlzc.modules.commodity.entity.CommodityRepoEntity;
import com.zlzc.modules.commodity.service.CommodityRepoService;


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
