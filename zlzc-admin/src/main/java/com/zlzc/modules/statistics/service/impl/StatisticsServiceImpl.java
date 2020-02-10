package com.zlzc.modules.statistics.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.modules.statistics.dao.StatisticsDao;
import com.zlzc.modules.statistics.entity.StatisticsEntityVo;
import com.zlzc.modules.statistics.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 功能描述:
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.statistics.service.impl
 * @ClassName: StatisticsServiceImpl
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2019/12/14 15:46
 * @Version: 1.0
 */
@Service("statisticsService")
public class StatisticsServiceImpl extends ServiceImpl<StatisticsDao, StatisticsEntityVo> implements StatisticsService {

    @Override
    public Map<String, Object> dayOrderTotal(Integer merchantId) {
        //@formatter:off
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        QueryWrapper<StatisticsEntityVo> wq = new QueryWrapper<StatisticsEntityVo>()
                .eq("o.merchant_id",merchantId)
                .ge("o.order_submission_time", dateFormat.format(new Date()) + " 00:00:00")
                .le("o.order_submission_time", dateFormat.format(new Date()) + " 23:59:59");
        //@formatter:on

        Map<String, Object> rsMap = baseMapper.dayOrderTotal(wq);

        return rsMap;
    }

    @Override
    public Map<String, Object> weekOrderTotal(Integer merchantId) {
        QueryWrapper<StatisticsEntityVo> wq = new QueryWrapper<StatisticsEntityVo>()
                .eq("o.merchant_id",merchantId);

        Map<String, Object> rsMap = baseMapper.weekOrderTotal(wq);

        return rsMap;
    }

    @Override
    public Map<String, Object> mothOrderTotal(Integer merchantId) {
        QueryWrapper<StatisticsEntityVo> wq = new QueryWrapper<StatisticsEntityVo>()
                .eq("o.merchant_id",merchantId);

        Map<String, Object> rsMap = baseMapper.mothOrderTotal(wq);

        return rsMap;
    }

    @Override
    public Map<String, Object> yearOrderTotal(Integer merchantId) {
        QueryWrapper<StatisticsEntityVo> wq = new QueryWrapper<StatisticsEntityVo>()
                .eq("o.merchant_id",merchantId);

        Map<String, Object> rsMap = baseMapper.yearOrderTotal(wq);

        return rsMap;
    }


    @Override
    public Map<String, Object> pendingTransactions(Integer merchantId) {
        QueryWrapper<StatisticsEntityVo> wq = new QueryWrapper<StatisticsEntityVo>()
                .eq("merchant.merchant_id",merchantId);
        //@formatter:on
         Map<String, Object> rsMap = baseMapper.pendingTransactions(wq);
        return rsMap;
    }


}
