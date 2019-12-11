package com.zlzc.modules.commodity.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import com.zlzc.modules.commodity.dao.CommodityParamDao;
import com.zlzc.modules.commodity.entity.CommodityParamEntity;
import com.zlzc.modules.commodity.service.CommodityParamService;


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
