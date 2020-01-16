package com.zlzc.api.rest.ad.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.api.rest.ad.dao.AdDao;
import com.zlzc.api.rest.ad.entity.AdEntity;
import com.zlzc.api.rest.ad.service.AdService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

@Service("adService")
public class AdServiceImpl extends ServiceImpl<AdDao, AdEntity> implements AdService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AdEntity> page = this.page(
                new Query<AdEntity>().getPage(params),
                new QueryWrapper<AdEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<AdEntity> getAdCarouselService(Integer position) {
        QueryWrapper<AdEntity> queryWrapper=new QueryWrapper<AdEntity>()
                .eq("ad_position",position);

        List<AdEntity> adEntities = baseMapper.selectList(queryWrapper);

        return adEntities;
    }

}
