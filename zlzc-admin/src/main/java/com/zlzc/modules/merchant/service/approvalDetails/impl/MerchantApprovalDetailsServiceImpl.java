package com.zlzc.modules.merchant.service.approvalDetails.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
	public List<MerchantApprovalDetailsVo> queryApprovalDetails(Serializable merchntId) {
		QueryWrapper<MerchantApprovalDetailsVo> wq = new QueryWrapper<MerchantApprovalDetailsVo>()
				.orderByDesc("update_time");
		List<MerchantApprovalDetailsVo> detailsList = baseMapper.queryApprovalDetails(wq);
		return detailsList;
	}

}
