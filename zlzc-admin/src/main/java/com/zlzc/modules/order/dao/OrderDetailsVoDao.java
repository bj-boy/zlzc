package com.zlzc.modules.order.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.modules.order.entity.vo.OrderDetailsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDetailsVoDao extends BaseMapper<OrderDetailsVo>{

    IPage<OrderDetailsVo> queryPageByCondition(IPage<OrderDetailsVo> page,
                                               @Param(Constants.WRAPPER) Wrapper<OrderDetailsVo> queryWrapper);

    public OrderDetailsVo queryApprovalDetails(
            @Param(Constants.WRAPPER) Wrapper<OrderDetailsVo> queryWrapper);
}
