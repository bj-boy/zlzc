package com.zlzc.api.rest.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.api.rest.commodity.entity.*;

import java.util.Map;

/**
 * 
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
public interface CommodityParamService extends IService<CommodityParamEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

