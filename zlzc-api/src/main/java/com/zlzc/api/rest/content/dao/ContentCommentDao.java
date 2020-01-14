package com.zlzc.api.rest.content.dao;

import com.zlzc.api.rest.content.entity.ContentCommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 视频资讯评论表
 * 
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:45
 */
@Mapper
public interface ContentCommentDao extends BaseMapper<ContentCommentEntity> {
	
}
