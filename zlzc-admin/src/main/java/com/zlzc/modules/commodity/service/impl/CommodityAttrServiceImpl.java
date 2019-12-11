package com.zlzc.modules.commodity.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import com.zlzc.modules.commodity.dao.CommodityAttrDao;
import com.zlzc.modules.commodity.entity.CommodityAttrEntity;
import com.zlzc.modules.commodity.service.CommodityAttrService;


@Service("commodityAttrService")
public class CommodityAttrServiceImpl extends ServiceImpl<CommodityAttrDao, CommodityAttrEntity> implements CommodityAttrService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommodityAttrEntity> page = this.page(
                new Query<CommodityAttrEntity>().getPage(params),
                new QueryWrapper<CommodityAttrEntity>()
        );

        return new PageUtils(page);
    }

}
