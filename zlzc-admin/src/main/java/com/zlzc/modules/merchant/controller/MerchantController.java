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
import io.swagger.annotations.ApiOperation;

/**
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-11-30 14:01:13
 */
@Api(value = "后台-商户", tags = { "1.0 后台-商户操作相关接口" })
@RestController
@RequestMapping("merchant/merchant")
public class MerchantController {
	@Autowired
	private MerchantService merchantService;

	/**
	 * 列表
	 */
	@ApiOperation(value = "1-1 获取商户列表（可分页）")
	@GetMapping("/list")
	public Result list(@RequestParam Map<String, Object> params) {
		PageUtils page = merchantService.queryPage(params);
		
		return Result.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@ApiOperation(value = "1-2 根据商户ID获取商户信息")
	@GetMapping("/info/{merchntId}")
	public Result info(@PathVariable("merchntId") String merchntId) {
		MerchantEntity merchant = merchantService.getById(merchntId);

		return Result.ok().put("merchant", merchant);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "1-3 添加商户")
	@PostMapping("/save")
	public Result save(@RequestBody MerchantEntity merchant) {
		merchantService.save(merchant);

		return Result.ok();
	}

	/**
	 * 修改
	 */
	@ApiOperation(value = "1-4 修改商户信息")
	@PutMapping("/update")
	public Result update(@RequestBody MerchantEntity merchant) {
		ValidatorUtils.validateEntity(merchant);
		merchantService.updateById(merchant);

		return Result.ok();
	}

	/**
	 * 删除
	 */
	@ApiOperation(value = "1-5 删除指定ID的商户")
	@DeleteMapping("/delete")
	public Result delete(@RequestBody String[] merchntIds) {
		merchantService.removeByIds(Arrays.asList(merchntIds));

		return Result.ok();
	}

}
