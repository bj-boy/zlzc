package com.zlzc.modules.statistics.controller;

import com.zlzc.common.annotation.RespTime;
import com.zlzc.common.utils.Result;
import com.zlzc.modules.statistics.restType.*;
import com.zlzc.modules.statistics.service.StatisticsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 功能描述:今日销售总额，昨日销售总额，近7天销售总额,关于钱的暂时未写,关于退货的暂时未写
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.statistics.controller
 * @ClassName: SumhomeController
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2019/12/14 15:38
 * @Version: 1.0
 */
@Api(value = "后台-首页-统计", tags = {"V1.0 statistics：后台-首页统计示相关接口"})
@RestController
@RequestMapping("statisticsOrder")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;


    /**
     * @描述:statistics-1  后台-首页统计-今日订单总数[根据商户ID获取系统首页显示的信息(条数)]
     * @Method: OrderTotal
     * @Author: LBB
     * @E-mail: biaobiao999@163.com
     * @Version: 1.0
     * @Date:  2019/12/25 17:03
     */

    @ApiOperation(value = "statistics-1  后台-首页统计-今日订单总数")
    //@RequestMapping(value="/statisticsOrder/“merchantId",method= RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(response = dayOrderTotalRT.class, code = 200, message = "后台-首页统计-今日订单总数响应字段说明")
    })
    @RespTime("/statisticsOrder/dayOrderTotal")
    @GetMapping("/dayOrderTotal/{merchantId}")
    // @formatter:off
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "merchantId", value = "商户ID", defaultValue = "1", paramType = "path"),})
    // @formatter:on
    public Result dayOrderTotal(@PathVariable("merchantId") Integer merchantId) {
//        OrderEntity orderEntity = statisticsService.getById(merchntId);
        Map<String, Object> rsMap = statisticsService.dayOrderTotal(merchantId);
        return Result.ok().put("rs", rsMap);
    }

    /**
     * @描述:statistics-2  后台-首页统计-本周订单数量
     * @Method: weekOrderTotal
     * @Author: LBB
     * @E-mail: biaobiao999@163.com
     * @Version: 1.0
     * @Date:  2019/12/25 17:04
     */
    @ApiOperation(value = "statistics-2  后台-首页统计-本周订单数量")
    //@RequestMapping(value="/statisticsOrder/“merchantId",method= RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(response = weekOrderTotalRT.class, code = 200, message = "后台-首页统计-本周订单数量响应字段说明")
    })
    @RespTime("/statisticsOrder/weekOrderTotal")
    @GetMapping("/weekOrderTotal/{merchantId}")
    // @formatter:off
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "merchantId", value = "商户ID", defaultValue = "1", paramType = "path"),})
    // @formatter:on
    public Result weekOrderTotal(@PathVariable("merchantId") Integer merchantId) {
//        OrderEntity orderEntity = statisticsService.getById(merchntId);
        Map<String, Object> rsMap = statisticsService.weekOrderTotal(merchantId);
        return Result.ok().put("rs", rsMap);
    }

    /**
     * @描述:statistics-3  后台-首页统计-本月订单数量
     * @Method: mothOrderTotal
     * @Author: LBB
     * @E-mail: biaobiao999@163.com
     * @Version: 1.0
     * @Date:  2019/12/25 17:06
     */
    @ApiOperation(value = "statistics-3  后台-首页统计-本月订单数量")
    //@RequestMapping(value="/statisticsOrder/“merchantId",method= RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(response = mothOrderTotalRT.class, code = 200, message = "后台-首页统计-本月订单数量响应字段说明")
    })
    @RespTime("/statisticsOrder/mothOrderTotal")
    @GetMapping("/mothOrderTotal/{merchantId}")
    // @formatter:off
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "merchantId", value = "商户ID", defaultValue = "1", paramType = "path"),})
    // @formatter:on
    public Result mothOrderTotal(@PathVariable("merchantId") Integer merchantId) {
//        OrderEntity orderEntity = statisticsService.getById(merchntId);
        Map<String, Object> rsMap = statisticsService.mothOrderTotal(merchantId);
        return Result.ok().put("rs", rsMap);
    }

    /**
     * @描述:statistics-4  后台-首页统计-本年订单数量
     * @Method: yearOrderTotal
     * @Author: LBB
     * @E-mail: biaobiao999@163.com
     * @Version: 1.0
     * @Date:  2019/12/25 17:08
     */
    @ApiOperation(value = "statistics-4  后台-首页统计-本年订单数量")
    //@RequestMapping(value="/statisticsOrder/“merchantId",method= RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(response = yearOrderTotalRT.class, code = 200, message = "后台-首页统计-本年订单数量响应字段说明")
    })
    @RespTime("/statisticsOrder/yearOrderTotal")
    @GetMapping("/yearOrderTotal/{merchantId}")
    // @formatter:off
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "merchantId", value = "商户ID", defaultValue = "1", paramType = "path"),})
    // @formatter:on
    public Result yearOrderTotal(@PathVariable("merchantId") Integer merchantId) {
//        OrderEntity orderEntity = statisticsService.getById(merchntId);
        Map<String, Object> rsMap = statisticsService.yearOrderTotal(merchantId);
        return Result.ok().put("rs", rsMap);
    }

    /**
     * @描述:statistics-5 后台-首页统计-待处理事务-待付款订单
     * @Method: selectStatistcsUntreated
     * @Author: LBB
     * @E-mail: biaobiao999@163.com
     * @Version: 1.0
     * @Date:  2019/12/24 14:07
     */
    @ApiOperation(value = "statistics-5  后台-首页统计-待处理事务")
    //@RequestMapping(value="/statisticsOrder/“merchantId",method= RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(response = pendingTransactionsRT.class, code = 200, message = "后台-首页统计-待处理事务响应字段说明")
    })
    @RespTime("/statisticsOrder/pendingTransactions")
    @GetMapping("/pendingTransactions/{merchantId}")
    // @formatter:off
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "merchantId", value = "商户ID", defaultValue = "1", paramType = "path"),})
    // @formatter:on
    public Result pendingTransactions(@PathVariable("merchantId") Integer merchantId) {
        Map<String, Object> rsMap = statisticsService.pendingTransactions(merchantId);
        return Result.ok().put("rs", rsMap);
    }
}
