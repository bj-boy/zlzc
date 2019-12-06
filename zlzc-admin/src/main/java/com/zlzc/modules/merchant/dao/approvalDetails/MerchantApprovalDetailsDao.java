package com.zlzc.modules.merchant.dao.approvalDetails;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zlzc.modules.merchant.entity.approvalDetails.MerchantApprovalDetailsEntity;
import com.zlzc.modules.merchant.vo.merchant.MerchantApprovalDetailsVo;

/**
 * 商户审核详情表
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-04 16:52:38
 */
@Mapper
public interface MerchantApprovalDetailsDao extends BaseMapper<MerchantApprovalDetailsEntity> {

	List<MerchantApprovalDetailsVo> queryApprovalDetails(
			@Param(Constants.WRAPPER) Wrapper<MerchantApprovalDetailsVo> queryWrapper);

	IPage<MerchantApprovalDetailsVo> queryPageByCondition(IPage<MerchantApprovalDetailsVo> page,
			@Param(Constants.WRAPPER) Wrapper<MerchantApprovalDetailsVo> queryWrapper);

}
