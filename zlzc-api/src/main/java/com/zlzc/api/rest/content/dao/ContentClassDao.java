package com.zlzc.api.rest.content.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.api.rest.content.entity.ContentClassEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 视频资讯分类表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Mapper
public interface ContentClassDao extends BaseMapper<ContentClassEntity> {
	
}
