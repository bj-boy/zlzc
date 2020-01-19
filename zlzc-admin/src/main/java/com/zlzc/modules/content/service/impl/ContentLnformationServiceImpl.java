package com.zlzc.modules.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.content.dao.ContentClassDao;
import com.zlzc.modules.content.dao.ContentLnformationDao;
import com.zlzc.modules.content.entity.ContentLnformationEntity;
import com.zlzc.modules.content.service.ContentLnformationService;
import com.zlzc.modules.content.vo.ContentLnformationVo;
import com.zlzc.modules.content.vo.ContentlnSaveVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("contentLnformationService")
@Slf4j
public class ContentLnformationServiceImpl extends ServiceImpl<ContentLnformationDao, ContentLnformationEntity> implements ContentLnformationService {
    @Autowired
    private ContentClassDao contentClassDao;
    @Autowired
    private  ContentLnformationDao contentLnformationDao;
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

    @Override
    public PageUtils queryPageText(Map<String, Object> params) {
        IPage<ContentLnformationEntity> page = baseMapper.queryPageText(new Query<ContentLnformationEntity>().getPage(params));
        return new PageUtils(page);
    }

    @Override
    @Transactional
    public boolean  saveText(ContentlnSaveVo contentlnSaveVo) {
        try{

            contentLnformationDao.insert(contentlnSaveVo.getContentLnformationEntity());
            contentClassDao.insert(contentlnSaveVo.getContentClassEntity());
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return  false;
        }
        return true;
    }


}
