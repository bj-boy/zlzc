package com.zlzc.api.rest.logistics.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 快递物流表
 */
@ApiModel(description = "用户地址管理")
@Data
@TableName("zlzc_address")
public class UserAddressEntity {

    //地址id
    @TableId
    @ApiModelProperty(name = "addressId", value = "地址id", example = "001")
    private  Long addressId;
    //用户id
    @ApiModelProperty(name = "userId", value = "用户id", example = "001")
    private  Long  userId;
     //收件人
     @ApiModelProperty(name = "addressRecipient", value = "收件人", example = "冷大仙")
    private String addressRecipient;
     //收件人手机号
     @ApiModelProperty(name = "addressRecipientPhone", value = "收件人手机号", example = "182****1521")
    private  String addressRecipientPhone;
    //收件人邮编
    @ApiModelProperty(name = "addressRecipientPostcode", value = "收件人邮编", example = "00001")
    private  String addressRecipientPostcode;
    //收件人地址
    @ApiModelProperty(name = "addressRecipientAddress", value = "收件人地址", example = "北京市房山区xxxxxxxxx")
    private  String addressRecipientAddress;
    //收件人默认
    @ApiModelProperty(name = "addressDefault", value = "收件人默认", example = "1")
    private  String  addressDefault;
    //创建时间
    @ApiModelProperty(name = "addressTime", value = "创建时间", example = "2020-1-9-15:33:51")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private  String  addressTime;

}
