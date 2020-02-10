package com.zlzc.modules.statistics.restType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 功能描述:
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.statistics.restType
 * @ClassName: mothOrderTotal
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2020/1/9 21:27
 * @Version: 1.0
 */
@ApiModel(description = "统计实体")
@Data
@Accessors(chain = true)
public class mothOrderTotalRT {
    @ApiModelProperty(name = "mothOrderTotal2", value = "月订单总数")
    private Integer mothOrderTotal;
}
