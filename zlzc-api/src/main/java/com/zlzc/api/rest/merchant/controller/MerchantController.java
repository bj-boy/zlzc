package com.zlzc.api.rest.merchant.controller;

import com.zlzc.api.rest.merchant.entity.MerchantEntity;
import com.zlzc.api.rest.merchant.service.MerchantService;
import com.zlzc.common.utils.PageUtils;
import com.zlzc.common.utils.Result;
import com.zlzc.common.validator.ValidatorUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-11-30 14:01:13
 */
@Api(value = "app-商户", tags = { "V1.0 merchant：app-商户操作相关接口" })
@RestController
@RequestMapping("app/merchant")
public class MerchantController {
	@Autowired
	private MerchantService merchantService;

	/**
	 * 根据条件查询商户列表(分页)
	 */
	/*@ApiResponses(value = {
		@ApiResponse(response = MerchantEntity.class, code = 200, message = "商户列表响应字段说明")
	})	
	@ApiOperation(value = "merchant-6 根据筛选条件获取商户列表（可分页）")
	@PostMapping("/listByCondition")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
		}
	)*/
	public Result listByCondition(@ApiParam(hidden = true) @RequestParam Map<String, Object> params,
			// 自定义requestbody描述，使用map作为参数
//			@ApiJsonObject(
//				name = "merchant",
//				value = {
//					@ApiJsonProperty(key = "merchantName", example = "张三", description = "商户名")
//				}
//			)
//			MerchantEntity merchant = JSONObject.parseObject(JSONObject.toJSONString(paramMap), MerchantEntity.class);
			@RequestBody MerchantEntity merchant) {
	//@formatter:on
		PageUtils page = merchantService.queryPageByCondition(params, merchant);

		return Result.ok().put("page", page);
	}

	/**
	 * 列表

	@ApiResponses(value = {
		@ApiResponse(response = MerchantEntity.class, code = 200, message = "商户列表响应字段说明")
	})	
	@ApiOperation(value = "merchant-1 获取商户列表（可分页）")
	@GetMapping("/list")
	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(name = "page", value = "当前页码", defaultValue = "1", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", paramType = "query")
		}
	) */
	//@formatter:on
	public Result list(@ApiParam(hidden = true) @RequestParam Map<String, Object> params) {
		PageUtils page = merchantService.queryPage(params);

		return Result.ok().put("page", page);
	}

	/**
	 * 信息

	@ApiOperation(value = "merchant-2 根据商户ID获取商户信息")
	@GetMapping("/info/{merchantId}")

	//@formatter:off
	@ApiImplicitParams(
		value = {
			@ApiImplicitParam(name = "merchantId", value = "商户ID", defaultValue = "1", paramType = "path"),
		}
	) */
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

	@ApiOperation(value = "merchant-4 修改商户信息")
	@PutMapping("/update")*/
	public Result update(@RequestBody MerchantEntity merchant) {
		ValidatorUtils.validateEntity(merchant);
		merchantService.updateById(merchant);

		return Result.ok();
	}

	/**
	 * 删除

	@ApiOperation(value = "merchant-5 删除指定ID的商户")
	@DeleteMapping("/delete") */
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
