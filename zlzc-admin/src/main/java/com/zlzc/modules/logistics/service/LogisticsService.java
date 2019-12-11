package com.zlzc.modules.logistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.modules.logistics.entity.LogisticsEntity;

public interface LogisticsService  extends IService<LogisticsEntity> {

    public LogisticsEntity getLogistics(String number);
}
