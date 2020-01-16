package com.zlzc.api.rest.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.commodity.dao.CommodityParamDao;
import com.zlzc.api.rest.commodity.entity.CommodityParamEntity;
import com.zlzc.api.rest.commodity.service.CommodityParamService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("commodityParamService")
public class CommodityParamServiceImpl extends ServiceImpl<CommodityParamDao, CommodityParamEntity> implements CommodityParamService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommodityParamEntity> page = this.page(
                new Query<CommodityParamEntity>().getPage(params),
                new QueryWrapper<CommodityParamEntity>()
        );

        return new PageUtils(page);
    }

}
