package com.zlzc.api.rest.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.commodity.dao.CommodityPicDao;
import com.zlzc.api.rest.commodity.entity.CommodityPicEntity;
import com.zlzc.api.rest.commodity.service.CommodityPicService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("commodityPicService")
public class CommodityPicServiceImpl extends ServiceImpl<CommodityPicDao, CommodityPicEntity> implements CommodityPicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommodityPicEntity> page = this.page(
                new Query<CommodityPicEntity>().getPage(params),
                new QueryWrapper<CommodityPicEntity>()
        );

        return new PageUtils(page);
    }

}
