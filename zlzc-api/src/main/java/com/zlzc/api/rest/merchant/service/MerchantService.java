package com.zlzc.api.rest.merchant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.api.rest.merchant.entity.MerchantEntity;
import com.zlzc.common.utils.PageUtils;
import java.util.Map;
/**
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-11-30 14:01:13
 */
public interface MerchantService extends IService<MerchantEntity> {

	PageUtils queryPageByCondition(Map<String, Object> params, MerchantEntity merchant);

	PageUtils queryPage(Map<String, Object> params);
}
