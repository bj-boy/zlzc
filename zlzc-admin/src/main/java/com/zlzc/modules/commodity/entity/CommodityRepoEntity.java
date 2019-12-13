package com.zlzc.modules.commodity.entity;

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
	@ApiModelProperty(name = "repoId", value = "库存ID", example = "1")
	@TableId
	private Long repoId;
	/**
	 * 商品库存
	 */
	@ApiModelProperty(name = "repoStock", value = "商品库存", example = "1000")
	private Integer repoStock;
	/**
	 * 库存预警值
	 */
	@ApiModelProperty(name = "repoPrewarning", value = "库存预警值", example = "100")
	private Integer repoPrewarning;
	/**
	 * 计量单位
	 */
	@ApiModelProperty(name = "repoUnit", value = "计量单位", example = "个")
	private String repoUnit;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "updateTime", value = "更新时间", example = "2019-12-01 12:12:45")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "admin")
	private String operator;
}
