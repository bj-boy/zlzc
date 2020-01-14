package com.zlzc.api.rest.content.service.impl;

import com.zlzc.api.rest.content.dao.ContentVideoDao;
import com.zlzc.api.rest.content.entity.ContentLnformationEntity;
import com.zlzc.api.rest.content.entity.ContentVideoEntity;
import com.zlzc.api.rest.content.service.ContentVideoService;
import com.zlzc.api.rest.content.vo.VideoVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

@Service("contentVideoService")
public class ContentVideoServiceImpl extends ServiceImpl<ContentVideoDao, ContentVideoEntity> implements ContentVideoService {


    @Override
    public List<ContentVideoEntity> getVideoList() {
        QueryWrapper<ContentVideoEntity> queryWrapper = new QueryWrapper<ContentVideoEntity>()
                .orderByDesc("video_time");

        List<ContentVideoEntity> contentVideoEntities = baseMapper.selectList(queryWrapper);

        return contentVideoEntities;
    }

    @Override
    public List<VideoVo> getVideoCommodityById(Long videoId) {
        QueryWrapper<VideoVo> queryWrapper = new QueryWrapper<VideoVo>()
                .eq("p.sales_model",1)
                .eq("v.video_id",videoId);
        List<VideoVo> videoCommodityById = baseMapper.getVideoCommodityById(queryWrapper);
        return videoCommodityById;
    }

    @Override
    public List<VideoVo> getVideoContentById(Long videoId) {
        QueryWrapper<VideoVo> qw = new QueryWrapper<VideoVo>()
                .eq("v.video_id",videoId);

        List<VideoVo> videoContentById = baseMapper.getVideoContentById(qw);
        return videoContentById;
    }

    @Override
    public List<ContentVideoEntity> getVideoSearchFor(String videoTitle) {
        QueryWrapper<ContentVideoEntity> qw = new QueryWrapper<ContentVideoEntity>()
                .like("video_title",videoTitle);
        List<ContentVideoEntity> contentVideoEntities = baseMapper.selectList(qw);
        return contentVideoEntities;
    }
}
