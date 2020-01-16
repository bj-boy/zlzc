package com.zlzc.api.rest.commodity.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品-推荐
 *
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-17 15:53:14
 */
@ApiModel(description = "商品-推荐")
@Data
@TableName("zlzc_commodity_recommend")
public class CommodityRecommendEntity implements Serializable {
    /**
     * id
     */
    @TableId
    @ApiModelProperty(name = "recommendId", value = "推荐id", example = "1")
    private Long recommendId;
    /**
     * 商品id
     */
    @ApiModelProperty(name = "commodityId", value = "商品id", example = "1")
    private Long commodityId;
    /**
     * 推荐状态
     */
    @ApiModelProperty(name = "recommendStatus", value = "推荐状态", example = "1")
    private Integer recommendStatus;
    /**
     * 操作人
     */
    @ApiModelProperty(name = "recommendOperator", value = "操作人", example = "李彪彪")
    private String recommendOperator;
    /**
     * 备注
     */
    @ApiModelProperty(name = "recommendRemark", value = "备注", example = "xxx商品加入每日")
    private String recommendRemark;
    /**
     * 操作时间
     */
    @ApiModelProperty(name = "recommendOperatingTime", value = "操作时间", example = "2020年1月9日17:19:13")
    private Date   recommendOperatingTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(name = "recommendUpdateTime", value = "更新时间", example = "2020年1月9日17:19:21")
    private Date   recommendUpdateTime;
    /**
     * 删除标识
     */
    @ApiModelProperty(name = "recommendDelete", value = "删除标识", example = "1")
    private Integer  recommendDelete;





}
