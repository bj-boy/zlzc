package com.zlzc.modules.statistics.entity;

import com.zlzc.modules.merchant.entity.MerchantEntity;
import com.zlzc.modules.order.entity.OrderEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 功能描述:
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.statistics.entity.vo
 * @ClassName: StatisticsEntityVo
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2019/12/15 14:59
 * @Version: 1.0
 */
@ApiModel(description = "统计实体")
@Data
@Accessors(chain = true)
public class StatisticsEntityVo extends OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 首页订单相关查询
     */
    private MerchantEntity merchantEntity;
    // private Integer count;
    /**
     * @描述:首页统计-待处理事务-今日订单总数
     * @Author: LBB
     * @E-mail: biaobiao999@163.com
     * @Version: 1.0
     * @Date: 2019/12/24 16:04
     */
    @ApiModelProperty(name = "dayOrderTotal", value = "首页统计-待处理事务-今日订单总数")
    private Integer todayOrderTotal;
    /**
     * @描述:首页统计-待处理事务-0待付款订单总数
     * @Author: LBB
     * @E-mail: biaobiao999@163.com
     * @Version: 1.0
     * @Date: 2019/12/24 16:04
     */
    @ApiModelProperty(name = "dayOrderTotal", value = "首页统计-待处理事务-0待付款订单总数")
    private Integer unpaidOrder;

    /**
     * @描述:首页统计-待处理事务-1已付款订单总数
     * @Author: LBB
     * @E-mail: biaobiao999@163.com
     * @Version: 1.0
     * @Date: 2019/12/24 16:04
     */
    @ApiModelProperty(name = "dayOrderTotal", value = "首页统计-待处理事务-2已付款订单总数")
    private Integer paidOrder;
    /**
     * @描述:首页统计-待处理事务-2已发货订单总数
     * @Author: LBB
     * @E-mail: biaobiao999@163.com
     * @Version: 1.0
     * @Date: 2019/12/24 16:04
     */
    @ApiModelProperty(name = "dayOrderTotal", value = "首页统计-待处理事务-2已发货订单总数")
    private Integer filledOrder;
    /**
     * @描述:首页统计-待处理事务-3已完成订单总数
     * @Author: LBB
     * @E-mail: biaobiao999@163.com
     * @Version: 1.0
     * @Date: 2019/12/24 16:04
     */
    @ApiModelProperty(name = "dayOrderTotal", value = "首页统计-待处理事务-3已完成订单总数")
    private Integer completedOrder;




//
//    /**
//     * @描述:首页统计-待处理事务-待处理退货订单(未发货要退款/取消订单)
//     * @Author: LBB
//     * @E-mail: biaobiao999@163.com
//     * @Version: 1.0
//     * @Date: 2019/12/24 16:04
//     */
//    private Integer ReturnableOrder;
//    /**
//     * @描述:首页统计-待处理事务-待确认退货订单(已发货要退款)
//     * @Author: LBB
//     * @E-mail: biaobiao999@163.com
//     * @Version: 1.0
//     * @Date: 2019/12/24 16:04
//     */
//    private Integer ReturnableOrderLogistics;


}
