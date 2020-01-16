package com.zlzc.api.rest.commodity.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.api.rest.commodity.entity.CommodityEntity;
import com.zlzc.api.rest.commodity.entity.CommodityRecommendEntity;
import com.zlzc.api.rest.commodity.vo.CommodityRecommendVo;
import com.zlzc.api.rest.order.entity.vo.OrderDetailsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 商品-推荐
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-17 15:53:14
 */
@Mapper
public interface CommodityRecommendDao extends BaseMapper<CommodityRecommendVo> {

    List<CommodityRecommendVo> getByStatus( @Param(Constants.WRAPPER) Wrapper<CommodityRecommendVo> queryWrapper);
}
