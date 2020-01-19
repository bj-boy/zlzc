package com.zlzc.modules.content.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.modules.content.entity.ContentVideoEntity;
import com.zlzc.modules.content.vo.VideoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 视频表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Mapper
public interface ContentVideoDao extends BaseMapper<ContentVideoEntity> {

    public List<VideoVo> getVideoCommodityById(@Param(Constants.WRAPPER)
                                                       Wrapper<VideoVo> queryWrapper);

    public List<VideoVo> getVideoContentById(@Param(Constants.WRAPPER)
                                                     Wrapper<VideoVo> queryWrapper);

}
