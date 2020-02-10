package com.zlzc.modules.ad.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.ad.dao.AdDao;
import com.zlzc.modules.ad.entity.AdEntity;
import com.zlzc.modules.ad.service.AdService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public PageUtils queryPageShAd(Map<String, Object> params) {
        IPage<AdEntity> page = baseMapper.queryPageAd(new Query<AdEntity>().getPage(params));
        return new PageUtils(page);

    }

}
