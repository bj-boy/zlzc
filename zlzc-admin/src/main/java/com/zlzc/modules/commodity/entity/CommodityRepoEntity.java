package com.zlzc.modules.commodity.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Data
@TableName("zlzc_commodity_repo")
@Accessors(chain = true)
public class CommodityRepoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 库存ID
	 */
	@ApiModelProperty(name = "repoId", value = "库存ID", example = "库存ID")
	@TableId
	private Long repoId;
	/**
	 * 商品库存
	 */
	@ApiModelProperty(name = "repoStock", value = "商品库存", example = "商品库存")
	private Integer repoStock;
	/**
	 * 库存预警值
	 */
	@ApiModelProperty(name = "repoPrewarning", value = "库存预警值", example = "库存预警值")
	private Integer repoPrewarning;
	/**
	 * 计量单位
	 */
	@ApiModelProperty(name = "repoUnit", value = "计量单位", example = "计量单位")
	private String repoUnit;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "updateTime", value = "更新时间", example = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "操作人")
	private String operator;
}
