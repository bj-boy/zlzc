package com.zlzc.modules.order.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 */
@ApiModel(description = "订单表实体")
@Data
@TableName("zlzc_order")
@Accessors(chain = true)
public class OrderEntity implements Serializable {
    /**
     * 订单id
     */
    @ApiModelProperty(name = "orderId", value = "订单id", example = "001")
    @TableId
    private  Long   orderId;
    /**
     * 商品id
     */
    @ApiModelProperty(name = "commobityId", value = "商品id", example = "001")
     private  Long  commobityId;
    /**
     * 店铺id
     */
    @ApiModelProperty(name = "shopId", value = "店铺id", example = "001")
     private  Long shopId;
    /**
     * 用户id
     */
    @ApiModelProperty(name = "userId", value = "用户id", example = "001")
     private Long userId;
    /**
     * 商户id
     */
    @ApiModelProperty(name = "merchntId", value = "商户id", example = "001")
     private  Long merchntId;
    /**
     * 订单编号
     */
    @ApiModelProperty(name = "orderNumber", value = "订单编号", example = "001")
     private String orderNumber;
    /**
     * 订单金额
     */
    @ApiModelProperty(name = "orderAmount", value = "订单金额", example = "001")
     private BigDecimal  orderAmount;
    /**
     * 订单应付款金额
     */
    @ApiModelProperty(name = "orderPayable", value = "订单应付款金额", example = "001")
     private BigDecimal orderPayable;
    /**
     * 商品合计金额
     */
    @ApiModelProperty(name = "orderCommodityTotalAmount", value = "商品合计金额", example = "001")
     private BigDecimal orderCommodityTotalAmount;
    /**
     * 订单总金额
     */
    @ApiModelProperty(name = "orderTotalAmount", value = "订单总金额", example = "001")
     private BigDecimal orderTotalAmount;
    /**
     * 订单件数
     */
    @ApiModelProperty(name = "orderNumberPieces", value = "订单件数", example = "001")
     private Integer orderNumberPieces;
    /**
     * 支付状态
     */
    @ApiModelProperty(name = "orderPaymentStatus", value = "支付状态", example = "001")
     private Integer orderPaymentStatus;
    /**
     *支付方式
     */
    @ApiModelProperty(name = "orderPaymentMethod", value = "支付方式", example = "001")
     private Integer orderPaymentMethod;
    /**
     * 订单来源
     */
    @ApiModelProperty(name = "orderSource", value = "订单来源", example = "001")
     private Integer  orderSource;
    /**
     * 订单状态
     */
    @ApiModelProperty(name = "orderStatus", value = "订单状态", example = "001")
     private Integer orderStatus;
    /**
     * 订单类型
     */
    @ApiModelProperty(name = "orderOrderType", value = "订单类型", example = "001")
     private String orderOrderType;
    /**
     * 备注
     */
    @ApiModelProperty(name = "orderRemark", value = "备注", example = "001")
     private Integer orderRemark;
    /**
     * 提交时间
     */
    @ApiModelProperty(name = "orderSubmissionTime", value = "提交时间", example = "2019-12-01 12:12:45")
     private Date orderSubmissionTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(name = "orderEndTime", value = "结束时间", example = "2019-12-01 12:12:45")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
     private Date orderEndTime;
    /**
     * 完成时间
     */
    @ApiModelProperty(name = "orderCompleteTime", value = "完成时间", example = "2019-12-01 12:12:45")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
     private Date orderCompleteTime;


    /**
     * 删除标识
     */
    @ApiModelProperty(name = "orderRemove", value = "删除标识", example = "0")
    private  Integer orderRemove;

}
