package com.zlzc.api.rest.brand.service.impl;

import com.zlzc.api.rest.brand.dao.BrandMiddleShopDao;
import com.zlzc.api.rest.brand.entity.BrandMiddleShopEntity;
import com.zlzc.api.rest.brand.service.BrandMiddleShopService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;


@Service("brandMiddleShopService")
public class BrandMiddleShopServiceImpl extends ServiceImpl<BrandMiddleShopDao, BrandMiddleShopEntity> implements BrandMiddleShopService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BrandMiddleShopEntity> page = this.page(
                new Query<BrandMiddleShopEntity>().getPage(params),
                new QueryWrapper<BrandMiddleShopEntity>()
        );

        return new PageUtils(page);
    }

}
