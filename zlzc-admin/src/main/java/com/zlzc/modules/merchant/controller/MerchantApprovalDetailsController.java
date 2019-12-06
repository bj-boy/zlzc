package com.zlzc.modules.merchant.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zlzc.common.config.swagger.ApiJsonObject;
import com.zlzc.common.config.swagger.ApiJsonProperty;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.merchant.entity.approvalDetails.MerchantApprovalDetailsEntity;
import com.zlzc.modules.merchant.service.approvalDetails.MerchantApprovalDetailsService;
import com.zlzc.modules.merchant.vo.merchant.MerchantApprovalDetailsVo;
import com.zlzc.modules.merchant.vo.merchant.MerchantApprovalVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

/**
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-11-30 14:01:13
 */
@Api(value = "后台-商户", tags = { "V1.0 merchantApprovalDetails：后台-商户审核详情操作相关接口" })
@RestController
@RequestMapping("merchantApprovalDetails")
public class MerchantApprovalDetailsController {

	@Autowired
	private MerchantApprovalDetailsService merchantApprovalDetailsService;

	/**
	 * 查询指定商户的审核详情
	 */
	@ApiOperation(value = "merchantApprovalDetails-1 查询指定商户的审核详情")
	@PostMapping("/merchntApprovalDetails/{merchntId}")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(name = "merchntId", value = "商户ID", defaultValue = "1", paramType = "path"),
		}
	)
	//@formatter:on
	public Result merchntApprovalDetails(@PathVariable("merchntId") String merchntId) {
		List<MerchantApprovalDetailsVo> queryApprovalDetailes = merchantApprovalDetailsService
				.queryApprovalDetails(merchntId);

		return Result.ok().put("approvalDetailes", queryApprovalDetailes);
	}

	/**
	 * 根据条件查询商户审核详情列表(分页)
	 */
	@ApiOperation(value = "merchantApprovalDetails-2 根据筛选条件获取商户审核详情列表（可分页）")
	@PostMapping("/listByCondition")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
		}
	)
	//@formatter:on
	public Result listByCondition(@ApiParam(hidden = true) @RequestParam Map<String, Object> params,
			@RequestBody MerchantApprovalDetailsVo merchantApprovalDetails) {
		PageUtils page = merchantApprovalDetailsService.queryPageByCondition(params, merchantApprovalDetails);
		return Result.ok().put("page", page);
	}

	/**
	 * 商户审核接口
	 */
	@ApiOperation(value = "merchantApprovalDetails-3 提交审核结果")
	@PostMapping("/approval")
	public Result approval(@RequestBody MerchantApprovalVo approvalVo) {
		//@formatter:off
		MerchantApprovalDetailsEntity approvalDetailsEntity = new MerchantApprovalDetailsEntity()
			.setCreateTime(new Date())
			.setUpdateTime(new Date())
			.setMerchantDate(approvalVo.getMerchantApprovalStatus() == 2 ? new Date() : null)
			.setMerchantAuditors("admin")
			.setOperator("admin")
			.setMerchantId(approvalVo.getMerchantId())
			.setMerchantApprovalStatus(approvalVo.getMerchantApprovalStatus())
			.setMerchantFeedback(approvalVo.getMerchantFeedback());
		//@formatter:on

		merchantApprovalDetailsService.save(approvalDetailsEntity);
		return Result.ok();
	}

}
