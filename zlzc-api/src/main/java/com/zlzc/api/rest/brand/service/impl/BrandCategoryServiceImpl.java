package com.zlzc.api.rest.brand.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.zlzc.api.rest.brand.dao.BrandCategoryDao;
import com.zlzc.api.rest.brand.entity.BrandCategoryEntity;
import com.zlzc.api.rest.brand.entity.BrandEntity;
import com.zlzc.api.rest.brand.service.BrandCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;



@Service("brandCategoryService")
public class BrandCategoryServiceImpl extends ServiceImpl<BrandCategoryDao, BrandCategoryEntity> implements BrandCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BrandCategoryEntity> page = this.page(
                new Query<BrandCategoryEntity>().getPage(params),
                new QueryWrapper<BrandCategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<BrandCategoryEntity> getCommendCategory() {

        QueryWrapper<BrandCategoryEntity> qw = new QueryWrapper<BrandCategoryEntity>()
                .select("brand_category_name")
                .groupBy("brand_category_name");
        List<BrandCategoryEntity> list = this.list(qw);
        return list;
    }

}
