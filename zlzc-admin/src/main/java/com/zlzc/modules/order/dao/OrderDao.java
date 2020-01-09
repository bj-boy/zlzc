package com.zlzc.modules.order.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.commodity.entity.CommodityEntity;
import com.zlzc.modules.merchant.vo.merchant.MerchantApprovalDetailsVo;
import com.zlzc.modules.order.entity.OrderEntity;
import com.zlzc.modules.order.entity.vo.OrderDetailsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {

    CommodityEntity selectOne(QueryWrapper<CommodityEntity> wq);

    IPage<OrderDetailsVo> queryPageByCondition(IPage<OrderDetailsVo> page,
                                               @Param(Constants.WRAPPER) Wrapper<OrderDetailsVo> queryWrapper);

    public OrderDetailsVo queryApprovalDetails(
            @Param(Constants.WRAPPER) Wrapper<OrderDetailsVo> queryWrapper);

}