package com.zlzc.modules.commodity.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.modules.commodity.entity.CommodityEntity;
import com.zlzc.modules.commodity.vo.CommodityVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Mapper
public interface CommodityDao extends BaseMapper<CommodityEntity> {

	List<CommodityVo> queryCommodity(@Param(Constants.WRAPPER) Wrapper<CommodityVo> queryWrapper, @Param("current") long current, @Param("size") long size);

	Integer queryCommodityCnt(@Param(Constants.WRAPPER) Wrapper<CommodityVo> queryWrapper, @Param("current") long current, @Param("size") long size);



}
