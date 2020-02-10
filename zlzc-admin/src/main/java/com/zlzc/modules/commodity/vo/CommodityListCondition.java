package com.zlzc.modules.commodity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述:
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.commodity.vo
 * @ClassName: CommodityListCondition
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2020/1/11 10:54
 * @Version: 1.0
 */
@Data
public class CommodityListCondition implements Serializable {

    /**
     * 商品货号
     */
    @ApiModelProperty(name = "commodityNo", value = "商品货号", example = "商品货号")
    private Long commodityNo;

    /**
     * 商品名称
     */
    @ApiModelProperty(name = "commodityName", value = "商品名称", example = "商品名称")
    private String commodityName;

    /**
     * 店铺名称
     */
    @ApiModelProperty(name = "shopName", value = "店铺名称", example = "店铺名称")
    private String shopName;

    /**
     * 商户名称
     */
    @ApiModelProperty(name = "merchantName", value = "商户名称", example = "商户名称")
    private String merchantName;

    /**
     * 商品分类ID
     */
    @ApiModelProperty(name = "commodityCategoryId", value = "商品分类ID", example = "商品分类ID")
    private Long commodityCategoryId;


    /**
     * 商品状态
     */
    @ApiModelProperty(name = "commodityStatus", value = "商品状态", example = "商品状态")
    private Integer commodityStatus;

}
