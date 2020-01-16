package com.zlzc.modules.commodity.respType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommodityStatisticsByStatusRT {

	@ApiModelProperty(name = "cnt", value = "数量", example = "1")
	private Integer cnt;
	
	@ApiModelProperty(name = "status", value = "状态", example = "1")
	private Integer status;
	
}
