package com.zlzc.modules.commodity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.modules.commodity.entity.CommodityEntity;
import com.zlzc.modules.commodity.vo.CommodityVo;

/**
 * 
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Mapper
public interface CommodityDao extends BaseMapper<CommodityEntity> {

	List<CommodityVo> queryCommodity();

}
