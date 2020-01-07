package com.zlzc.modules.commodity.vo;

import java.io.Serializable;

import com.zlzc.modules.commodity.entity.CommodityAttrEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class CommodityAttrPageVo extends CommodityAttrEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer paramCount;

	private Integer skuCount;

}
