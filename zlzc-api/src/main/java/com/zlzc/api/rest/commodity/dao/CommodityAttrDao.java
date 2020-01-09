package com.zlzc.api.rest.commodity.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import com.zlzc.api.rest.commodity.entity.CommodityAttrEntity;
import com.zlzc.api.rest.commodity.vo.CommodityAttrPageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Mapper
public interface CommodityAttrDao extends BaseMapper<CommodityAttrEntity> {

	IPage<CommodityAttrPageVo> queryPage(IPage<CommodityAttrPageVo> page,
                                         @Param(Constants.WRAPPER) Wrapper<CommodityAttrPageVo> queryWrapper);

}
