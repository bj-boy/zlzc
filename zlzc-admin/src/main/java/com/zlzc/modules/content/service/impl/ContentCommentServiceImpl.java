package com.zlzc.modules.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.modules.content.dao.ContentCommentDao;
import com.zlzc.modules.content.entity.ContentCommentEntity;
import com.zlzc.modules.content.service.ContentCommentService;
import org.springframework.stereotype.Service;


@Service("contentCommentService")
public class ContentCommentServiceImpl extends ServiceImpl<ContentCommentDao, ContentCommentEntity> implements ContentCommentService {



}
