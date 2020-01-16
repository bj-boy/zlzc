package com.zlzc.api.rest.commodity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.api.rest.commodity.entity.CommodityEntity;
import com.zlzc.api.rest.commodity.vo.CommodityVo;
import org.apache.ibatis.annotations.Mapper;

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

	List<CommodityVo> queryCommodity();

}
