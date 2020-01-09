package com.zlzc.api.rest.commodity.vo;

import com.zlzc.api.rest.commodity.entity.CommodityAttrEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class CommodityAttrPageVo extends CommodityAttrEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer paramCount;

	private Integer skuCount;

}
