package com.zlzc.modules.merchant.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.merchant.entity.MerchantEntity;

/**
 * 
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-11-30 14:01:13
 */
public interface MerchantService extends IService<MerchantEntity> {
	PageUtils queryPageByCondition(Map<String, Object> params, MerchantEntity merchant);

	PageUtils queryPage(Map<String, Object> params);
}
