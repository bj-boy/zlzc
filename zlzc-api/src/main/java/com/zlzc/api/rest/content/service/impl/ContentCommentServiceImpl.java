package com.zlzc.api.rest.content.service.impl;

import com.zlzc.api.rest.content.dao.ContentCommentDao;
import com.zlzc.api.rest.content.entity.ContentCommentEntity;
import com.zlzc.api.rest.content.service.ContentCommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;


@Service("contentCommentService")
public class ContentCommentServiceImpl extends ServiceImpl<ContentCommentDao, ContentCommentEntity> implements ContentCommentService {



}
