package com.zlzc.modules.order.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.modules.commodity.entity.CommodityEntity;
import com.zlzc.modules.order.entity.OrderEntity;
import com.zlzc.modules.order.entity.vo.OrderDetailsVo;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {

    CommodityEntity selectOne(QueryWrapper<CommodityEntity> wq);

    IPage<OrderDetailsVo> queryPageByCondition(IPage<OrderDetailsVo> page,
                                               @Param(Constants.WRAPPER) Wrapper<OrderDetailsVo> queryWrapper);

    public OrderDetailsVo queryApprovalDetails(
            @Param(Constants.WRAPPER) Wrapper<OrderDetailsVo> queryWrapper);

	Map<String, Object> statisticsByUserId(Long userId);

}
