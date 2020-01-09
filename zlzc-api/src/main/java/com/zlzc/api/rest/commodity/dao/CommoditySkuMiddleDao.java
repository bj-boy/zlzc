package com.zlzc.api.rest.commodity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.api.rest.commodity.entity.*;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品-SKU-中间表
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-17 15:53:14
 */
@Mapper
public interface CommoditySkuMiddleDao extends BaseMapper<CommoditySkuMiddleEntity> {
	
}
