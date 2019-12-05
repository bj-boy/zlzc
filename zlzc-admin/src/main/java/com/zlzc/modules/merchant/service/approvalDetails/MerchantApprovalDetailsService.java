package com.zlzc.modules.merchant.service.approvalDetails;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.modules.merchant.entity.approvalDetails.MerchantApprovalDetailsEntity;
import com.zlzc.modules.merchant.vo.merchant.MerchantApprovalDetailsVo;

/**
 * 商户审核详情表
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-04 16:52:38
 */
public interface MerchantApprovalDetailsService extends IService<MerchantApprovalDetailsEntity> {
	PageUtils queryPage(Map<String, Object> params);

	List<MerchantApprovalDetailsVo> queryApprovalDetails(Serializable merchntId);
}
