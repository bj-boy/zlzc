package com.zlzc.api.rest.brand.service.impl;

import com.zlzc.api.rest.brand.dao.BrandCommentDao;
import com.zlzc.api.rest.brand.entity.BrandCommentEntity;
import com.zlzc.api.rest.brand.service.BrandCommentService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;


@Service("brandCommentService")
public class BrandCommentServiceImpl extends ServiceImpl<BrandCommentDao, BrandCommentEntity> implements BrandCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BrandCommentEntity> page = this.page(
                new Query<BrandCommentEntity>().getPage(params),
                new QueryWrapper<BrandCommentEntity>()
        );

        return new PageUtils(page);
    }

}
