package com.zlzc.modules.merchant.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

	@Override
	public PageUtils queryPageByCondition(Map<String, Object> params, MerchantEntity merchant) {
		//@formatter:off
		LambdaQueryWrapper<MerchantEntity> qw = Wrappers.<MerchantEntity>lambdaQuery()
				.eq(StringUtils.isNotBlank(merchant.getMerchantAccount()), MerchantEntity::getMerchantAccount, merchant.getMerchantAccount())
				.eq(merchant.getMerchantSupplyLevel() != null, MerchantEntity::getMerchantSupplyLevel, merchant.getMerchantSupplyLevel())
				.eq(merchant.getMerchantScope() != null, MerchantEntity::getMerchantScope, merchant.getMerchantScope())
				.like(StringUtils.isNotBlank(merchant.getMerchantNick()), MerchantEntity::getMerchantNick, merchant.getMerchantNick())
				.like(StringUtils.isNotBlank(merchant.getMerchantName()), MerchantEntity::getMerchantName, merchant.getMerchantName())
				.like(StringUtils.isNotBlank(merchant.getMerchantCompanyName()), MerchantEntity::getMerchantCompanyName, merchant.getMerchantCompanyName())
				.like(StringUtils.isNotBlank(merchant.getMerchantLinkman()), MerchantEntity::getMerchantLinkman, merchant.getMerchantLinkman());
		//@formatter:on

		IPage<MerchantEntity> page = this.page(new Query<MerchantEntity>().getPage(params), qw);

		return new PageUtils(page);
	}

}
