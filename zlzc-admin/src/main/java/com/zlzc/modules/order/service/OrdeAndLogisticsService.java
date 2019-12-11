package com.zlzc.modules.order.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.order.entity.vo.OrdeAndLogisticsVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface OrdeAndLogisticsService  extends IService<OrdeAndLogisticsVo> {

    public PageUtils ListGetDetails(Map<String, Object> params, OrdeAndLogisticsVo ordeAndLogisticsVo);

    public OrdeAndLogisticsVo getOrdeAndLogisticsVoDetails(@Param("id") String id);
}
