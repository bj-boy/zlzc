package com.zlzc.api.rest.logistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.logistics.entity.LogisticsEntity;

public interface LogisticsService  extends IService<LogisticsEntity> {

    public LogisticsEntity getLogistics(String number);
}
