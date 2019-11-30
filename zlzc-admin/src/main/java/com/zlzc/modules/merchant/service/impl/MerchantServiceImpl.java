package com.zlzc.modules.merchant.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.merchant.dao.MerchantDao;
import com.zlzc.modules.merchant.entity.MerchantEntity;
import com.zlzc.modules.merchant.service.MerchantService;

@Service("merchantService")
public class MerchantServiceImpl extends ServiceImpl<MerchantDao, MerchantEntity> implements MerchantService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<MerchantEntity> page = this.page(new Query<MerchantEntity>().getPage(params),
				new QueryWrapper<MerchantEntity>());
		return new PageUtils(page);
	}

}
