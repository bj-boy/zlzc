package com.zlzc.modules.commodity.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CommodityLabelVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(name = "labelList", value = "商品标签列表 商品标签  0：上架；1：下架；2：新品；3：推荐", example = "[1,2,3]")
	private List<String> labelList;
	
}
