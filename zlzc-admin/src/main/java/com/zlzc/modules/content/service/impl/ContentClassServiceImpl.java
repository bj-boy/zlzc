package com.zlzc.modules.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.modules.content.dao.ContentClassDao;
import com.zlzc.modules.content.entity.ContentClassEntity;
import com.zlzc.modules.content.service.ContentClassService;
import org.springframework.stereotype.Service;


@Service("contentClassService")
public class ContentClassServiceImpl extends ServiceImpl<ContentClassDao, ContentClassEntity> implements ContentClassService {



}
