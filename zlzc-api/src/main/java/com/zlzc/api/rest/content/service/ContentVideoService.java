package com.zlzc.api.rest.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.content.entity.ContentVideoEntity;
import com.zlzc.api.rest.content.vo.VideoVo;
import com.zlzc.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 视频表
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
public interface ContentVideoService extends IService<ContentVideoEntity> {

   public List<ContentVideoEntity> getVideoList();

   public List<VideoVo> getVideoCommodityById(Long videoId);

   public List<VideoVo> getVideoContentById(Long videoId);

   public List<ContentVideoEntity>  getVideoSearchFor(String videoTitle);

}

