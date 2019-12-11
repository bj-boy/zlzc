package com.zlzc.modules.order.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.modules.merchant.vo.merchant.MerchantApprovalDetailsVo;
import com.zlzc.modules.order.entity.vo.OrdeAndLogisticsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrdeAndLogisticsDao extends BaseMapper<OrdeAndLogisticsVo>{

    IPage<OrdeAndLogisticsVo> queryPageByCondition(IPage<OrdeAndLogisticsVo> page,
                                                          @Param(Constants.WRAPPER) Wrapper<OrdeAndLogisticsVo> queryWrapper);

    public  OrdeAndLogisticsVo queryApprovalDetails(
            @Param(Constants.WRAPPER) Wrapper<OrdeAndLogisticsVo> queryWrapper);
}
