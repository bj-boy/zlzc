package com.zlzc.api.rest.brand.service.impl;

import com.zlzc.api.rest.brand.dao.BrandGoodsMiddleDao;
import com.zlzc.api.rest.brand.entity.BrandGoodsMiddleEntity;
import com.zlzc.api.rest.brand.service.BrandGoodsMiddleService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;


@Service("brandGoodsMiddleService")
public class BrandGoodsMiddleServiceImpl extends ServiceImpl<BrandGoodsMiddleDao, BrandGoodsMiddleEntity> implements BrandGoodsMiddleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BrandGoodsMiddleEntity> page = this.page(
                new Query<BrandGoodsMiddleEntity>().getPage(params),
                new QueryWrapper<BrandGoodsMiddleEntity>()
        );

        return new PageUtils(page);
    }

}
