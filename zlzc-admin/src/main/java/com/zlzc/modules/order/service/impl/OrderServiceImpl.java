package com.zlzc.modules.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;

import com.zlzc.modules.order.dao.OrderDao;
import com.zlzc.modules.order.entity.OrderEntity;
import com.zlzc.modules.order.entity.vo.OrdeAndLogisticsVo;
import com.zlzc.modules.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("orderService")
@Slf4j
public class OrderServiceImpl  extends ServiceImpl<OrderDao,OrderEntity> implements OrderService{
    @Override
    public OrderEntity getDetails(String number) {
        OrderEntity orderEntity = null;
        try {
            QueryWrapper<OrderEntity> wq = new QueryWrapper<OrderEntity>();
            if(number!=null){
                 wq.eq("order_number", number);
            }
            orderEntity = this.getOne(wq);
        } catch (Exception e) {
            log.error("订单查询失败 唯一 返回多条数据");
        }
        return orderEntity;
    }


    @Override
    public PageUtils ListGetDetails(Map<String, Object> params, OrderEntity orderEntity) {

        //@formatter:off
        //QueryWrapper<OrderEntity> wq = new QueryWrapper<OrderEntity>();
                /*.eq(merchantApprovalDetails.getMerchantApprovalStatus() != null, "merchant_approval_status", merchantApprovalDetails.getMerchantApprovalStatus())
                .eq(StringUtils.isNotBlank(merchantApprovalDetails.getMerchantAuditors()), "merchant_auditors", merchantApprovalDetails.getMerchantAuditors())
                .like(StringUtils.isNotBlank(merchantApprovalDetails.getMerchantName()), "merchant_name", merchantApprovalDetails.getMerchantName())
                .like(StringUtils.isNotBlank(merchantApprovalDetails.getMerchantCompanyName()), "merchant_company_name", merchantApprovalDetails.getMerchantCompanyName())
                .groupBy("merchant_id");*/
        //@formatter:on
        IPage<OrderEntity> page =
                this.page(new Query<OrderEntity>().getPage(params),new QueryWrapper<OrderEntity>());
        return new PageUtils(page);
    }

}
