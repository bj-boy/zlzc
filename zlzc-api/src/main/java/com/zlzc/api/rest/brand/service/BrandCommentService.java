package com.zlzc.api.rest.brand.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.brand.entity.BrandCommentEntity;
import com.zlzc.common.utils.PageUtils;
import java.util.Map;

/**
 * 
 *
 * @author Admin
 * @email zlzc@example.com
 * @date 2020-01-11 18:03:44
 */
public interface BrandCommentService extends IService<BrandCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

