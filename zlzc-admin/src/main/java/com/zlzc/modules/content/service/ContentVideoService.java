package com.zlzc.modules.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.modules.content.entity.ContentVideoEntity;
import com.zlzc.modules.content.vo.VideoVo;

import java.util.List;

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

