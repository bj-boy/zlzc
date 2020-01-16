package com.zlzc.modules.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.order.dao.OrderDao;
import com.zlzc.modules.order.entity.OrderEntity;
import com.zlzc.modules.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("orderService")
@Slf4j
public class OrderServiceImpl  extends ServiceImpl<OrderDao,OrderEntity> implements OrderService{




       /* SortedSet s = Collections.synchronizedSortedSet(new TreeSet());
        Long l=1L;
        for(int i=1;i<=1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=1; j<=1000; j++) {
                        try {
                            Thread.sleep(1L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        System.out.println(Thread.currentThread().getName() + " ----> " + new OrderCodeFactory().getOrderCode(new Long((long)j)));

                        s.add(new OrderCodeFactory().getOrderCode(new Long((long)j)));
                    }
                }
            }).start();
        }


        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(s.size());
*/


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
