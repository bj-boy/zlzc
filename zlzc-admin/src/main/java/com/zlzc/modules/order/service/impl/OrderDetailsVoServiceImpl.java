package com.zlzc.modules.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.CodeFactory;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.commodity.entity.CommodityEntity;
import com.zlzc.modules.commodity.entity.CommodityRepoEntity;
import com.zlzc.modules.commodity.service.CommodityRepoService;
import com.zlzc.modules.commodity.service.CommodityService;
import com.zlzc.modules.logistics.service.LogisticsService;
import com.zlzc.modules.order.dao.OrderDao;
import com.zlzc.modules.order.entity.OrderEntity;
import com.zlzc.modules.order.service.OrderDetailsVoService;
import com.zlzc.modules.order.entity.vo.OrderDetailsVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service("ordeAndLogisticsService")
@Slf4j
public class OrderDetailsVoServiceImpl extends ServiceImpl<OrderDao,OrderEntity> implements OrderDetailsVoService {

    @Autowired
    private LogisticsService logisticsService;
    @Autowired
    private CommodityRepoService  commodityRepoService;

    @Autowired
    private CommodityService commodityService;
    @Override
    public PageUtils ListGetDetails(Map<String, Object> params, OrderDetailsVo ordeAndLogisticsVo) {

        QueryWrapper<OrderDetailsVo> wq = new QueryWrapper<OrderDetailsVo>()
                //未删除
                .eq("o.order_remove",0)
                //订单号
                .eq(StringUtils.isNotBlank(ordeAndLogisticsVo.getOrderNumber()),
                        "o.order_number",ordeAndLogisticsVo.getOrderNumber())
                //提交时间
                .eq(ordeAndLogisticsVo.getOrderSubmissionTime()!=null,
                        "o.order_submission_time",ordeAndLogisticsVo.getOrderSubmissionTime())
                //订单状态
                .eq(ordeAndLogisticsVo.getOrderStatus()!=null,
                        "o.order_status",ordeAndLogisticsVo.getOrderStatus())
                //订单来源
                .eq(ordeAndLogisticsVo.getOrderSource()!=null,
                        "o.order_source",ordeAndLogisticsVo.getOrderStatus());
                if(ordeAndLogisticsVo!=null){
                    //收货人
                    if(Objects.nonNull(ordeAndLogisticsVo.getLogisticsEntity())){
                        wq.like("l.logistics_recipient",ordeAndLogisticsVo.getLogisticsEntity().getLogisticsRecipient());
                    }
                    //店铺名称
                    if(Objects.nonNull(ordeAndLogisticsVo.getLogisticsEntity())){
                        wq.like(Objects.nonNull(ordeAndLogisticsVo.getLogisticsEntity()),"s.shop_name",ordeAndLogisticsVo.getShopEntity().getShopName());
                    }
                }

        IPage<OrderDetailsVo> page =
                baseMapper.queryPageByCondition(new Query<OrderDetailsVo>().getPage(params), wq);

        return new PageUtils(page);
    }

    @Override
    public OrderDetailsVo getOrdeAndLogisticsVoDetails(String id) {
            OrderDetailsVo ordeAndLogisticsVo=null;

            if(!StringUtils.isNotBlank(id)){
                return new OrderDetailsVo();
            }
            QueryWrapper<OrderDetailsVo> wq= new QueryWrapper<OrderDetailsVo>();
            wq.eq(id!=null,"o.order_number", id)
                    .eq("o.order_remove", 0);

                ordeAndLogisticsVo = baseMapper.queryApprovalDetails(wq);

            if(Objects.isNull(ordeAndLogisticsVo)){
                QueryWrapper<OrderDetailsVo> wq1= new QueryWrapper<OrderDetailsVo>();
                wq1.eq(id!=null,"o.order_id", id)
                        .eq("o.order_remove", 0);
                ordeAndLogisticsVo = baseMapper.queryApprovalDetails(wq1);
            }
        return ordeAndLogisticsVo;
    }


    /**
     * 0 创建订单成功
     * 1 对象为空
     * 2 用户id 商品id 不能为空
     * 3 商品id 不存在
     * 4 库存不足
     * @param orderDetailsVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveOrder(OrderDetailsVo orderDetailsVo) {

            if (Objects.isNull(orderDetailsVo)) {
                return 1;
            }
            if (StringUtils.isBlank(orderDetailsVo.getUserId().toString())
                    || StringUtils.isBlank(orderDetailsVo.getCommobityId().toString())) {
                return 2;
            }

            String orderCode = new CodeFactory().getOrderCode(orderDetailsVo.getUserId());
            CommodityEntity commodityEntity=null;

            //商品判断
            if (StringUtils.isNotBlank(orderDetailsVo.getCommobityId().toString())) {

                QueryWrapper<CommodityEntity> wq = new QueryWrapper<CommodityEntity>()
                        .eq("commodity_id", orderDetailsVo.getCommobityId());
                commodityEntity = commodityService.getOne(wq);
                System.out.println(commodityEntity);
                orderDetailsVo.setMerchntId(commodityEntity.getMerchantId());
                orderDetailsVo.setShopId(commodityEntity.getShopId());
                orderDetailsVo.setOrderRemove(0);
            }else {
                return 3;
            }
            //查看商品库存
            QueryWrapper<CommodityRepoEntity> cwq = new QueryWrapper<CommodityRepoEntity>()
                    .eq("commodity_repertory_id",commodityEntity.getCommodityRepoId());
            CommodityRepoEntity one = commodityRepoService.getOne(cwq);
            if(one.getRepoStock()< 0){
                return 4;
            }

            orderDetailsVo.setOrderNumber(orderCode);
            orderDetailsVo.setOrderSubmissionTime(new Date());
            orderDetailsVo.getLogisticsEntity().setOrderNumber(orderCode);

            baseMapper.insert(orderDetailsVo);
            logisticsService.save(orderDetailsVo.getLogisticsEntity());

            return 0;
         }

    @Transactional
    @Override
    public boolean updateStatus(OrderDetailsVo orderDetailsVo) {

        if (Objects.isNull(orderDetailsVo)) {
            return false;
        }
        QueryWrapper<OrderEntity> cwq = new QueryWrapper<OrderEntity>()
                .eq("order_id",orderDetailsVo.getOrderId());
        OrderEntity orderEntity = baseMapper.selectOne(cwq);
        if(Objects.isNull(orderEntity)){
            return false;
        }
        //订单金额
        orderEntity.setOrderAmount(orderDetailsVo.getOrderAmount());
        //应付款金额
        orderEntity.setOrderPayable(orderDetailsVo.getOrderPayable());
        //支付状态
        orderEntity.setOrderPaymentStatus(orderDetailsVo.getOrderPaymentStatus());
        //支付方式
        orderEntity.setOrderPaymentMethod(orderDetailsVo.getOrderPaymentMethod());
        //订单来源
        orderEntity.setOrderSource(orderDetailsVo.getOrderSource());
        //订单状态
        orderEntity.setOrderStatus(orderDetailsVo.getOrderStatus());
        //订单类型
        orderEntity.setOrderOrderType(orderDetailsVo.getOrderOrderType());

        this.updateById(orderEntity);
        return true;
    }


    @Override
    public boolean removeStatus(List<String> strings) {

        for(int i=0;i<strings.size();i++){

            QueryWrapper<OrderEntity> cwq = new QueryWrapper<OrderEntity>()
                    .eq("order_id",strings.get(i));
            OrderEntity orderEntity = baseMapper.selectOne(cwq);
            if(Objects.nonNull(orderEntity)){
                orderEntity.setOrderRemove(1);
            }
            this.updateById(orderEntity);
        }
        return false;
    }
}
