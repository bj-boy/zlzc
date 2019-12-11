package com.zlzc.modules.logistics.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.modules.logistics.dao.LogisticsDao;
import com.zlzc.modules.logistics.entity.LogisticsEntity;
import com.zlzc.modules.logistics.service.LogisticsService;
import com.zlzc.modules.order.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("logisticsService")
@Slf4j
public class LogisticsServiceImpl extends ServiceImpl<LogisticsDao,LogisticsEntity> implements LogisticsService {

    @Override
    public LogisticsEntity getLogistics(String number) {
        LogisticsEntity logisticsEntity=null;
        try {
            QueryWrapper<LogisticsEntity> wq = new QueryWrapper<LogisticsEntity>()
                    .eq("logistics_single_number",number);
             logisticsEntity = this.getOne(wq);
        } catch (Exception e) {
            log.error("订单查询失败 唯一 返回多条数据");
        }

        return logisticsEntity;
    }
}
