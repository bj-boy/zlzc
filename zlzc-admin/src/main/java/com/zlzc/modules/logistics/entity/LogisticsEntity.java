package com.zlzc.modules.logistics.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.shiro.io.Serializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 快递物流表
 */
@ApiModel(description = "快递物流实体")
@Data
@TableName("zlzc_logistics")
public class LogisticsEntity implements Serializable{

    /**
     * 物流id
     */
    @ApiModelProperty(name = "logisticsId", value = "物流id", example = "001")
    @TableId
    private Long logisticsId;
    /**
     * 订单编号
     */
    @ApiModelProperty(name = "orderNumber", value = "订单编号", example = "")
    private String orderNumber;
    /**
     * 物流名称
     */
    @ApiModelProperty(name = "logisticsName", value = "物流名称", example = "顺丰快递")
    private String logisticsName;
    /**
     * 配送方式
     */
    @ApiModelProperty(name = "logisticsDelivery", value = "配送方式", example = "1")
    private Integer logisticsDelivery;
    /**
     * 寄件人
     */
    @ApiModelProperty(name = "logisticsSender", value = "寄件人", example = "李xx")
    private String  logisticsSender;
    /**
     * 寄件人手机
     */
    @ApiModelProperty(name = "logisticsSenderPhone", value = "寄件人手机", example = "182****0041")
    private String  logisticsSenderPhone;
    /**
     * 寄件人账号
     */
    @ApiModelProperty(name = "logisticsSenderAccount", value = "寄件人账号", example = "876438453")
    private String  logisticsSenderAccount;
    /**
     * 寄件人地址
     */
    @ApiModelProperty(name = "logisticsSenderAddress", value = "寄件人地址", example = "北京市高碑店")
    private String  logisticsSenderAddress;
    /**
     * 寄件人邮编
     */
    @ApiModelProperty(name = "logisticsSenderPostcode", value = "寄件人邮编", example = "100xxx")
    private String  logisticsSenderPostcode;
    /**
     * 寄件人公司地址
     */
    @ApiModelProperty(name = "logisticsSenderCompanyAddress", value = "寄件人公司地址", example = "广州")
    private String  logisticsSenderCompanyAddress;
    /**
     * 快递单号
     */
    @ApiModelProperty(name = "logisticsSingleNumber", value = "快递单号", example = "KD989586")
    private String  logisticsSingleNumber;
    /**
     * 发货物流单号
     */
    @ApiModelProperty(name = "logisticsSerialNumber", value = "发货物流单号", example = "QWEQEW1325321")
    private String  logisticsSerialNumber;
    /**
     * 收件人
     */
    @ApiModelProperty(name = "logisticsRecipient", value = "收件人", example = "于xx")
    private String  logisticsRecipient;
    /**
     * 收件人手机号
     */
    @ApiModelProperty(name = "logisticsRecipientPhone", value = "收件人手机号", example = "183***6531")
    private String  logisticsRecipientPhone;
    /**
     * 收件人账号
     */
    @ApiModelProperty(name = "logisticsRecipientAccount", value = "收件人账号", example = "864132685431")
    private String  logisticsRecipientAccount;
    /**
     * 收件人地址
     */
    @ApiModelProperty(name = "logisticsRecipientAddress", value = "收件人地址", example = "吉林省****")
    private String  logisticsRecipientAddress;
    /**
     * 收件人邮编
     */
    @ApiModelProperty(name = "logisticsRecipientPostcode", value = "收件人邮编", example = "1204")
    private String  logisticsRecipientPostcode;
    /**
     * 收件人公司地址
     */
    @ApiModelProperty(name = "logisticsRecipientCompanyAddress", value = "收件人公司地址", example = "xxxxxxxxx")
    private String  logisticsRecipientCompanyAddress;
    /**
     * 收件人证件号
     */
    @ApiModelProperty(name = "logisticsRecipientIdNumber", value = "收件人证件号", example = "25045****46560130")
    private String  logisticsRecipientIdNumber;

    /**
     * 默认收货
     */
    @ApiModelProperty(name = "logisticsReceiptStarts", value = "默认收货", example = "1")
    private Integer logisticsReceiptStarts;
    /**
     * 备注
     */
    @ApiModelProperty(name = "logisticsNote", value = "备注", example = "暂无")
    private String  logisticsNote;
    /**
     * 发货时间
     */
    @ApiModelProperty(name = "logisticsDeliveryTime", value = "发货时间", example = "2019-12-01 12:12:45")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date logisticsDeliveryTime;
    /**
     * 收货时间
     */
    @ApiModelProperty(name = "logisticsTimeReceipt", value = "收货时间", example = "2019-12-01 12:12:45")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date  logisticsTimeReceipt;
}
