package com.zlzc.modules.commodity.respType;

import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述:
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.commodity.respType
 * @ClassName: commodityStatusStatisticsRT
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2020/1/9 16:26
 * @Version: 1.0
 */
public class commodityStatusStatisticsRT {
    @ApiModelProperty(name = "cnt", value = "数量", example = "1")
    private Integer cnt;

    @ApiModelProperty(name = "status", value = "状态", example = "1")
    private Integer status;
}
