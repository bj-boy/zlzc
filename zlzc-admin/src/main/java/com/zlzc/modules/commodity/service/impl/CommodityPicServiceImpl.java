package com.zlzc.modules.commodity.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import com.zlzc.modules.commodity.dao.CommodityPicDao;
import com.zlzc.modules.commodity.entity.CommodityPicEntity;
import com.zlzc.modules.commodity.service.CommodityPicService;


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
