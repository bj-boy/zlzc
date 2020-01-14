package com.zlzc.api.rest.content.service.impl;

import com.zlzc.api.rest.content.dao.ContentClassDao;
import com.zlzc.api.rest.content.entity.ContentClassEntity;
import com.zlzc.api.rest.content.service.ContentClassService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;


@Service("contentClassService")
public class ContentClassServiceImpl extends ServiceImpl<ContentClassDao, ContentClassEntity> implements ContentClassService {



}
