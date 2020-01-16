package com.zlzc.api.rest.content.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.api.rest.content.dao.ContentLnformationDao;
import com.zlzc.api.rest.content.entity.ContentCommentEntity;
import com.zlzc.api.rest.content.entity.ContentLnformationEntity;
import com.zlzc.api.rest.content.service.ContentLnformationService;
import com.zlzc.api.rest.content.vo.ContentLnformationVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;


@Service("contentLnformationService")
public class ContentLnformationServiceImpl extends ServiceImpl<ContentLnformationDao, ContentLnformationEntity> implements ContentLnformationService {

    @Override
    public List<ContentLnformationEntity> getInformationService() {
        QueryWrapper<ContentLnformationEntity> queryWrapper = new QueryWrapper<ContentLnformationEntity>()
                .orderByDesc("Information_time");
        List<ContentLnformationEntity> contentLnformationEntities = baseMapper.selectList(queryWrapper);

        return contentLnformationEntities;
    }

    @Override
    public List<ContentLnformationVo> getInformationCommodityByIdService(Long informationId) {
        QueryWrapper<ContentLnformationVo> qw = new QueryWrapper<ContentLnformationVo>()
                .eq("p.sales_model",1)
                .eq("l.Information_id",informationId);
        List<ContentLnformationVo> informationCommodityById = baseMapper.getInformationCommodityById(qw);
        return informationCommodityById;
    }

    @Override
    public List<ContentLnformationVo> getInformationContentById(Long informationId) {
        QueryWrapper<ContentLnformationVo> qw = new QueryWrapper<ContentLnformationVo>()
                .eq("l.Information_id",informationId);
        List<ContentLnformationVo> informationContentById = baseMapper.getInformationContentById(qw);
        return informationContentById;
    }

    @Override
    public List<ContentLnformationEntity> getInformationSearchFor(String InformationTitle) {
        QueryWrapper<ContentLnformationEntity> qw = new QueryWrapper<ContentLnformationEntity>()
                .like("Information_title",InformationTitle);
        List<ContentLnformationEntity> contentLnformationEntities = baseMapper.selectList(qw);
        return contentLnformationEntities;
    }


}
