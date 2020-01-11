package com.zlzc.modules.commodity.vo;

import com.zlzc.modules.commodity.entity.CommodityAttrEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class CommodityAttrPageVo extends CommodityAttrEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(name = "paramCount", value = "参数数量统计")
	private Integer paramCount;
	@ApiModelProperty(name = "skuCount", value = "sku数量统计")
	private Integer skuCount;

}
