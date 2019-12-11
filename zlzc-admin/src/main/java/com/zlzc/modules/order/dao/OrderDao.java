package com.zlzc.modules.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.merchant.vo.merchant.MerchantApprovalDetailsVo;
import com.zlzc.modules.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {


}
