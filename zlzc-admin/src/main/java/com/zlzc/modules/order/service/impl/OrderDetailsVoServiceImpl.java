package com.zlzc.modules.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.order.dao.OrderDetailsVoDao;
import com.zlzc.modules.order.service.OrderDetailsVoService;
import com.zlzc.modules.order.entity.vo.OrderDetailsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("ordeAndLogisticsService")
@Slf4j
public class OrderDetailsVoServiceImpl extends ServiceImpl<OrderDetailsVoDao,OrderDetailsVo> implements OrderDetailsVoService {


    @Override
    public PageUtils ListGetDetails(Map<String, Object> params, OrderDetailsVo ordeAndLogisticsVo) {


        QueryWrapper<OrderDetailsVo> wq = new QueryWrapper<OrderDetailsVo>()
                .eq(ordeAndLogisticsVo.getOrderEntity().getOrderNumber()!=null||ordeAndLogisticsVo.getOrderEntity().getOrderNumber()!="","o.order_number",ordeAndLogisticsVo.getOrderEntity().getOrderNumber());

                /*.eq(StringUtils.isNotBlank(me+rchantApprovalDetails.getMerchantAuditors()), "merchant_auditors", merchantApprovalDetails.getMerchantAuditors())
                .like(StringUtils.isNotBlank(merchantApprovalDetails.getMerchantName()), "merchant_name", merchantApprovalDetails.getMerchantName())
                .like(StringUtils.isNotBlank(merchantApprovalDetails.getMerchantCompanyName()), "merchant_company_name", merchantApprovalDetails.getMerchantCompanyName())
                .groupBy("merchant_id");*/

        IPage<OrderDetailsVo> page =
                baseMapper.queryPageByCondition(new Query<OrderDetailsVo>().getPage(params), wq);

        return new PageUtils(page);
    }

    @Override
    public OrderDetailsVo getOrdeAndLogisticsVoDetails(String id) {

        QueryWrapper<OrderDetailsVo> wq = new QueryWrapper<OrderDetailsVo>().eq("order_id", id);
        OrderDetailsVo ordeAndLogisticsVo = baseMapper.queryApprovalDetails(wq);
        return ordeAndLogisticsVo;
    }
}
