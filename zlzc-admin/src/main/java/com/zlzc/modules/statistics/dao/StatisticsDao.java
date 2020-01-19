package com.zlzc.modules.statistics.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.modules.statistics.entity.StatisticsEntityVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 功能描述:
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.statistics.dao
 * @ClassName: StatisticsDao
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2019/12/14 15:39
 * @Version: 1.0
 */

@Mapper
public interface StatisticsDao extends BaseMapper<StatisticsEntityVo> {

    public Map<String, Object> dayOrderTotal(
            @Param(Constants.WRAPPER) Wrapper<StatisticsEntityVo> queryWrapper);

    public Map<String, Object> weekOrderTotal(
            @Param(Constants.WRAPPER) Wrapper<StatisticsEntityVo> queryWrapper);

    public Map<String,Object> pendingTransactions(
            @Param(Constants.WRAPPER) Wrapper<StatisticsEntityVo> queryWrapper);

    public Map<String,Object> mothOrderTotal(
            @Param(Constants.WRAPPER) Wrapper<StatisticsEntityVo> queryWrapper);

    public Map<String,Object> yearOrderTotal(
            @Param(Constants.WRAPPER) Wrapper<StatisticsEntityVo> queryWrapper);




}
