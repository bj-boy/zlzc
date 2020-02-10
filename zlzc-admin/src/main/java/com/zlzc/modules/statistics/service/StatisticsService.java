package com.zlzc.modules.statistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.modules.statistics.entity.StatisticsEntityVo;

import java.util.Map;

/**
 * 功能描述:
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.statistics.service
 * @ClassName: StatisticsService
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2019/12/14 15:40
 * @Version: 1.0
 */
public interface StatisticsService extends IService<StatisticsEntityVo> {
  Map<String, Object> dayOrderTotal(Integer merchantId);
  Map<String, Object> weekOrderTotal(Integer merchantId);
  Map<String, Object> mothOrderTotal(Integer merchantId);
  Map<String, Object> yearOrderTotal(Integer merchantId);
  Map<String,Object> pendingTransactions(Integer merchantId);
}
