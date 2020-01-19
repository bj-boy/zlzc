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
 * @ClassName: pendingTransactionsRT
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2020/1/9 21:33
 * @Version: 1.0
 */
@ApiModel(description = "统计实体")
@Data
@Accessors(chain = true)
public class pendingTransactionsRT {
    @ApiModelProperty(name = "unpaidOrder", value = "未付款订单数量")
    private Integer unpaidOrder;

    @ApiModelProperty(name = "paidOrder", value = "已付款订单数量")
    private Integer paidOrder;

    @ApiModelProperty(name = "filledOrder", value = "已发货订单数量")
    private Integer filledOrder;

    @ApiModelProperty(name = "completedOrder", value = "已完成订单数量")
    private Integer completedOrder;

}
