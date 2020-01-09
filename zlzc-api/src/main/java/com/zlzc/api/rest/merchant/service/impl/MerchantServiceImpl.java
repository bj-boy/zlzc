package com.zlzc.api.rest.merchant.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.api.rest.merchant.dao.MerchantDao;
import com.zlzc.api.rest.merchant.entity.MerchantEntity;
import com.zlzc.api.rest.merchant.service.MerchantService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("merchantService")
public class MerchantServiceImpl extends ServiceImpl<MerchantDao, MerchantEntity> implements MerchantService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<MerchantEntity> page = this.page(new Query<MerchantEntity>().getPage(params),
				new QueryWrapper<MerchantEntity>());
		return new PageUtils(page);
	}

	@Override
	public PageUtils queryPageByCondition(Map<String, Object> params, MerchantEntity merchant) {

		return new PageUtils(new Page<>());
	}

}