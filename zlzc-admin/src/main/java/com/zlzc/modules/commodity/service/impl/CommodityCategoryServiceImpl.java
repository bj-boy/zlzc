package com.zlzc.modules.commodity.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import com.zlzc.modules.commodity.dao.CommodityCategoryDao;
import com.zlzc.modules.commodity.entity.CommodityCategoryEntity;
import com.zlzc.modules.commodity.service.CommodityCategoryService;


@Service("commodityCategoryService")
public class CommodityCategoryServiceImpl extends ServiceImpl<CommodityCategoryDao, CommodityCategoryEntity> implements CommodityCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommodityCategoryEntity> page = this.page(
                new Query<CommodityCategoryEntity>().getPage(params),
                new QueryWrapper<CommodityCategoryEntity>()
        );

        return new PageUtils(page);
    }

}
