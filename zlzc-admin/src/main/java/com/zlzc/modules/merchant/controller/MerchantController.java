package com.zlzc.modules.merchant.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.common.validator.ValidatorUtils;
import com.zlzc.modules.merchant.entity.MerchantEntity;
import com.zlzc.modules.merchant.service.MerchantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-11-30 14:01:13
 */
@Api(value = "后台-商户", tags = { "V1.0 merchant：后台-商户操作相关接口" })
@RestController
@RequestMapping("merchant")
public class MerchantController {
	@Autowired
	private MerchantService merchantService;

	/**
	 * 根据条件查询商户列表(分页)
	 */
	@ApiOperation(value = "merchant-6 根据筛选条件获取商户列表（可分页）")
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
			@RequestBody MerchantEntity merchant) {
		PageUtils page = merchantService.queryPageByCondition(params, merchant);

		return Result.ok().put("page", page);
	}

	/**
	 * 列表
	 */
	@ApiOperation(value = "merchant-1 获取商户列表（可分页）")
	@GetMapping("/list")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
		}
	)
	//@formatter:on
	public Result list(@ApiParam(hidden = true) @RequestParam Map<String, Object> params) {
		PageUtils page = merchantService.queryPage(params);

		return Result.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@ApiOperation(value = "merchant-2 根据商户ID获取商户信息")
	@GetMapping("/info/{merchantId}")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(name = "merchantId", value = "商户ID", defaultValue = "1", paramType = "path"),
		}
	)
	//@formatter:on
	public Result info(@PathVariable("merchantId") String merchantId) {
		MerchantEntity merchant = merchantService.getById(merchantId);

		return Result.ok().put("merchant", merchant);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "merchant-3 添加商户")
	@PostMapping("/save")
	public Result save(@RequestBody MerchantEntity merchant) {
		merchantService.save(merchant);

		return Result.ok();
	}

	/**
	 * 修改
	 */
	@ApiOperation(value = "merchant-4 修改商户信息")
	@PutMapping("/update")
	public Result update(@RequestBody MerchantEntity merchant) {
		ValidatorUtils.validateEntity(merchant);
		merchantService.updateById(merchant);

		return Result.ok();
	}

	/**
	 * 删除
	 */
	@ApiOperation(value = "merchant-5 删除指定ID的商户")
	@DeleteMapping("/delete")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(
				name = "merchntIds", 
				value = "商户ID[]; [1,2,3]", 
				paramType = "body", 
				dataTypeClass = String.class, 
				allowMultiple = true
			)
		}
	)
	//@formatter:on
	public Result delete(@RequestBody String[] merchntIds) {
		merchantService.removeByIds(Arrays.asList(merchntIds));

		return Result.ok();
	}

}
