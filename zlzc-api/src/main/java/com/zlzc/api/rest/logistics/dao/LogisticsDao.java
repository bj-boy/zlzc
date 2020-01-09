package com.zlzc.api.rest.logistics.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.zlzc.api.rest.logistics.entity.LogisticsEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogisticsDao extends BaseMapper<LogisticsEntity> {
}
