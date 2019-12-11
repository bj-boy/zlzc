package com.zlzc.modules.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.order.dao.OrdeAndLogisticsDao;
import com.zlzc.modules.order.entity.OrderEntity;
import com.zlzc.modules.order.service.OrdeAndLogisticsService;
import com.zlzc.modules.order.entity.vo.OrdeAndLogisticsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("ordeAndLogisticsService")
@Slf4j
public class OrdeAndLogisticsServiceImpl extends ServiceImpl<OrdeAndLogisticsDao,OrdeAndLogisticsVo> implements OrdeAndLogisticsService {


    @Override
    public PageUtils ListGetDetails(Map<String, Object> params, OrdeAndLogisticsVo ordeAndLogisticsVo) {


        QueryWrapper<OrdeAndLogisticsVo> wq = new QueryWrapper<OrdeAndLogisticsVo>()
                .eq(ordeAndLogisticsVo.getOrderEntity().getOrderNumber()!=null||ordeAndLogisticsVo.getOrderEntity().getOrderNumber()!="","o.order_number",ordeAndLogisticsVo.getOrderEntity().getOrderNumber());

                /*.eq(StringUtils.isNotBlank(me+rchantApprovalDetails.getMerchantAuditors()), "merchant_auditors", merchantApprovalDetails.getMerchantAuditors())
                .like(StringUtils.isNotBlank(merchantApprovalDetails.getMerchantName()), "merchant_name", merchantApprovalDetails.getMerchantName())
                .like(StringUtils.isNotBlank(merchantApprovalDetails.getMerchantCompanyName()), "merchant_company_name", merchantApprovalDetails.getMerchantCompanyName())
                .groupBy("merchant_id");*/

        IPage<OrdeAndLogisticsVo> page =
                baseMapper.queryPageByCondition(new Query<OrdeAndLogisticsVo>().getPage(params), wq);

        return new PageUtils(page);
    }

    @Override
    public OrdeAndLogisticsVo getOrdeAndLogisticsVoDetails(String id) {

        QueryWrapper<OrdeAndLogisticsVo> wq = new QueryWrapper<OrdeAndLogisticsVo>().eq("order_id", id);
        OrdeAndLogisticsVo ordeAndLogisticsVo = baseMapper.queryApprovalDetails(wq);
        return ordeAndLogisticsVo;
    }
}
