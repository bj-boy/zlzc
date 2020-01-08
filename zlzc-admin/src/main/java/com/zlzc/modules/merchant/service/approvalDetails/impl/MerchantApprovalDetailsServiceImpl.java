package com.zlzc.modules.merchant.service.approvalDetails.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Query;
import com.zlzc.modules.merchant.dao.approvalDetails.MerchantApprovalDetailsDao;
import com.zlzc.modules.merchant.entity.approvalDetails.MerchantApprovalDetailsEntity;
import com.zlzc.modules.merchant.service.approvalDetails.MerchantApprovalDetailsService;
import com.zlzc.modules.merchant.vo.merchant.MerchantApprovalDetailsVo;

@Service("merchantApprovalDetailsService")
public class MerchantApprovalDetailsServiceImpl
		extends ServiceImpl<MerchantApprovalDetailsDao, MerchantApprovalDetailsEntity>
		implements MerchantApprovalDetailsService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<MerchantApprovalDetailsEntity> page = this.page(
				new Query<MerchantApprovalDetailsEntity>().getPage(params),
				new QueryWrapper<MerchantApprovalDetailsEntity>());
		return new PageUtils(page);
	}

	@Override
	public List<MerchantApprovalDetailsVo> queryApprovalDetails(Serializable merchantId) {
		//@formatter:off
		QueryWrapper<MerchantApprovalDetailsVo> wq = new QueryWrapper<MerchantApprovalDetailsVo>()
				.eq(StringUtils.isNotBlank((String) merchantId), "md.merchant_id", merchantId)
				.orderByDesc("update_time");
		//@formatter:on
		List<MerchantApprovalDetailsVo> detailsList = baseMapper.queryApprovalDetails(wq);
		return detailsList;
	}

	@Override
	public PageUtils queryPageByCondition(Map<String, Object> params,
			MerchantApprovalDetailsVo merchantApprovalDetails) {
		//@formatter:off
		QueryWrapper<MerchantApprovalDetailsVo> wq = new QueryWrapper<MerchantApprovalDetailsVo>()
				.eq(merchantApprovalDetails.getMerchantApprovalStatus() != null, "merchant_approval_status", merchantApprovalDetails.getMerchantApprovalStatus())
				.eq(StringUtils.isNotBlank(merchantApprovalDetails.getMerchantAuditors()), "merchant_auditors", merchantApprovalDetails.getMerchantAuditors())
				.like(StringUtils.isNotBlank(merchantApprovalDetails.getMerchantName()), "merchant_name", merchantApprovalDetails.getMerchantName())
				.like(StringUtils.isNotBlank(merchantApprovalDetails.getMerchantCompanyName()), "merchant_company_name", merchantApprovalDetails.getMerchantCompanyName())
				.groupBy("merchant_id");
		//@formatter:on

		IPage<MerchantApprovalDetailsVo> page = baseMapper
				.queryPageByCondition(new Query<MerchantApprovalDetailsVo>().getPage(params), wq);
		return new PageUtils(page);
	}

}
